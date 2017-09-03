package com.example.cong.myapplication.presenter;

import com.example.cong.myapplication.interfaceView.IOrderDetailsView;
import com.example.cong.myapplication.model.CartOrder;

/**
 * Created by Cong on 03/09/2017.
 */

public class OrderDetailsPresenter {
    IOrderDetailsView orderDetailsView;
    public OrderDetailsPresenter(IOrderDetailsView orderDetailsView) {
        this.orderDetailsView = orderDetailsView;
    }

    public void submitOrderToBackEndAndFireBase(CartOrder cartOrder) {
        //TODO : submit to backend and firebase;

        orderDetailsView.endPurchasing();
    }
}
