package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.activity.DetailsProduct;
import com.example.cong.myapplication.model.Color;
import com.example.cong.myapplication.model.Product;
import com.example.cong.myapplication.model.ResultProducByGroupAndType;
import com.example.cong.myapplication.utils.Constant;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cong on 30/05/2017.
 */

public class InsideSafiraAdapter extends RecyclerView.Adapter{
    Context context;
    List<ResultProducByGroupAndType> resultProducByGroupAndTypes;


    public InsideSafiraAdapter(Context context, List<ResultProducByGroupAndType> resultProducByGroupAndTypes) {
        this.context = context;
        this.resultProducByGroupAndTypes = resultProducByGroupAndTypes;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_color_product,parent,false);
        return new InsideSafiraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        InsideSafiraViewHolder viewHolder = (InsideSafiraViewHolder) holder;

        final Product product = resultProducByGroupAndTypes.get(position).getProduct();

        Picasso.with(context)
                .load(Constant.IMAGE_URL_GROUP_TYPE + product.getUrlImage())
                .placeholder(R.drawable.progress)
                .into(viewHolder.imgProduct);

        List<Color> listColor = resultProducByGroupAndTypes.get(position).getColors();

        ColorMiniAdapter colorAdapter = new ColorMiniAdapter(listColor,context,position);
        viewHolder.rvColor.setAdapter(colorAdapter);

        viewHolder.txtProductName.setText(product.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itent = new Intent(context, DetailsProduct.class);
                itent.putExtra("code", product.getCode());
                context.startActivity(itent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return resultProducByGroupAndTypes.size();
    }

    public void changeInfoItem(Product product, int position) {
        resultProducByGroupAndTypes.get(position).getProduct().setCode(product.getCode());
        resultProducByGroupAndTypes.get(position).getProduct().setUrlImage(product.getUrlImage());
        notifyItemChanged(position);
    }


    public class InsideSafiraViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rvColor)
        RecyclerView rvColor;

        @BindView(R.id.imgProduct)
        ImageView imgProduct;

        @BindView(R.id.txtProductName)
        TextView txtProductName;

        public InsideSafiraViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
