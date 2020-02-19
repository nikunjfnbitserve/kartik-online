package com.example.kartikonlinefirebase.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("itemId")
    @Expose
    private String itemId;
    @SerializedName("availableQuantity")
    @Expose
    private Integer availableQuantity;
    @SerializedName("cartonQuanity")
    @Expose
    private Integer cartonQuanity;
    @SerializedName("catagories")
    @Expose
    private List<Catagory> catagories = null;
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
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("isOutOfStock")
    @Expose
    private Boolean isOutOfStock;
    @SerializedName("itemName")
    @Expose
    private String itemName;
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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

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

    public List<Catagory> getCatagories() {
        return catagories;
    }

    public void setCatagories(List<Catagory> catagories) {
        this.catagories = catagories;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getIsOutOfStock() {
        return isOutOfStock;
    }

    public void setIsOutOfStock(Boolean isOutOfStock) {
        this.isOutOfStock = isOutOfStock;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

}