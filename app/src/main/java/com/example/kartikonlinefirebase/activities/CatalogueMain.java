package com.example.kartikonlinefirebase.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kartikonlinefirebase.R;
import com.example.kartikonlinefirebase.models.Catalogue;
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

public class CatalogueMain extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.catalogue_item_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        switch (itemId){

            case R.id.item_check:
                Toast.makeText(this, "item saved", Toast.LENGTH_SHORT).show();
                return true;

            default: return super.onOptionsItemSelected(item);
        }
    }

    public static class CatalogueViewHolder extends RecyclerView.ViewHolder {
        ImageView prodOneImage;
        ImageView prodTwoImage;
        ImageView prodThreeImage;
        ImageView prodFourImage;
        TextView catalogueText;
        Switch publishedSwitched;
        Button previewButton;
        Button editButton;

        //CircleImageView messengerImageView;

        public CatalogueViewHolder(View v) {
            super(v);
            prodOneImage = (ImageView) itemView.findViewById(R.id.ad_catbrand_img1);
            prodTwoImage = (ImageView) itemView.findViewById(R.id.ad_catbrand_img2);
            prodThreeImage = (ImageView) itemView.findViewById(R.id.ad_catbrand_img3);
            prodFourImage = (ImageView) itemView.findViewById(R.id.ad_catbrand_img4);
            catalogueText = (TextView) itemView.findViewById(R.id.tv_catalog_title);
            publishedSwitched = (Switch) itemView.findViewById(R.id.switch_published);
            previewButton = (Button) itemView.findViewById(R.id.btn_preview);
            editButton = (Button) itemView.findViewById(R.id.btn_edit);
            //messengerImageView = (CircleImageView) itemView.findViewById(R.id.messengerImageView);
        }
    }

    private static final int REQUEST_IMAGE = 3;

    private Toolbar mToolbar;
    private TextView textGallery;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private DatabaseReference mFirebaseDatabaseReference;
    private EditText catalogueText;
    private FirebaseRecyclerAdapter<Catalogue, CatalogueViewHolder> mFirebaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue_main);
        textGallery = (TextView) findViewById(R.id.tv_add_gall);
        catalogueText = (EditText) findViewById(R.id.et_add_title);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();

        SnapshotParser<Catalogue> parser = new SnapshotParser<Catalogue>() {
            @Override
            public Catalogue parseSnapshot(DataSnapshot dataSnapshot) {
                Catalogue catalogue = dataSnapshot.getValue(Catalogue.class);
                if (catalogue != null) {
                    catalogue.setCatalogueId(dataSnapshot.getKey());
                }
                return catalogue;
            }
        };

        DatabaseReference messagesRef = mFirebaseDatabaseReference.child("catalogues");
        FirebaseRecyclerOptions<Catalogue> options =
                new FirebaseRecyclerOptions.Builder<Catalogue>()
                        .setQuery(messagesRef, parser)
                        .build();

//        mFirebaseAdapter = new FirebaseRecyclerAdapter<Catalogue, CatalogueViewHolder>(options) {
//            @Override
//            public CatalogueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//                return new CatalogueViewHolder(inflater.inflate(R.layout.catalogue_list_item, parent, false));
//            }
//
//            @Override
//            protected void onBindViewHolder(CatalogueViewHolder catalogueViewHolder, int i, Catalogue catalogue) {
//
//            }
//        }

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
                    Log.d("CatalogueMain", "Uri: " + uri.toString());

                    //TODO : add firestore logic here
                    //FriendlyMessage tempMessage = new FriendlyMessage(null, mUsername, mPhotoUrl, LOADING_IMAGE_URL);
//                    mFirebaseDatabaseReference.child("items").push().setValue(tempMessage, new DatabaseReference.CompletionListener() {
//                                @Override
//                                public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
//                                    if(databaseError == null){
//                                        String key = databaseReference.getKey();
//                                        StorageReference storageReference = FirebaseStorage.getInstance()
//                                                .getReference(mFirebaseUser.getUid())
//                                                .child(key)
//                                                .child(uri.getLastPathSegment());
//
//                                        putImageInStorage(storageReference, uri, key);
//
//                                    }else{
//                                        Log.w("CatalogueMain", "unable to write message to database", databaseError.toException());
//                                    }
//
//                                }
//                            });

                    startActivity(new Intent(this, EditProductInfoActivity.class));
                }
            }
        }
    }

    private void putImageInStorage(StorageReference storageReference, Uri uri, final String key) {
        storageReference.putFile(uri).addOnCompleteListener(this, new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(Task<UploadTask.TaskSnapshot> task) {
                        if (task.isSuccessful()) {
//                            task.getResult().getMetadata().getReference().getDownloadUrl().addOnCompleteListener(this, new OnCompleteListener<Uri>() {
//                                                @Override
//                                                public void onComplete(Task<Uri> task) {
//                                                    if (task.isSuccessful()) {
//                                                        Catalogue catalogue =
//                                                                new Catalogue(null, mUsername, mPhotoUrl,
//                                                                        task.getResult().toString());
//                                                        mFirebaseDatabaseReference.child("catalogues").child(key)
//                                                                .setValue(catalogue);
//                                                    }
//                                                }
//                                            });
                        } else {
                            Log.w("CatalogueMain", "Image upload task was not successful.",
                                    task.getException());
                        }
                    }
                });
    }



}
