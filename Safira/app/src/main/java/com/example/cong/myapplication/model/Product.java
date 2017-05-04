package com.example.cong.myapplication.model;

/**
 * Created by Cong on 05/05/2017.
 */

public class Product {
    private String id;
    private String name;

    public Product(String name) {
        this.name = name;
    }


    public String  getProductName() {
        return this.name;
    }
}
