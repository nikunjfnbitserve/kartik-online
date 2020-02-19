package com.example.kartikonlinefirebase.utils;

import com.example.kartikonlinefirebase.models.Catalogue;
import com.example.kartikonlinefirebase.models.Item;

import java.util.List;

public class Config {

    public static List<Item> mStaticProductList;
    public static Catalogue mStaticCatalogue;

    public static List<Item> getmStaticProductList() {
        return mStaticProductList;
    }

    public static void setmStaticProductList(List<Item> mStaticProductList) {
        Config.mStaticProductList = mStaticProductList;
    }

    public static Catalogue getmStaticCatalogue() {
        return mStaticCatalogue;
    }

    public static void setmStaticCatalogue(Catalogue mStaticCatalogue) {
        Config.mStaticCatalogue = mStaticCatalogue;
    }


}
