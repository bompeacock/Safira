package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cong.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cong on 27/05/2017.
 */

public class PickDetailsImageProductAdapter extends RecyclerView.Adapter{

    Context context;

    List<String> imageURIs;

    IClicklistener iClicklistener;
    public PickDetailsImageProductAdapter(Context context, List<String> imageURIs) {
        this.context = context;
        this.imageURIs = imageURIs;
        this.iClicklistener = (IClicklistener) context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.item_product_details,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final MyViewHolder myViewHolder = (MyViewHolder) holder;
        final String url = imageURIs.get(position);

        Picasso.with(context).load(url)
                .placeholder(R.drawable.ic_favorite)
                .into(myViewHolder.img_product_item, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                        myViewHolder.img_product_item.setBackgroundResource(R.drawable.a);
                    }
                });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClicklistener.updateImage(url);
            }
        });

    }
    public  interface IClicklistener{
        void updateImage(String url);
    }

    @Override
    public int getItemCount() {
        return imageURIs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_product_item)
        ImageView img_product_item;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
