package com.example.cong.myapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by CongNV4 on 6/21/2017.
 */

public  class ResultsCollection {
    @SerializedName("type")
    private int type;


    public int getType() {
        return type;
    }
}
class TypeBanner extends ResultsCollection{
    @SerializedName("data")
    private String a;

}
class TypeCarousel extends  ResultsCollection{
    @SerializedName("data")
    private int a;

}
class TypeMixProduct extends ResultsCollection{
    @SerializedName("data")
    private double a;
}
