package com.example.cong.myapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cong on 01/07/2017.
 */

public class Banner {
    @SerializedName("id")
    private int id;
    @SerializedName("urlBanner")
    private String urlBanner;

    public Banner(int id, String urlBanner) {
        this.id = id;
        this.urlBanner = urlBanner;
    }
}
