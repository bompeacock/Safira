package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.model.Product;
import com.example.cong.myapplication.utils.Constant;
import com.example.cong.myapplication.utils.PicassoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cong on 03/09/2017.
 */

public class FavoriteAdapter extends RecyclerView.Adapter {

    Context context;

    List<Product> productList;

    List<String> listKeys;

    IActionFavorite actionFavorite;

    public void removeItem(int position) {
        productList.remove(position);
        notifyItemRemoved(position);
    }


    public interface IActionFavorite{
        void removeItemFavorite(String key, int position);

        void addToCart(Product product);

    }

    public FavoriteAdapter(Context context, List<Product> productList, List<String> listKeys) {
        this.context = context;
        this.productList = productList;
        this.listKeys = listKeys;
        actionFavorite = (IActionFavorite) context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_favorite,parent,false);

        return new FavoriteHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final Product product = productList.get(position);
        FavoriteHolder favoriteHolder = (FavoriteHolder) holder;
        favoriteHolder.txtProductName.setText(product.getName());
        favoriteHolder.txtStyle.setText(product.getCode());
        favoriteHolder.txtPrice.setText("$"+product.getPrice());
        PicassoUtils.loadImageAndResizeForCart(context,
                Constant.IMAGE_URL_SINGLE_IMAGE + product.getUrlImage(),
                favoriteHolder.imgProduct);
        favoriteHolder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionFavorite.removeItemFavorite(listKeys.get(position),position);
            }
        });
        favoriteHolder.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionFavorite.addToCart(product);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class  FavoriteHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgProduct)
        ImageView imgProduct;

        @BindView(R.id.txtProductName)
        TextView txtProductName;

        @BindView(R.id.txtStyle)
        TextView  txtStyle;

        @BindView(R.id.txtPrice)
        TextView txtPrice;

        @BindView(R.id.btnRemove)
        ImageView btnRemove;

        @BindView(R.id.btnAddToCart)
        Button btnAddToCart;

        public FavoriteHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);

        }
    }
}
