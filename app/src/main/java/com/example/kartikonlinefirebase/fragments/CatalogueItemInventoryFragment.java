package com.example.kartikonlinefirebase.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.kartikonlinefirebase.R;
import com.example.kartikonlinefirebase.activities.EditProductInfoActivity;


public class CatalogueItemInventoryFragment extends Fragment {

    EditProductInfoActivity editProductInfoActivity;
    private Switch outOfStockSwitch, showOutOfStockSwitch, forceAllowOrderSwitch;
    private EditText availableQtyText;



    public CatalogueItemInventoryFragment() {

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_catalogue_item_inventory, container, false);

        editProductInfoActivity = (EditProductInfoActivity) getActivity();
        setHasOptionsMenu(true);

        outOfStockSwitch = (Switch) view.findViewById(R.id.switch_out_of_stock);
        showOutOfStockSwitch = (Switch) view.findViewById(R.id.switch_show_out_of_stock);
        forceAllowOrderSwitch = (Switch) view.findViewById(R.id.switch_force_allow_order);
        availableQtyText = (EditText) view.findViewById(R.id.et_available_qty);
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
                setItemInventoryInfo();
                Toast.makeText(getActivity(), "item info saved", Toast.LENGTH_SHORT).show();
                Log.e("CatalogueInfo", "item info saved " + editProductInfoActivity.product.getProductName());
                return true;


            default: break;
        }

        return false;
    }

    private void setItemInventoryInfo() {

        editProductInfoActivity.product.setAvailableQuantity(Integer.parseInt(availableQtyText.getText().toString()));
        editProductInfoActivity.product.setIsOutOfStock(outOfStockSwitch.isChecked());
        editProductInfoActivity.product.setIsShowOutOfStock(showOutOfStockSwitch.isChecked());
        editProductInfoActivity.product.setIsForceAllowOrder(forceAllowOrderSwitch.isChecked());
    }

}
