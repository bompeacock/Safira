package com.example.cong.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.ReviewAdapter;
import com.example.cong.myapplication.interfaceView.IReviewVIew;
import com.example.cong.myapplication.presenter.ReviewPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Review extends AppCompatActivity implements IReviewVIew {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rvReview)
    RecyclerView rvReview;

    @BindView(R.id.edtReview)
    EditText edtReview;

    @BindView(R.id.btnComment)
    ImageView btnComment;


    ReviewPresenter reviewPresenter;

    String imageCode;


    ReviewAdapter reviewAdapter;

    List<com.example.cong.myapplication.model.Review> listReviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        ButterKnife.bind(this);

        reviewPresenter = new ReviewPresenter(this);
        imageCode = getIntent().getStringExtra("imageCode");
        setUpViews();

        setEvents();
    }

    private void setEvents() {
        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable editable = edtReview.getText();
                String commentation = editable.toString();
                reviewPresenter.addNewReview(imageCode,commentation);
                edtReview.setText("");
            }
        });
    }

    private void setUpViews() {
        toolbar.setTitle("Review");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listReviews = new ArrayList<>();
        reviewAdapter = new ReviewAdapter(this,listReviews);
        rvReview.setAdapter(reviewAdapter);
        rvReview.setLayoutManager(new LinearLayoutManager(this));
        reviewPresenter.loadDataReview(imageCode);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case android.R.id.home:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void loadViewReview(List<com.example.cong.myapplication.model.Review> reviews) {
        reviewAdapter.addNewData(reviews);
    }
}
