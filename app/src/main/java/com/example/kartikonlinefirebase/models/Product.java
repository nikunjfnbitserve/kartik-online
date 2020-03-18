package com.example.kartikonlinefirebase.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("availableQuantity")
    @Expose
    private Integer availableQuantity;
    @SerializedName("cartonQuanity")
    @Expose
    private Integer cartonQuanity;
    @SerializedName("categoryName")
    @Expose
    private String categoryName;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("colorSelection")
    @Expose
    private String colorSelection;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("discountPrice")
    @Expose
    private Double discountPrice;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("isOutOfStock")
    @Expose
    private Boolean isOutOfStock;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("setQuantity")
    @Expose
    private Integer setQuantity;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("sizeSelection")
    @Expose
    private String sizeSelection;
    @SerializedName("soleName")
    @Expose
    private String soleName;
    @SerializedName("sortTags")
    @Expose
    private String sortTags;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("videoUrl")
    @Expose
    private String videoUrl;
    @SerializedName("isShowOutOfStock")
    @Expose
    private Boolean isShowOutOfStock;
    @SerializedName("isForceAllowOrder")
    @Expose
    private Boolean isForceAllowOrder;


    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Integer getCartonQuanity() {
        return cartonQuanity;
    }

    public void setCartonQuanity(Integer cartonQuanity) {
        this.cartonQuanity = cartonQuanity;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColorSelection() {
        return colorSelection;
    }

    public void setColorSelection(String colorSelection) {
        this.colorSelection = colorSelection;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Boolean getIsOutOfStock() {
        return isOutOfStock;
    }

    public void setIsOutOfStock(Boolean isOutOfStock) {
        this.isOutOfStock = isOutOfStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSetQuantity() {
        return setQuantity;
    }

    public void setSetQuantity(Integer setQuantity) {
        this.setQuantity = setQuantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizeSelection() {
        return sizeSelection;
    }

    public void setSizeSelection(String sizeSelection) {
        this.sizeSelection = sizeSelection;
    }

    public String getSoleName() {
        return soleName;
    }

    public void setSoleName(String soleName) {
        this.soleName = soleName;
    }

    public String getSortTags() {
        return sortTags;
    }

    public void setSortTags(String sortTags) {
        this.sortTags = sortTags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Boolean getIsShowOutOfStock() {
        return isShowOutOfStock;
    }

    public void setIsShowOutOfStock(Boolean isShowOutOfStock) {
        this.isShowOutOfStock = isShowOutOfStock;
    }

    public Boolean getIsForceAllowOrder() {
        return isForceAllowOrder;
    }

    public void setIsForceAllowOrder(Boolean isForceAllowOrder) {
        this.isForceAllowOrder = isForceAllowOrder;
    }

}