package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.model.Product;

import java.util.List;

/**
 * Created by Cong on 30/05/2017.
 */

public class MenAdapter extends RecyclerView.Adapter{
    List<Product> products;
    Context context;

    public MenAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_color_product,parent,false);
        return new MenViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(context, DetailsProduct.class);
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
    public  class MenViewHolder extends RecyclerView.ViewHolder {

        public MenViewHolder(View itemView) {
            super(itemView);
        }
    }
}
