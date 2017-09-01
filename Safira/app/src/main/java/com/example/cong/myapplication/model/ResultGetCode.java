package com.example.cong.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class ResultGetCode{
    @SerializedName("imageTarget")
    private ImageTarget imageTarget;

    public ImageTarget getImageTarget() {
        return imageTarget;
    }
}
