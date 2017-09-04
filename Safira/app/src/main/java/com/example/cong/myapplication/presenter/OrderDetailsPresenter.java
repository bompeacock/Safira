package com.example.cong.myapplication.presenter;

import com.example.cong.myapplication.interfaceView.IOrderDetailsView;
import com.example.cong.myapplication.model.CartOrder;
import com.example.cong.myapplication.utils.OrderConstants;
import com.example.cong.myapplication.utils.StructureFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Cong on 03/09/2017.
 */

public class OrderDetailsPresenter {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date currentTime = Calendar.getInstance().getTime();

    IOrderDetailsView orderDetailsView;

    FirebaseUser user;
    DatabaseReference database;
    public OrderDetailsPresenter(IOrderDetailsView orderDetailsView) {
        this.orderDetailsView = orderDetailsView;
        user = FirebaseAuth.getInstance().getCurrentUser();
        database = FirebaseDatabase.getInstance().getReference();
    }

    public void submitOrderToBackEndAndFireBase(CartOrder cartOrder) {
        //TODO : submit to backend and firebase;
//        OrderInFirebase orderInFirebase = new OrderInFirebase();
        cartOrder.setUserId(user.getUid());
        cartOrder.setDateOrder(dateFormat.format(currentTime));
        if(cartOrder.getType()== OrderConstants.ORDER_FROM_CART){
            database.child(user.getUid()).child(StructureFirebase.CART).removeValue();
        }
        database.child(StructureFirebase.ORDER).push().setValue(cartOrder);

        orderDetailsView.endPurchasing();
    }
}
