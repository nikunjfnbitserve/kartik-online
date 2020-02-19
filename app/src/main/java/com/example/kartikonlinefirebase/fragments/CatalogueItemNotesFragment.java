package com.example.kartikonlinefirebase.fragments;


import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.kartikonlinefirebase.R;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;


public class CatalogueItemNotesFragment extends Fragment {

    @BindView(R.id.tabs)
    EditText tabLayout;
    @BindView(R.id.v_pager_admin)
    EditText mViewPager;

    @BindView(R.id.toolbar)
    EditText toolbar;

    public CatalogueItemNotesFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_catalogue_item_notes, container, false);
        return view;
    }

}
