package com.example.kartikonlinefirebase.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Set {

    @SerializedName("setId")
    @Expose
    private String setId;

    @SerializedName("setQty")
    @Expose
    private int setQty;

    public int getSetQty() {
        return setQty;
    }

    public void setSetQty(int setQty) {
        this.setQty = setQty;
    }

    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

}
