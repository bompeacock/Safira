package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cong on 30/05/2017.
 */

public class InsideSafiraAdapter extends RecyclerView.Adapter {
    Context context;
    List<Product> listProduct;

    public InsideSafiraAdapter(Context context) {
        this.context = context;
        listProduct = new ArrayList<>();
        listProduct.add(new Product("product 1"));
        listProduct.add(new Product("product 2"));
        listProduct.add(new Product("product 3"));
        listProduct.add(new Product("product 4"));
        listProduct.add(new Product("product 5"));
        listProduct.add(new Product("product 6"));
        listProduct.add(new Product("product 7"));
        listProduct.add(new Product("product 8"));
        listProduct.add(new Product("product 8"));
        listProduct.add(new Product("product 8"));
        listProduct.add(new Product("product 8"));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_color_product,parent,false);
        return new InsideSafiraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }
    public class InsideSafiraViewHolder extends RecyclerView.ViewHolder {

        public InsideSafiraViewHolder(View itemView) {
            super(itemView);
        }
    }
}
