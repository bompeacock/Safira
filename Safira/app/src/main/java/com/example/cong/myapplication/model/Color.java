package com.example.cong.myapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cong on 27/05/2017.
 */

public class Color {
    @SerializedName("id")
    private int id;
    @SerializedName("path")
    private String path;

    public Color(int id, String path) {
        this.id = id;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
