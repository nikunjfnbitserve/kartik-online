package com.example.kartikonlinefirebase.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kartikonlinefirebase.R;
import com.example.kartikonlinefirebase.models.Catalogue;
import com.example.kartikonlinefirebase.models.Product;
import com.example.kartikonlinefirebase.utils.Config;
import com.example.kartikonlinefirebase.viewholders.ProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.List;

import static com.example.kartikonlinefirebase.utils.Config.mStaticCatalogue;

public class CatalogueMain extends AppCompatActivity {

    private static final int REQUEST_IMAGE = 3;
    private Toolbar mToolbar;
    private TextView textGallery;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private DatabaseReference mFirebaseDatabaseReference;
    private EditText catalogueText;
    private Catalogue mCatalogue;
    private List<Catalogue> mCatalogueList;
    private FirebaseRecyclerAdapter<Product, ProductViewHolder> mFirebaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue_main);

        //Views initialisation
        textGallery = (TextView) findViewById(R.id.tv_add_gall);
        catalogueText = (EditText) findViewById(R.id.et_add_title);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Firebase instances initialisation
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();


        mCatalogue = new Catalogue();
        mCatalogueList = new ArrayList<>();


        SnapshotParser<Product> parser = new SnapshotParser<Product>() {
            @Override
            public Product parseSnapshot(DataSnapshot dataSnapshot) {
                Product product = dataSnapshot.getValue(Product.class);
                if (product != null) {
                    product.setProductId(dataSnapshot.getKey());
                }
                return product;
            }
        };

        DatabaseReference prodRef = mFirebaseDatabaseReference.child("catalogues");
        FirebaseRecyclerOptions<Product> options = new FirebaseRecyclerOptions.Builder<Product>()
                        .setQuery(prodRef, parser)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Product, ProductViewHolder>(options) {
            @Override
            public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new ProductViewHolder(inflater.inflate(R.layout.products_list_item, parent, false));
            }

            @Override
            protected void onBindViewHolder(ProductViewHolder productViewHolder, int i, Product product) {



            }
        };

        if (mFirebaseUser == null) {
            // Not signed in, launch the Sign In activity
//            startActivity(new Intent(this, SignInActivity.class));
//            finish();
//            return;
        }
//        else {
//            mUsername = mFirebaseUser.getDisplayName();
//            if (mFirebaseUser.getPhotoUrl() != null) {
//                mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
//            }
//        }

        textGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_IMAGE);

            }
        });

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "catalogue saved", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }

    public boolean onSupportNavigateUp() {

        onBackPressed();
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE){
            if(resultCode == RESULT_OK){
                if(data != null){
                    final Uri uri = data.getData();
                    Config.selectedImageUri = uri;
                    Log.d("CatalogueMain", "Uri: " + uri.toString());

                    //TODO : add firestore logic here
                    Product tempProduct = Config.getmStaticProduct();
                    mFirebaseDatabaseReference.child("products").push().setValue(tempProduct, new DatabaseReference.CompletionListener() {
                                @Override
                                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                    if(databaseError == null){
                                        String key = databaseReference.getKey();
                                        StorageReference storageReference = FirebaseStorage.getInstance()
                                                .getReference(mFirebaseUser.getUid())
                                                .child(key)
                                                .child(uri.getLastPathSegment());

                                        putImageInStorage(storageReference, uri, key);

                                    }else{
                                        Log.w("CatalogueMain", "unable to write message to database", databaseError.toException());
                                    }

                               }
                            });


                    startActivity(new Intent(this, EditProductInfoActivity.class));
                }
            }
        }
    }

    private void putImageInStorage(StorageReference storageReference, Uri uri, final String key) {
        storageReference.putFile(uri).addOnCompleteListener(CatalogueMain.this,
                new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(Task<UploadTask.TaskSnapshot> task) {
                        if (task.isSuccessful()) {
                            task.getResult().getMetadata().getReference().getDownloadUrl()
                                    .addOnCompleteListener(CatalogueMain.this, new OnCompleteListener<Uri>() {
                                                @Override
                                                public void onComplete(Task<Uri> task) {
                                                    if (task.isSuccessful()) {
                                                        Product product = new Product();
//                                                                        task.getResult().toString()
                                                        mFirebaseDatabaseReference.child("products").child(key).setValue(task.getResult().toString());
                                                    }
                                               }
                                            });
                        } else {
                            Log.w("CatalogueMain", "Image upload task was not successful.",
                                    task.getException());
                        }
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.catalogue_item_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();

        switch (itemId){

            case R.id.item_check:
                Toast.makeText(this, "catalogue saved", Toast.LENGTH_SHORT).show();
                saveCatalogue();
                return true;

            case R.id.item_publish:
                mStaticCatalogue.setIsPublished(true);


            default: return super.onOptionsItemSelected(item);
        }
    }

    private void saveCatalogue() {

        mStaticCatalogue.setCatalogueTitle(catalogueText.getText().toString());


    }


}
