package com.example.cong.myapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cong on 27/05/2017.
 */

public class Color {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("urlImageColor")
    private String url;

    public Color(){
    }
    public Color(int id,String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
