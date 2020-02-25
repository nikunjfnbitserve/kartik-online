package com.example.kartikonlinefirebase.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.kartikonlinefirebase.models.Image;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductViewModel extends ViewModel {

    @SerializedName("productId")
    @Expose
    private String productId;

    @SerializedName("availableQuantity")
    @Expose
    private MutableLiveData<Integer> availableQuantity = new MutableLiveData<>();

    @SerializedName("cartonQuanity")
    @Expose
    private MutableLiveData<Integer> cartonQuanity = new MutableLiveData<>();

    @SerializedName("categoryName")
    @Expose
    private MutableLiveData<String> categoryName = new MutableLiveData<>();

    @SerializedName("color")
    @Expose
    private MutableLiveData<String> color = new MutableLiveData<>();

    @SerializedName("colorSelection")
    @Expose
    private MutableLiveData<String> colorSelection = new MutableLiveData<>();

    @SerializedName("description")
    @Expose
    private MutableLiveData<String> description = new MutableLiveData<>();

    @SerializedName("discountPrice")
    @Expose
    private MutableLiveData<Double> discountPrice = new MutableLiveData<>();

    @SerializedName("images")
    @Expose
    private MutableLiveData<List<ProductViewModel>> images = new MutableLiveData<>();

    @SerializedName("isOutOfStock")
    @Expose
    private MutableLiveData<Boolean> isOutOfStock = new MutableLiveData<>();

    @SerializedName("productName")
    @Expose
    private MutableLiveData<String> productName = new MutableLiveData<>();

    @SerializedName("price")
    @Expose
    private MutableLiveData<Integer> price = new MutableLiveData<>();

    @SerializedName("setQuantity")
    @Expose
    private MutableLiveData<Integer> setQuantity = new MutableLiveData<>();

    @SerializedName("size")
    @Expose
    private MutableLiveData<String> size = new MutableLiveData<>();

    @SerializedName("sizeSelection")
    @Expose
    private MutableLiveData<String> sizeSelection = new MutableLiveData<>();

    @SerializedName("soleName")
    @Expose
    private MutableLiveData<String> soleName = new MutableLiveData<>();

    @SerializedName("sortTags")
    @Expose
    private MutableLiveData<String> sortTags = new MutableLiveData<>();

    @SerializedName("type")
    @Expose
    private MutableLiveData<String> type = new MutableLiveData<>();

    @SerializedName("notes")
    @Expose
    private MutableLiveData<String> notes = new MutableLiveData<>();

    @SerializedName("videoUrl")
    @Expose
    private MutableLiveData<String> videoUrl = new MutableLiveData<>();

    @SerializedName("isShowOutOfStock")
    @Expose
    private MutableLiveData<Boolean> isShowOutOfStock = new MutableLiveData<>();

    @SerializedName("isForceAllowOrder")
    @Expose
    private MutableLiveData<Boolean> isForceAllowOrder = new MutableLiveData<>();

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public LiveData<Integer> getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity.setValue(availableQuantity);
    }

    public LiveData<Integer> getCartonQuanity() {
        return cartonQuanity;
    }

    public void setCartonQuanity(Integer cartonQuanity) {
        this.cartonQuanity.setValue(cartonQuanity);
    }

    public LiveData<String> getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName.setValue(categoryName);
    }

    public LiveData<String> getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color.setValue(color);
    }

    public LiveData<String> getColorSelection() {
        return colorSelection;
    }

    public void setColorSelection(String colorSelection) {
        this.colorSelection.setValue(colorSelection);
    }

    public LiveData<String> getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description.setValue(description);
    }

    public LiveData<Double> getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice.setValue(discountPrice);
    }

    public LiveData<List<ProductViewModel>> getImages() {
        return images;
    }

    public void setImages(List<ProductViewModel> images) {
        this.images.setValue(images);
    }

    public LiveData<Boolean> getIsOutOfStock() {
        return isOutOfStock;
    }

    public void setIsOutOfStock(Boolean isOutOfStock) {
        this.isOutOfStock.setValue(isOutOfStock);
    }

    public LiveData<String> getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName.setValue(productName);
    }

    public LiveData<Integer> getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price.setValue(price);
    }

    public LiveData<Integer> getSetQuantity() {
        return setQuantity;
    }

    public void setSetQuantity(Integer setQuantity) {
        this.setQuantity.setValue(setQuantity);
    }

    public LiveData<String> getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size.setValue(size);
    }

    public LiveData<String> getSizeSelection() {
        return sizeSelection;
    }

    public void setSizeSelection(String sizeSelection) {
        this.sizeSelection.setValue(sizeSelection);
    }

    public LiveData<String> getSoleName() {
        return soleName;
    }

    public void setSoleName(String soleName) {
        this.soleName.setValue(soleName);
    }

    public LiveData<String> getSortTags() {
        return sortTags;
    }

    public void setSortTags(String sortTags) {
        this.sortTags.setValue(sortTags);
    }

    public LiveData<String> getType() {
        return type;
    }

    public void setType(String type) {
        this.type.setValue(type);
    }

    public LiveData<String> getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes.setValue(notes);
    }

    public LiveData<String> getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl.setValue(videoUrl);
    }

    public LiveData<Boolean> getIsShowOutOfStock() {
        return isShowOutOfStock;
    }

    public void setIsShowOutOfStock(Boolean isShowOutOfStock) {
        this.isShowOutOfStock.setValue(isShowOutOfStock);
    }

    public LiveData<Boolean> getIsForceAllowOrder() {
        return isForceAllowOrder;
    }

    public void setIsForceAllowOrder(Boolean isForceAllowOrder) {
        this.isForceAllowOrder.setValue(isForceAllowOrder);
    }

}
