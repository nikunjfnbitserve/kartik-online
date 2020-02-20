package com.example.kartikonlinefirebase.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Catagory {

    @SerializedName("categoryId")
    @Expose
    private String categoryId;

    @SerializedName("categoryName")
    @Expose
    private String categoryName;

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

}