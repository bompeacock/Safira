package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.model.Color;
import com.example.cong.myapplication.utils.Constant;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cong on 11/07/2017.
 */

public class ColorMiniAdapter extends RecyclerView.Adapter {

    private List<Color> colors;

    private Context context;

    private int positionProduct;

    IMiniColor iMiniColor;
    public ColorMiniAdapter(List<Color> colors, Context context, final int positionProduct) {
        this.colors = colors;
        this.context = context;
        this.positionProduct = positionProduct;

        this.iMiniColor = (IMiniColor) context;
    }
    public interface IMiniColor{
        void updateImageProduct(int id, int position);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_color_mini,parent,false);

        return new ColorMiniViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ColorMiniViewHolder colorMiniViewHolder = (ColorMiniViewHolder) holder;

        final Color color = colors.get(position);

        Picasso.with(context).load(Constant.IMAGE_URL_COLOR+colors.get(position).getPath())
                .into(colorMiniViewHolder.imgColorMini);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iMiniColor.updateImageProduct(color.getId(),positionProduct);
            }
        });
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
