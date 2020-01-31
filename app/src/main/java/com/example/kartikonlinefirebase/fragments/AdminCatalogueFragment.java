package com.example.kartikonlinefirebase.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kartikonlinefirebase.R;


public class AdminCatalogueFragment extends Fragment {


    public AdminCatalogueFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_admin_catalogue, container, false);

        return view;
    }

}
