package com.example.kartikonlinefirebase.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kartikonlinefirebase.R;


public class CatalogueItemInventoryFragment extends Fragment {


    public CatalogueItemInventoryFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_catalogue_item_inventory, container, false);
        return view;
    }

}
