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
    private MutableLiveData<Integer> availableQuantity = new MutableLiveData<>(0);

    @SerializedName("cartonQuanity")
    @Expose
    private MutableLiveData<Integer> cartonQuanity = new MutableLiveData<>(0);

    @SerializedName("categoryName")
    @Expose
    private MutableLiveData<String> categoryName = new MutableLiveData<>("Blank");

    @SerializedName("color")
    @Expose
    private MutableLiveData<String> color = new MutableLiveData<>("Blank");

    @SerializedName("colorSelection")
    @Expose
    private MutableLiveData<String> colorSelection = new MutableLiveData<>("Blank");

    @SerializedName("description")
    @Expose
    private MutableLiveData<String> description = new MutableLiveData<>("Blank");

    @SerializedName("discountPrice")
    @Expose
    private MutableLiveData<Double> discountPrice = new MutableLiveData<>(0.0);

    @SerializedName("images")
    @Expose
    private MutableLiveData<List<ProductViewModel>> images = new MutableLiveData<>();

    @SerializedName("isOutOfStock")
    @Expose
    private MutableLiveData<Boolean> isOutOfStock = new MutableLiveData<>(true);

    @SerializedName("productName")
    @Expose
    private MutableLiveData<String> productName = new MutableLiveData<>("Blank");

    @SerializedName("price")
    @Expose
    private MutableLiveData<Integer> price = new MutableLiveData<>(0);

    @SerializedName("setQuantity")
    @Expose
    private MutableLiveData<Integer> setQuantity = new MutableLiveData<>(0);

    @SerializedName("size")
    @Expose
    private MutableLiveData<String> size = new MutableLiveData<>("0-0");

    @SerializedName("sizeSelection")
    @Expose
    private MutableLiveData<String> sizeSelection = new MutableLiveData<>("Blank");

    @SerializedName("soleName")
    @Expose
    private MutableLiveData<String> soleName = new MutableLiveData<>("Blank");

    @SerializedName("sortTags")
    @Expose
    private MutableLiveData<String> sortTags = new MutableLiveData<>("Blank");

    @SerializedName("type")
    @Expose
    private MutableLiveData<String> type = new MutableLiveData<>("Blank");

    @SerializedName("notes")
    @Expose
    private MutableLiveData<String> notes = new MutableLiveData<>("Blank");

    @SerializedName("videoUrl")
    @Expose
    private MutableLiveData<String> videoUrl = new MutableLiveData<>("Blank");

    @SerializedName("isShowOutOfStock")
    @Expose
    private MutableLiveData<Boolean> isShowOutOfStock = new MutableLiveData<>(true);

    @SerializedName("isForceAllowOrder")
    @Expose
    private MutableLiveData<Boolean> isForceAllowOrder = new MutableLiveData<>(false);

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
