package com.example.cong.myapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cong on 05/05/2017.
 */

public class Product {
    @SerializedName("id")
    private int idSingleImg;
    @SerializedName("productName")
    private String name;
    @SerializedName("path")
    private String urlImage;
    @SerializedName("code")
    private String code;
    @SerializedName("productId")
    private String productId;
    @SerializedName("dolar")
    private int price;


    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public int getIdSingleImg() {
        return idSingleImg;
    }

    public String getName() {
        return name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getCode() {
        return code;
    }

    public String getProductId() {
        return productId;
    }

    public int getPrice() {
        return price;
    }
}
