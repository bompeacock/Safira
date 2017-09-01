package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.activity.DetailsProduct;
import com.example.cong.myapplication.model.Color;
import com.example.cong.myapplication.model.Product;
import com.example.cong.myapplication.model.ResultProducByGroupAndType;
import com.example.cong.myapplication.utils.Constant;
import com.example.cong.myapplication.utils.PicassoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CongNV4 on 8/31/2017.
 */

public class SearchAdapter extends RecyclerView.Adapter {

    Context context;
    List<ResultProducByGroupAndType> resultProducByGroupAndTypes;

    public SearchAdapter(Context context, List<ResultProducByGroupAndType> resultProducByGroupAndTypes) {
        this.context = context;
        this.resultProducByGroupAndTypes = resultProducByGroupAndTypes;
    }

    public void addNewResult(List<ResultProducByGroupAndType> list){
        resultProducByGroupAndTypes.clear();
        resultProducByGroupAndTypes.addAll(list);


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_search,parent,false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final SearchViewHolder searchViewHolder = (SearchViewHolder) holder;
        final Product product = resultProducByGroupAndTypes.get(position).getProduct();

        PicassoUtils.loadImage(context, Constant.IMAGE_URL_GROUP_TYPE + product.getUrlImage(),searchViewHolder.imgProduct);
        searchViewHolder.txtProductName.setText(product.getName());
        searchViewHolder.txtStyle.setText(product.getCode());
        searchViewHolder.txtProductPrice.setText("$"+product.getPrice());

        List<Color> listColor = resultProducByGroupAndTypes.get(position).getColors();

        ColorMiniAdapter colorAdapter = new ColorMiniAdapter(listColor,context,position+1);
        searchViewHolder.rvColor.setAdapter(colorAdapter);
        searchViewHolder.btnAddToFavorite.setBackgroundResource(R.drawable.btndislike);

        searchViewHolder.btnAddToFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchViewHolder.btnAddToFavorite.setBackgroundResource(R.drawable.btnlike);
                Snackbar.make(holder.itemView,"Add favorite successfully",Snackbar.LENGTH_SHORT).show();
            }
        });

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
    public class SearchViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgProduct)
        ImageView imgProduct;

        @BindView(R.id.txtProductName)
        TextView txtProductName;

        @BindView(R.id.txtStyle)
        TextView txtStyle;

        @BindView(R.id.txtQuantity)
        TextView txtQuantity;

        @BindView(R.id.txtSizes)
        TextView txtSizes;

        @BindView(R.id.txtProductPrice)
        TextView txtProductPrice;

        @BindView(R.id.rvColor)
        RecyclerView rvColor;

        @BindView(R.id.btnAddToFavorite)
        Button btnAddToFavorite;
        public SearchViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
