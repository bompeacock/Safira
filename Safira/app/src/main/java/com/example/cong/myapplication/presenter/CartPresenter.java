package com.example.cong.myapplication.presenter;

import com.example.cong.myapplication.interfaceView.ICartView;
import com.example.cong.myapplication.model.Product;
import com.example.cong.myapplication.utils.ProductUtils;
import com.example.cong.myapplication.utils.StructureFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

/**
 * Created by CongNV4 on 8/30/2017.
 */

public class CartPresenter {
    ICartView carView;

    DatabaseReference databaseReference;
    FirebaseUser user;
    public CartPresenter(ICartView carView) {
        this.carView = carView;
        databaseReference = FirebaseDatabase.getInstance().getReference();
        user = FirebaseAuth.getInstance().getCurrentUser();
    }

    public void loadDataCart(){
        databaseReference.child(user.getUid()).child(StructureFirebase.CART)
                .getRef().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Product> productList = ProductUtils.getAllProductCartOnFireBase(dataSnapshot);
                List<String> listKey =  ProductUtils.getAllKeyCartOnFireBase(dataSnapshot);
                carView.loadViewCart(productList,listKey);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void deleteItemCart(String key, int position) {
        databaseReference.child(user.getUid()).child(StructureFirebase.CART)
                .child(key).removeValue();
        carView.removeItemCart(position);
    }
}
