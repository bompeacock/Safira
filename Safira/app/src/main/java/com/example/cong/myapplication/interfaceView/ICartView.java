package com.example.cong.myapplication.interfaceView;

import com.example.cong.myapplication.model.Product;

import java.util.List;

/**
 * Created by CongNV4 on 8/30/2017.
 */

public interface ICartView {
    void loadViewCart(List<Product> cart,List<String> list);
    void loadFailView();

    void removeItemCart(int position);

    void reloadView(int quantity, int position);

}
