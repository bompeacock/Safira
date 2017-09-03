package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.model.Review;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cong on 03/09/2017.
 */

public class ReviewAdapter extends RecyclerView.Adapter {

    Context context;

    List<Review> reviewList;

    public ReviewAdapter(Context context, List<Review> reviews) {
        this.context = context;
        this.reviewList = reviews;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_review,parent,false);

        return new ReviewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Review review = reviewList.get(position);
        ReviewHolder reviewHolder = (ReviewHolder) holder;
        reviewHolder.txtReview.setText(review.getComment());
        reviewHolder.txtAuthorReview.setText(review.getAuthor());

    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    public void addNewData(List<Review> reviews) {
        reviewList.clear();
        reviewList.addAll(reviews);
        notifyDataSetChanged();
    }

    public class ReviewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtReview)
        TextView txtReview;

        @BindView(R.id.txtAuthorReview)
        TextView txtAuthorReview;



        public ReviewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
