package com.example.kartikonlinefirebase.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kartikonlinefirebase.R;
import com.example.kartikonlinefirebase.models.Catalogue;
import com.example.kartikonlinefirebase.models.Item;
import com.example.kartikonlinefirebase.utils.Config;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CatalogueItemInfoFragment extends Fragment {


    private Item item;
    private List<Item> productList;

    @BindView(R.id.tv_item_name_label)
    TextView itemNameTextLabel;




    public CatalogueItemInfoFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_catalogue_item_info, container, false);

        ButterKnife.bind(getActivity());

        if(Config.mStaticProductList.size() == 0 && Config.mStaticProductList != null){

            productList = new ArrayList<>();
            item = new Item();
        } else {
            productList = Config.getmStaticProductList();
        }

        //TODO: get data from firebase for already existing items in a catalogue
        //TODO: set this data in respective Views if the user has come from an already created catalogue
        //TODO: create a spinner for categories
        //TODO: populate spinner array from firebase realtimedatabase
        //TODO: in AdminOtherFragment create categories to add to firebase realtimedatabase




        EditText itemNameText = (EditText) view.findViewById(R.id.et_item_name);
        EditText itemPriceText = (EditText) view.findViewById(R.id.et_item_price);
        EditText itemDiscountPriceText = (EditText) view.findViewById(R.id.et_item_disc_price);
        EditText itemCartonQuantityText = (EditText) view.findViewById(R.id.et_item_cn_qty);
        EditText itemSetQuantityText = (EditText) view.findViewById(R.id.et_item_set_qty);
        EditText itemSizeText = (EditText) view.findViewById(R.id.et_item_size);
        EditText itemSizeSelectionText = (EditText) view.findViewById(R.id.et_item_size_sel);
        EditText itemColorText = (EditText) view.findViewById(R.id.et_item_color);
        EditText itemColorSelectionText = (EditText) view.findViewById(R.id.et_item_color_sel);
        EditText itemCatagoryText = (EditText) view.findViewById(R.id.et_item_cat);
        EditText itemSortTagsText = (EditText) view.findViewById(R.id.et_item_sort_tags);
        EditText itemGenderText = (EditText) view.findViewById(R.id.et_item_gender);
        EditText itemSoleNameText = (EditText) view.findViewById(R.id.et_item_sole_name);
        EditText itemDescriptionText = (EditText) view.findViewById(R.id.et_item_desc);

        item.setItemName(itemNameText.getText().toString());
        item.setPrice(Integer.valueOf(itemPriceText.getText().toString()));
        item.setDiscountPrice(Double.valueOf(itemDiscountPriceText.getText().toString()));
        item.setCartonQuanity(Integer.valueOf(itemCartonQuantityText.getText().toString()));
        item.setSetQuantity(Integer.valueOf(itemSetQuantityText.getText().toString()));
        item.setSize(itemSizeText.getText().toString());
        item.setSizeSelection(itemSizeSelectionText.getText().toString());
        item.setColor(itemColorText.getText().toString());
        item.setColorSelection(itemColorSelectionText.getText().toString());
        item.setSortTags(itemSortTagsText.getText().toString());
        item.setType(itemGenderText.getText().toString());
        item.setSoleName(itemSoleNameText.getText().toString());
        item.setDescription(itemDescriptionText.getText().toString());

        productList.add(item);
        Config.setmStaticProductList(productList);



        return view;
    }

}
