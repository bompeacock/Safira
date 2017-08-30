package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.model.Product;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cong on 30/08/2017.
 */

public class CartAdapter extends RecyclerView.Adapter{

    Context context;

    List<Product> cart;

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

    public class CartViewHolder  extends RecyclerView.ViewHolder {
        @BindView(R.id.imgProduct)
        ImageView imgProduct;

        @BindView(R.id.txtProductName)
        TextView txtProductName;

        @BindView(R.id.txtStyle)
        TextView txtStyle;

        @BindView(R.id.btnLIke)
        Button btnLike;

        @BindView(R.id.btnAddToCart)
        Button btnAddToCart;
        public CartViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
