package com.example.kartikonlinefirebase.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Catalogue {

    @SerializedName("catalogueId")
    @Expose
    private String catalogueId;

    @SerializedName("catalogueTitle")
    @Expose
    private String catalogueTitle;

    @SerializedName("isPublished")
    @Expose
    private Boolean isPublished;

    @SerializedName("visitors")
    @Expose
    private Integer visitors;

    @SerializedName("products")
    @Expose
    private List<Product> products = null;

    public Catalogue(){

    }

    public String getCatalogueId() {
        return catalogueId;
    }

    public void setCatalogueId(String catalogueId) {
        this.catalogueId = catalogueId;
    }

    public String getCatalogueTitle() {
        return catalogueTitle;
    }

    public void setCatalogueTitle(String catalogueTitle) {
        this.catalogueTitle = catalogueTitle;
    }

    public Boolean getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Boolean isPublished) {
        this.isPublished = isPublished;
    }

    public Integer getVisitors() {
        return visitors;
    }

    public void setVisitors(Integer visitors) {
        this.visitors = visitors;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
