package com.example.cong.myapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by CongNV4 on 6/23/2017.
 */

public class TypeBanner extends ResultsCollection{
    @SerializedName("data")
    private Banner banner;

    public Banner getBanner() {
        return banner;
    }
}