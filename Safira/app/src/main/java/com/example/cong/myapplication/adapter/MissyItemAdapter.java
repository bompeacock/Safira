package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.activity.Pick_product;
import com.example.cong.myapplication.model.Product;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cong on 05/05/2017.
 */

public class MissyItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<Product> listProduct;
    Context context;
    public MissyItemAdapter(Context context) {
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
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mix,parent,false);
            return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyViewHolder){
            final Product product = listProduct.get(position);
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.txtProductName.setText(product.getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Pick_product.class);
                    context.startActivity(intent);
                }
            });
        }
    }





    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtProductName)
        TextView txtProductName;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


}
