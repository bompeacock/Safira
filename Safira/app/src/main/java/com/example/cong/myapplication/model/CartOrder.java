package com.example.cong.myapplication.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Cong on 02/09/2017.
 */

public class CartOrder implements Serializable{
    private List<Product> orderDetails;
    private OrderAddress orderAddress;
    private String totalPrice;
    private int type;
    private String userId;
    private String dateOrder;

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Product> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<Product> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public OrderAddress getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(OrderAddress orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getTotalPrice() {
        return caculateTotalPrice();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private String caculateTotalPrice() {
        int total = 0;
        if(orderDetails.size()>0){
            for(Product p: orderDetails){
                total += p.getPrice()*p.getQuantity();
            }
            return "$" + total;
        }
        return "$" + total;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

}
