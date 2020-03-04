package com.example.kartikonlinefirebase.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Banner {

    @SerializedName("catalogueTitle")
    @Expose
    private String catalogueTitle;

    @SerializedName("catalogueTitle")
    @Expose
    private boolean isClickable;

    @SerializedName("positionOnUser")
    @Expose
    private String positionOnUser;

    @SerializedName("bannerImages")
    @Expose
    private List<Image> bannerImages = null;

    public String getCatalogueTitle() {
        return catalogueTitle;
    }

    public String getPositionOnUser() {
        return positionOnUser;
    }

    public void setPositionOnUser(String positionOnUser) {
        this.positionOnUser = positionOnUser;
    }

    public List<Image> getBannerImages() {
        return bannerImages;
    }

    public void setBannerImages(List<Image> bannerImages) {
        this.bannerImages = bannerImages;
    }

    public void setCatalogueTitle(String catalogueTitle) {
        this.catalogueTitle = catalogueTitle;
    }

    public boolean isClickable() {
        return isClickable;
    }

    public void setClickable(boolean clickable) {
        isClickable = clickable;
    }

    public String getPosition() {
        return positionOnUser;
    }

    public void setPosition(String position) {
        this.positionOnUser = position;
    }

}
