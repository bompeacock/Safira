package com.example.cong.myapplication.utils;

import com.example.cong.myapplication.model.Review;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cong on 03/09/2017.
 */

public class ReviewUtils {
    public static List<Review> getAllReviews(DataSnapshot dataSnapshot){
        List<Review> list  = new ArrayList<>();
        for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
            Review post = postSnapshot.getValue(Review.class);
            list.add(post);
        }
        return list;
    }
 }
