package com.example.kartikonlinefirebase.fragments;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import com.example.kartikonlinefirebase.R;
import com.example.kartikonlinefirebase.activities.EditProductInfoActivity;
import com.example.kartikonlinefirebase.interfaces.OnMenuSaveButonClickListener;
import com.example.kartikonlinefirebase.models.Product;
import com.example.kartikonlinefirebase.utils.Config;
import com.example.kartikonlinefirebase.viewmodels.ProductViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.orhanobut.logger.Logger;

import static com.example.kartikonlinefirebase.utils.Config.mStaticProduct;

public class CatalogueItemNotesFragment extends Fragment implements OnMenuSaveButonClickListener {

    private EditText productNotesText;

    private ProductViewModel productViewModel;

    EditProductInfoActivity editProductInfoActivity;
    private DatabaseReference mFirebaseDatabaseReference;

    public CatalogueItemNotesFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productViewModel = ViewModelProviders.of(requireActivity()).get(ProductViewModel.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_catalogue_item_notes, container, false);

        productNotesText = (EditText) view.findViewById(R.id.et_prod_notes);
//        setHasOptionsMenu(true);
        editProductInfoActivity = (EditProductInfoActivity) getActivity();
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        return view;
    }


//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()){
//            case R.id.item_check:
//                setItemMoreDetails();
//                Config.setmStaticProduct(editProductInfoActivity.product);
//                Toast.makeText(getActivity(), "item note saved", Toast.LENGTH_SHORT).show();
//                Logger.e("CatalogueNotes "+ productViewModel.getProductName().getValue());
//                return true;
//
//            default: break;
//        }
//
//        return false;
//    }

    private void setItemMoreDetails() {

        //mStaticProduct.setNotes(productNotesText.getText().toString());
        Logger.e("CatalogueNotes "+ productViewModel.getProductName().getValue());

        productViewModel.setNotes(productNotesText.getText().toString());
        mStaticProduct.setNotes(productViewModel.getNotes().getValue());



        mFirebaseDatabaseReference.child("products").push().setValue(mStaticProduct, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if(databaseError == null){
                    String key = databaseReference.getKey();

                }else{
                    Log.w("CatalogueMain", "unable to write message to database", databaseError.toException());
                }
            }
        });


    }

    @Override
    public void onMenuButonClick() {
        setItemMoreDetails();
    }
}
