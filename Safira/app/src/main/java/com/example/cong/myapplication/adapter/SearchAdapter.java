package com.example.cong.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cong.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CongNV4 on 8/31/2017.
 */

public class SearchAdapter extends RecyclerView.Adapter {



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class SearchViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageProduct)
        ImageView imageProduct;

        @BindView(R.id.txtProductName)
        TextView txtProductName;

        @BindView(R.id.txtStyle)
        TextView txtStyle;

        @BindView(R.id.txtQuantity)
        TextView txtQuantity;

        @BindView(R.id.txtSizes)
        TextView txtSizes;

        @BindView(R.id.rvColor)
        RecyclerView rvColor;

        public SearchViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
