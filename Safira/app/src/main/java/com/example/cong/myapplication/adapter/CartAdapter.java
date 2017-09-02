package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.model.Product;
import com.example.cong.myapplication.utils.Constant;
import com.example.cong.myapplication.utils.PicassoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CongNV4 on 8/30/2017.
 */

public class CartAdapter extends RecyclerView.Adapter {

    Context context;

    List<Product> productInCarts;

    List<String> listKey;

    ICartEvents iCartEvents;

    public CartAdapter(Context context, List<Product> cart, List<String> listKey) {
        this.context = context;
        this.productInCarts = cart;
        this.listKey = listKey;
        iCartEvents = (ICartEvents) context;
    }

    public void removeItem(int position) {
        productInCarts.remove(position);
        notifyItemRemoved(position);
    }

    public interface ICartEvents{
        void removeItemCart(String key, int position);
        void updateQuantity(String key, int quantity);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cart,parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Product product = productInCarts.get(position);
        CartViewHolder cartViewHolder = (CartViewHolder) holder;
        cartViewHolder.txtProductName.setText(product.getName());
        cartViewHolder.txtStyle.setText(product.getCode());
        cartViewHolder.txtSize.setText(product.getSize());
        cartViewHolder.txtPrice.setText("$"+product.getPrice());
        PicassoUtils.loadImage(context, Constant.IMAGE_URL_SINGLE_IMAGE + product.getUrlImage(),cartViewHolder.imgProduct);

        cartViewHolder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iCartEvents.removeItemCart(listKey.get(position),position);
            }
        });


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

        @BindView(R.id.spnQuantity)
        Spinner spnQuantity;

        @BindView(R.id.txtPrice)
        TextView txtPrice;

        @BindView(R.id.btnRemove)
        Button btnRemove;

        public CartViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
