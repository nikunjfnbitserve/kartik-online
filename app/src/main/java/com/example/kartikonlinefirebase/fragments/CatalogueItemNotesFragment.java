package com.example.kartikonlinefirebase.fragments;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
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
import com.example.kartikonlinefirebase.utils.Config;
import com.google.android.material.tabs.TabLayout;
import com.orhanobut.logger.Logger;

import static com.example.kartikonlinefirebase.utils.Config.mStaticProduct;

public class CatalogueItemNotesFragment extends Fragment {

    private EditText productNotesText;
    EditProductInfoActivity editProductInfoActivity;

    public CatalogueItemNotesFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_catalogue_item_notes, container, false);

        productNotesText = (EditText) view.findViewById(R.id.et_prod_notes);
        setHasOptionsMenu(true);
        editProductInfoActivity = (EditProductInfoActivity) getActivity();
        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_check:
                setItemMoreDetails();
                Config.setmStaticProduct(editProductInfoActivity.product);
                Toast.makeText(getActivity(), "item note saved", Toast.LENGTH_SHORT).show();
                Logger.e("CatalogueNotes "+ mStaticProduct.toString());
                return true;

            default: break;
        }

        return false;
    }

    private void setItemMoreDetails() {

        mStaticProduct.setNotes(productNotesText.getText().toString());

    }

}
