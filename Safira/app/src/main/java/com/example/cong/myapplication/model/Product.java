package com.example.cong.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Cong on 05/05/2017.
 */

public class Product {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("image")
    private String urlImage;
    @SerializedName("imageColor")
    private List<String> urlFeature;

    public Product(int id, String name, String urlImage, List<String> urlFeature) {
        this.id = id;
        this.name = name;
        this.urlImage = urlImage;
        this.urlFeature = urlFeature;
    }

    public Product(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public List<String> getUrlFeature() {
        return urlFeature;
    }
}
