package com.example.kartikonlinefirebase.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quantity {

    @SerializedName("quantityId")
    @Expose
    private String quantityId;

    @SerializedName("quantity")
    @Expose
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getQuantityId() {
        return quantityId;
    }

    public void setQuantityId(String quantityId) {
        this.quantityId = quantityId;
    }

}
