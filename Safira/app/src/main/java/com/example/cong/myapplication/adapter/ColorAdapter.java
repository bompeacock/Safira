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
 * Created by Cong on 27/05/2017.
 */

public class ColorAdapter extends RecyclerView.Adapter {

    private Context context;

    private List<Color> colors;

    private IImageProduct IimageProduct;
    public ColorAdapter(Context context, List<Color> colors) {
        this.context = context;
        this.colors = colors;
        this.IimageProduct = (IImageProduct) context;
    }

    public interface IImageProduct{
        public void setImageProduct(int productId);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_color,parent,false);
        return new ColorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ColorViewHolder colorViewHolder = (ColorViewHolder) holder;

        final Color color = colors.get(position);

        String url = Constant.IMAGE_URL_COLOR + color.getPath();

        Picasso.with(context).load(url)
                .placeholder(R.drawable.progress)
        .into(colorViewHolder.imgColor);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IimageProduct.setImageProduct(color.getId());
            }
        });


    }

    @Override
    public int getItemCount() {
        return colors.size();
    }
    public class ColorViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgColor)
        ImageView imgColor;
        public ColorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
