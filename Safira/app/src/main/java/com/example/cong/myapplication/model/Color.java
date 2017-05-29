package com.example.cong.myapplication.model;

/**
 * Created by Cong on 27/05/2017.
 */

public class Color {
    private String name;
    private String url;

    public Color(){
    }
    public Color(String name, String url) {
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
