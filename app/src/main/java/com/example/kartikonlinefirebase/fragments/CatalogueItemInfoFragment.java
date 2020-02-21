package com.example.kartikonlinefirebase.fragments;


import android.os.Bundle;

import androidx.core.app.NavUtils;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kartikonlinefirebase.R;
import com.example.kartikonlinefirebase.activities.EditProductInfoActivity;
import com.example.kartikonlinefirebase.models.Product;
import com.example.kartikonlinefirebase.utils.Config;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.kartikonlinefirebase.utils.Config.mStaticCatalogue;
import static com.example.kartikonlinefirebase.utils.Config.mStaticProduct;

public class CatalogueItemInfoFragment extends Fragment {



    private List<Product> productList;
    EditProductInfoActivity editProductInfoActivity;

    private EditText productNameText, productPriceText, productDiscountPriceText,
            productCartonQuantityText, productSetQuantityText,
            productSizeText, productSizeSelectionText, productColorText,
            productColorSelectionText, productCatagoryText, productSortTagsText,
            productGenderText,productSoleNameText, productDescriptionText ;






    public CatalogueItemInfoFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_catalogue_item_info, container, false);

        setHasOptionsMenu(true);

        editProductInfoActivity = (EditProductInfoActivity) getActivity();

        ButterKnife.bind(getActivity());

        if(Config.mStaticProductList.size() == 0){
            productList = new ArrayList<>();

        } else {
            productList = Config.getmStaticProductList();
            Log.e("static product list", "prev prod " +productList.isEmpty());
        }

        //TODO: get data from firebase for already existing items in a catalogue
        //TODO: set this data in respective Views if the user has come from an already created catalogue
        //TODO: create a spinner for categories
        //TODO: populate spinner array from firebase realtimedatabase
        //TODO: in AdminOtherFragment create categories to add to firebase realtimedatabase




        productNameText = (EditText) view.findViewById(R.id.et_item_name);
        productPriceText = (EditText) view.findViewById(R.id.et_item_price);
        productDiscountPriceText = (EditText) view.findViewById(R.id.et_item_disc_price);
        productCartonQuantityText = (EditText) view.findViewById(R.id.et_item_cn_qty);
        productSetQuantityText = (EditText) view.findViewById(R.id.et_item_set_qty);
        productSizeText = (EditText) view.findViewById(R.id.et_item_size);
        productSizeSelectionText = (EditText) view.findViewById(R.id.et_item_size_sel);
        productColorText = (EditText) view.findViewById(R.id.et_item_color);
        productColorSelectionText = (EditText) view.findViewById(R.id.et_item_color_sel);
        productCatagoryText = (EditText) view.findViewById(R.id.et_item_cat);
        productSortTagsText = (EditText) view.findViewById(R.id.et_item_sort_tags);
        productGenderText = (EditText) view.findViewById(R.id.et_item_gender);
        productSoleNameText = (EditText) view.findViewById(R.id.et_item_sole_name);
        productDescriptionText = (EditText) view.findViewById(R.id.et_item_desc);

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
                setItemFromItemForm();
                Toast.makeText(getActivity(), "item info saved", Toast.LENGTH_SHORT).show();
                Log.e("CatalogueInfo", "item info saved " + editProductInfoActivity.product.getProductName());
                return true;


            default: break;
        }

        return false;
    }

    public void setItemFromItemForm(){

        editProductInfoActivity.product.setProductName(productNameText.getText().toString());
        editProductInfoActivity.product.setPrice(Integer.parseInt(productPriceText.getText().toString()));
        editProductInfoActivity.product.setDiscountPrice(Double.parseDouble(productDiscountPriceText.getText().toString()));
        editProductInfoActivity.product.setCartonQuanity(Integer.parseInt(productCartonQuantityText.getText().toString()));
        editProductInfoActivity.product.setSetQuantity(Integer.parseInt(productSetQuantityText.getText().toString()));
        editProductInfoActivity.product.setSize(productSizeText.getText().toString());
        editProductInfoActivity.product.setSizeSelection(productSizeSelectionText.getText().toString());
        editProductInfoActivity.product.setColor(productColorText.getText().toString());
        editProductInfoActivity.product.setColorSelection(productColorSelectionText.getText().toString());
        editProductInfoActivity.product.setSortTags(productSortTagsText.getText().toString());
        editProductInfoActivity.product.setType(productGenderText.getText().toString());
        editProductInfoActivity.product.setSoleName(productSoleNameText.getText().toString());
        editProductInfoActivity.product.setDescription(productDescriptionText.getText().toString());
        editProductInfoActivity.product.setCategoryName(productCatagoryText.getText().toString());

//        productList.add(product);
//
//        Config.setmStaticProduct(product);
//        Config.setmStaticProductList(productList);

    }

}
