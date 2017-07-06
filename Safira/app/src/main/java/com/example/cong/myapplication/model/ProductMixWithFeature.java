package com.example.cong.myapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cong on 01/07/2017.
 */
public class ProductMixWithFeature {
    @SerializedName("idInforProduct")
    private int id;
    @SerializedName("nameProduct")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("imageMix")
    private String imageFix;
    @SerializedName("imageFeature1")
    private String imageFeature1;
    @SerializedName("imageFeature2")
    private String imageFeature2;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageFix() {
        return imageFix;
    }

    public String getImageFeature1() {
        return imageFeature1;
    }

    public String getImageFeature2() {
        return imageFeature2;
    }
}
