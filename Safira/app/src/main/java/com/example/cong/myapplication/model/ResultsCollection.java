package com.example.cong.myapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by CongNV4 on 6/21/2017.
 */

public  class ResultsCollection {
    @SerializedName("type")
    private int type;

    @SerializedName("banner")
    private Banner banner;

    @SerializedName("carousel")
    private ModelProductWithCategory modelProductWithCategory;

    @SerializedName("mixProduct")
    private ProductMixWithFeature productMixWithFeature;

    public Banner getBanner() {
        return banner;
    }

    public ModelProductWithCategory getModelProductWithCategory() {
        return modelProductWithCategory;
    }

    public ProductMixWithFeature getProductMixWithFeature() {
        return productMixWithFeature;
    }

    public int getType() {
        return type;
    }
}

