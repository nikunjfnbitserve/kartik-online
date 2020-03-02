package com.example.kartikonlinefirebase.fragments;


import android.os.Bundle;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.kartikonlinefirebase.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;


public class AdminOtherFragment extends Fragment implements View.OnClickListener {

    EditText addBanner;


    public AdminOtherFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_admin_other, container, false);

        addBanner = view.findViewById(R.id.et_add_banner);
        addBanner.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_add_banner:
                new MaterialAlertDialogBuilder(getContext())
                        .setTitle("Title")
                        .setMessage("Message")
                        .setPositiveButton("Ok", null)
                        .show();


        }
    }
}
