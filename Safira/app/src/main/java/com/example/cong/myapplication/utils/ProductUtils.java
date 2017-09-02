package com.example.cong.myapplication.utils;

import com.example.cong.myapplication.model.Product;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cong on 02/09/2017.
 */

public class ProductUtils {
    public static List<Product> getAllProductCartOnFireBase(DataSnapshot snapshot){
        List<Product> list  = new ArrayList<>();
        for (DataSnapshot postSnapshot: snapshot.getChildren()) {
            Product post = postSnapshot.getValue(Product.class);
            list.add(post);
        }
        return list;
    }
    public static List<String> getAllKeyCartOnFireBase(DataSnapshot snapshot){
        List<String> list  = new ArrayList<>();
        for (DataSnapshot postSnapshot: snapshot.getChildren()) {
            String post = postSnapshot.getKey();
            list.add(post);
        }
        return list;
    }
}
