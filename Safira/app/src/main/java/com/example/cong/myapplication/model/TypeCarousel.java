package com.example.cong.myapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cong on 01/07/2017.
 */

public class TypeCarousel extends ResultsCollection{
    @SerializedName("data")
    private ModelProductWithCategory modelProductWithCategory;

    public ModelProductWithCategory getModelProductWithCategory() {
        return modelProductWithCategory;
    }
}
