package com.example.cong.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Cong on 05/05/2017.
 */

public class Product implements Serializable{
    @SerializedName("id")
    private int idSingleImg;
    @SerializedName("productName")
    private String name;
    @SerializedName("path")
    private String urlImage;
    @SerializedName("code")
    private String code;
    @SerializedName("productId")
    private String productId;
    @SerializedName("dolar")
    private int price;

    private String size;
    private int quantity = 1;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public int getIdSingleImg() {
        return idSingleImg;
    }

    public String getName() {
        return name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getCode() {
        return code;
    }

    public String getProductId() {
        return productId;
    }

    public int getPrice() {
        return price;
    }

    public void setIdSingleImg(int idSingleImg) {
        this.idSingleImg = idSingleImg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return code.equals(product.code);

    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
