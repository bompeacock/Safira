package com.example.cong.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Cong on 01/07/2017.
 */

public class TypeMixProduct extends ResultsCollection {
    @SerializedName("data")
    @Expose
    private ProductMixWithFeature productMix;

    public ProductMixWithFeature getProductMix() {
        return productMix;
    }
}
