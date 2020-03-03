package com.example.kartikonlinefirebase.fragments;


import android.os.Bundle;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import com.example.kartikonlinefirebase.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;


public class AdminOtherFragment extends Fragment implements View.OnClickListener {

    EditText addBanner, addCat, addSize, addColor, addQty, addSetQty, notify, myEditText;


    public AdminOtherFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_admin_other, container, false);

        addBanner = view.findViewById(R.id.et_add_banner);
        addCat = view.findViewById(R.id.et_add_cat);
        addSize = view.findViewById(R.id.et_add_size);
        addColor = view.findViewById(R.id.et_add_color);
        addQty = view.findViewById(R.id.et_add_qty);
        addSetQty = view.findViewById(R.id.et_add_set_qty);
        notify = view.findViewById(R.id.et_notify);


        View mView = getLayoutInflater().inflate(R.layout.dialog_add_attributes, null);
        myEditText = mView.findViewById(R.id.et_dialog_add_qty);
        myEditText.setHint("Hello");


        addBanner.setOnClickListener(this);
        addCat.setOnClickListener(this);
        addSize.setOnClickListener(this);
        addColor.setOnClickListener(this);
        addQty.setOnClickListener(this);
        addSetQty.setOnClickListener(this);
        notify.setOnClickListener(this);

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
                break;
            case R.id.et_add_cat:
                new MaterialAlertDialogBuilder(getContext())
                        .setTitle("Title")
                        .setMessage("Message")
                        .setPositiveButton("Ok", null)
                        .show();
                break;
            case R.id.et_notify:
                break;
            case R.id.et_add_size:
                new MaterialAlertDialogBuilder(getContext())
                        .setTitle("Title")
                        .setMessage("Message")
                        .setPositiveButton("Ok", null)
                        .show();
                break;
            case R.id.et_add_color:
                new MaterialAlertDialogBuilder(getContext())
                        .setTitle("Title")
                        .setMessage("Message")
                        .setPositiveButton("Ok", null)
                        .show();
                break;
            case R.id.et_add_qty:
                new MaterialAlertDialogBuilder(getContext())
                        .setTitle("Title")
                        .setView(R.layout.dialog_add_attributes)
                        .setPositiveButton("Save", null)
                        .setNegativeButton("Cancel", null)
                        .show();
                break;
            case R.id.et_add_set_qty:
                new MaterialAlertDialogBuilder(getContext())
                        .setTitle("Title")
                        .setMessage("Message")
                        .setPositiveButton("Ok", null)
                        .show();
                break;


        }
    }
}
