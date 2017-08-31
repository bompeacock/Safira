package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.model.ProductInCart;

import java.util.List;

/**
 * Created by CongNV4 on 8/30/2017.
 */

public class CartAdapter extends RecyclerView.Adapter {

    Context context;

    List<ProductInCart> productInCarts;



    public CartAdapter(Context context, List<ProductInCart> cart) {
        this.context = context;
        this.productInCarts = cart;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cart,parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return productInCarts.size();
    }
    public class CartViewHolder extends RecyclerView.ViewHolder {

        public CartViewHolder(View itemView) {
            super(itemView);
        }
    }
}
