package com.example.kartikonlinefirebase.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category {

    @SerializedName("categoryId")
    @Expose
    private String categoryId;

    @SerializedName("categoryName")
    @Expose
    private String categoryName;

    @SerializedName("catagoryImages")
    @Expose
    private List<Image> catagoryImages = null;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Image> getCatagoryImages() {
        return catagoryImages;
    }

    public void setCatagoryImages(List<Image> catagoryImages) {
        this.catagoryImages = catagoryImages;
    }

}