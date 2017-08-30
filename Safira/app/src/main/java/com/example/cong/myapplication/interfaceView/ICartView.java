package com.example.cong.myapplication.interfaceView;

import com.example.cong.myapplication.model.ProductInCart;

import java.util.List;

/**
 * Created by CongNV4 on 8/30/2017.
 */

public interface ICartView {
    public void loadViewCart(List<ProductInCart> cart);
    public void loadFailView();
}
