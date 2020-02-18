package com.example.kartikonlinefirebase.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kartikonlinefirebase.R;
import com.example.kartikonlinefirebase.activities.CatalogueItemInfo;
import com.example.kartikonlinefirebase.activities.CatalogueMain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class AdminCatalogueFragment extends Fragment {

    private FloatingActionButton fab;


    public AdminCatalogueFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_admin_catalogue, container, false);

        fab = (FloatingActionButton) view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CatalogueMain.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
