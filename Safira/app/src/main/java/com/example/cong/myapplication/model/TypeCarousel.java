package com.example.cong.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Cong on 01/07/2017.
 */

public class TypeCarousel extends ResultsCollection{
    @SerializedName("data")
    @Expose
    private ModelProductWithCategory modelProductWithCategory;

    public ModelProductWithCategory getModelProductWithCategory() {
        return modelProductWithCategory;
    }
}
