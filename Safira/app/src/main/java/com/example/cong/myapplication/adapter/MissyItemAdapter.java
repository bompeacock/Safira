package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.activity.Pick_product;
import com.example.cong.myapplication.model.MixProduct;
import com.example.cong.myapplication.utils.Constant;
import com.example.cong.myapplication.utils.PicassoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cong on 05/05/2017.
 */

public class MissyItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<MixProduct> listProduct;
    Context context;
    private int groupId;

    public MissyItemAdapter(Context context, List<MixProduct> listProduct, int groupId) {
        this.context = context;
        this.listProduct = listProduct;
        this.groupId = groupId;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mix,parent,false);

            return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyViewHolder){
            final MixProduct product = listProduct.get(position);
            MyViewHolder myViewHolder = (MyViewHolder) holder;



            PicassoUtils.loadImage(context,Constant.IMAGE_URL_MIX + product.getPath(),myViewHolder.imgProduct);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Pick_product.class);
                    intent.putExtra("mixImageId", product.getId());
                    intent.putExtra("groupId", groupId);
                    context.startActivity(intent);
                }
            });


        }
    }





    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.imgProduct)
        ImageView imgProduct;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


}
