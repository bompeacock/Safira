package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.model.ModelProductWithCategory;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cong on 03/09/2017.
 */

public class CarouselAdapter extends RecyclerView.Adapter {

    Context context;

    List<ModelProductWithCategory> modelProductWithCategories;


    public CarouselAdapter(Context context, List<ModelProductWithCategory> modelProductWithCategories) {
        this.context = context;
        this.modelProductWithCategories = modelProductWithCategories;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewCarousel = LayoutInflater.from(context).inflate(R.layout.item_safira,parent,false);
        return new CarouselAdapter.CarouselViewHolder(viewCarousel);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ModelProductWithCategory productWithCategory = modelProductWithCategories.get(position);
        CarouselAdapter.CarouselViewHolder carouselViewHolder = (CarouselViewHolder) holder;
        carouselViewHolder.txtCategory.setText(productWithCategory.getCategory());
        
    }

    @Override
    public int getItemCount() {
        return modelProductWithCategories.size();
    }

    public  class CarouselViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtCategory)
        TextView txtCategory;

        @BindView(R.id.rvSafiraItem)
        RecyclerView rvSafiraItem;


        public CarouselViewHolder(View viewCarousel) {
            super(viewCarousel);
            ButterKnife.bind(this, viewCarousel);
        }
    }
}
