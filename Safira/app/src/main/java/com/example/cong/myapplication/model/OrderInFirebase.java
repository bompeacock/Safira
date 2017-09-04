package com.example.cong.myapplication.model;

/**
 * Created by Cong on 04/09/2017.
 */

public class OrderInFirebase {

    private String products;
    private String Address;
    private String orderDate;

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
