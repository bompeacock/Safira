package com.example.cong.myapplication.presenter;

import com.example.cong.myapplication.interfaceView.IReviewVIew;
import com.example.cong.myapplication.model.Review;
import com.example.cong.myapplication.utils.ReviewUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

/**
 * Created by Cong on 03/09/2017.
 */

public class ReviewPresenter {
    IReviewVIew iReviewView;

    DatabaseReference database;

    FirebaseUser user;

    public ReviewPresenter(IReviewVIew iReviewView) {
        this.iReviewView = iReviewView;

        database = FirebaseDatabase.getInstance().getReference();
        user = FirebaseAuth.getInstance().getCurrentUser();
    }

    public void loadDataReview(String imageCode) {
        database.child(imageCode).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Review> reviews = ReviewUtils.getAllReviews(dataSnapshot);
                iReviewView.loadViewReview(reviews);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void addNewReview(String imageCode, String comment) {
        Review review = new Review();
        review.setAuthor(user.getDisplayName());
        review.setComment(comment);
        database.child(imageCode).push().setValue(review);
    }
}
