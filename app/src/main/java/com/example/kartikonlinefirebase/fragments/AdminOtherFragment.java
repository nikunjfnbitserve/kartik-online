package com.example.kartikonlinefirebase.fragments;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.example.kartikonlinefirebase.R;
import com.example.kartikonlinefirebase.models.Quantity;
import com.example.kartikonlinefirebase.models.Set;
import com.example.kartikonlinefirebase.models.Category;
import com.example.kartikonlinefirebase.models.Size;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import petrov.kristiyan.colorpicker.ColorPicker;

public class AdminOtherFragment extends Fragment implements View.OnClickListener {

    EditText addBanner, addCat, addSize, addColor, addQty, addSetQty, notify, myEditText;
    private FirebaseFirestore mFirestore;
    private Query mQuery;
    private CollectionReference quantityCollection, setCollection, categoryCollection, sizeCollection;
    private Quantity mQuantity;
    private Set mSet;
    private Category mCategory;
    private Size mSize;
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

        mFirestore = FirebaseFirestore.getInstance();
        //mQuery = mFirestore.collection("Quantity");

        quantityCollection = mFirestore.collection("quantities");
        setCollection = mFirestore.collection("sets");
        categoryCollection = mFirestore.collection("categories");
        sizeCollection = mFirestore.collection("sizes");

        mQuantity = new Quantity();
        mSet = new Set();
        mCategory = new Category();
        mSize = new Size();

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
                        .setTitle("Add Banner")
                        .setView(R.layout.dialog_add_attributes)
                        .setPositiveButton("Save", null)
                        .setNegativeButton("Cancel", null)
                        .show();
                break;
            case R.id.et_add_cat:
                new MaterialAlertDialogBuilder(getContext())
                        .setTitle("Add Category")
                        .setView(R.layout.dialog_add_attributes)
                        .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText addCategoryText = (EditText)((AlertDialog) dialog).findViewById(R.id.et_dialog);
                                if(!TextUtils.isEmpty(addCategoryText.getText().toString())){
                                    mCategory.setCategoryName(addCategoryText.getText().toString());
                                }
                                categoryCollection.add(mCategory);
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
                break;
            case R.id.et_notify:
                break;
            case R.id.et_add_size:
                new MaterialAlertDialogBuilder(getContext())
                        .setTitle("Add Size")
                        .setView(R.layout.dialog_add_attributes)
                        .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText sizeText = (EditText) ((AlertDialog) dialog).findViewById(R.id.et_dialog);
                                if(!TextUtils.isEmpty(sizeText.getText().toString())){
                                    mSize.setSize(sizeText.getText().toString());
                                }
                                sizeCollection.add(mSize);
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
                break;
            case R.id.et_add_color:
                /*new MaterialAlertDialogBuilder(getContext())
                        .setTitle("Add Color")
                        .setView(R.layout.dialog_add_attributes)
                        .setPositiveButton("Save", null)
                        .setNegativeButton("Cancel", null)
                        .show();*/

                final ColorPicker colorPicker = new ColorPicker(getActivity());
                colorPicker.setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position,int color) {
                        // put code
                    }

                    @Override
                    public void onCancel(){
                        // put code
                    }
                })
                        .addListenerButton("newButton", new ColorPicker.OnButtonListener() {
                            @Override
                            public void onClick(View v, int position, int color) {
                                // put code
                            }
                        })
                        .disableDefaultButtons(false)
                        .setDefaultColorButton(Color.parseColor("#f84c44"))
                        .setColumns(5)
                        .setRoundColorButton(true)
                        .setTitlePadding(0,0,0,14)
                        .show();

                break;
            case R.id.et_add_qty:
                new MaterialAlertDialogBuilder(getContext())
                        .setTitle("Add Quantity")
                        .setView(R.layout.dialog_add_attributes)
                        .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText addQuantityText = (EditText)((AlertDialog) dialog).findViewById(R.id.et_dialog);

                                if(!TextUtils.isEmpty(addQuantityText.getText().toString())){
                                    int qty = Integer.parseInt(addQuantityText.getText().toString());
                                    mQuantity.setQuantity(qty);
                                }
                                quantityCollection.add(mQuantity);
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
                break;
            case R.id.et_add_set_qty:
                new MaterialAlertDialogBuilder(getContext())
                        .setTitle("Add Set Quantity")
                        .setView(R.layout.dialog_add_attributes)
                        .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                EditText addSetText = (EditText)((AlertDialog) dialog).findViewById(R.id.et_dialog);

                                if(!TextUtils.isEmpty(addSetText.getText().toString())){
                                    int set = Integer.parseInt(addSetText.getText().toString());
                                    mSet.setSetQty(set);
                                }
                                setCollection.add(mSet);

                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
                break;


        }
    }
}
