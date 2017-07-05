package com.example.cong.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Cong on 01/07/2017.
 */
public class ModelProductWithCategory {
    @SerializedName("category")
    private String category;
    @SerializedName("products")
    private List<Product> listproduct;

    public String getCategory() {
        return category;
    }

    public List<Product> getListproduct() {
        return listproduct;
    }
}
