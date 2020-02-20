package com.example.kartikonlinefirebase.utils;

import com.example.kartikonlinefirebase.models.Catalogue;
import com.example.kartikonlinefirebase.models.Product;

import java.util.List;

public class Config {

    public static Product mStaticProduct;
    public static List<Product> mStaticProductList;
    public static List<Catalogue> mCatalogueList;

    public static Product getmStaticProduct() {
        return mStaticProduct;
    }

    public static void setmStaticProduct(Product mStaticProduct) {
        Config.mStaticProduct = mStaticProduct;
    }

    public static List<Catalogue> getmCatalogueList() {
        return mCatalogueList;
    }

    public static void setmCatalogueList(List<Catalogue> mCatalogueList) {
        Config.mCatalogueList = mCatalogueList;
    }

    public static List<Product> getmStaticProductList() {
        return mStaticProductList;
    }

    public static void setmStaticProductList(List<Product> mStaticProductList) {
        Config.mStaticProductList = mStaticProductList;
    }


}
