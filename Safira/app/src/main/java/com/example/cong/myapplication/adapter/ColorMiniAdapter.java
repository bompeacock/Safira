package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.utils.Constant;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cong on 11/07/2017.
 */

public class ColorMiniAdapter extends RecyclerView.Adapter {

    private List<String> colors;

    private Context context;

    public ColorMiniAdapter(List<String> colors, Context context) {
        this.colors = colors;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_color_mini,parent,false);

        return new ColorMiniViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ColorMiniViewHolder colorMiniViewHolder = (ColorMiniViewHolder) holder;

        Picasso.with(context).load(Constant.IMAGE_URL+colors.get(position))
                .into(colorMiniViewHolder.imgColorMini);
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

    public class ColorMiniViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageColorMini)
        ImageView imgColorMini;

        public ColorMiniViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
