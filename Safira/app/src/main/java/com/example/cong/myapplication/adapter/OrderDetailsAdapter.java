package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class OrderDetailsAdapter extends RecyclerView.Adapter {
    Context context;

    List<Product> productInCarts;

    public OrderDetailsAdapter(List<Product> productInCarts, Context context) {
        this.productInCarts = productInCarts;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_order_details,parent,false);
        return new OrderDetailsAdapter.CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Product product = productInCarts.get(position);
        OrderDetailsAdapter.CartViewHolder cartViewHolder = (CartViewHolder) holder;
        cartViewHolder.txtProductName.setText(product.getName());
        cartViewHolder.txtStyle.setText(product.getCode());
        cartViewHolder.txtSize.setText(product.getSize());
        cartViewHolder.txtPrice.setText("$"+product.getPrice());
        cartViewHolder.txtQuantity.setText(product.getQuantity()+"");
        PicassoUtils.loadImageAndResizeForCart(context
                , Constant.IMAGE_URL_SINGLE_IMAGE + product.getUrlImage()
                ,cartViewHolder.imgProduct);
    }

    @Override
    public int getItemCount() {
        return productInCarts.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgProduct)
        ImageView imgProduct;

        @BindView(R.id.txtProductName)
        TextView txtProductName;

        @BindView(R.id.txtStyle)
        TextView  txtStyle;

        @BindView(R.id.txtSize)
        TextView txtSize;

        @BindView(R.id.txtQuantity)
        TextView txtQuantity;

        @BindView(R.id.txtPrice)
        TextView txtPrice;



        public CartViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
