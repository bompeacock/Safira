package com.example.cong.myapplication.presenter;

import com.example.cong.myapplication.interfaceView.ICartView;
import com.example.cong.myapplication.model.ProductInCart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CongNV4 on 8/30/2017.
 */

public class CartPresenter {
    ICartView carView;

    public CartPresenter(ICartView carView) {
        this.carView = carView;
    }

    public void loadDataCart(){

        List<ProductInCart> cart = new ArrayList<>();
        ProductInCart productInCart = new ProductInCart();
        productInCart.setPath("https://www.vividlinen.com/images/product_photo/t3548_20170809084745_13815.jpg");
        cart.add(productInCart);
        ProductInCart productInCart1 = new ProductInCart();
        productInCart.setPath("https://www.vividlinen.com/images/product_photo/t3548_20170809084745_13815.jpg");
        cart.add(productInCart1);
        ProductInCart productInCart2 = new ProductInCart();
        productInCart.setPath("https://www.vividlinen.com/images/product_photo/t3548_20170809084745_13815.jpg");
        cart.add(productInCart2);
        ProductInCart productInCart3 = new ProductInCart();
        productInCart.setPath("https://www.vividlinen.com/images/product_photo/t3548_20170809084745_13815.jpg");
        cart.add(productInCart3);


        carView.loadViewCart(cart);
    }
}
