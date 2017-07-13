package com.example.cong.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Cong on 12/07/2017.
 */

public class ResultProductsType {
    @SerializedName("banner")
    Banner banner;
    @SerializedName("products")
    List<Product> products;

    public Banner getBanner() {
        return banner;
    }

    public List<Product> getProducts() {
        return products;
    }
}
