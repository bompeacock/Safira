package com.example.cong.myapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cong on 27/08/2017.
 */

public class ResultDetails {

    @SerializedName("code")
    private String code;

    @SerializedName("path")
    private String path;

    public String getPath() {
        return path;
    }

    public String getCode() {
        return code;
    }
}
