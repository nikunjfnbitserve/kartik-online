package com.example.kartikonlinefirebase.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kartikonlinefirebase.R;


public class AdminOtherFragment extends Fragment {


    public AdminOtherFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_admin_other, container, false);
    }

}
