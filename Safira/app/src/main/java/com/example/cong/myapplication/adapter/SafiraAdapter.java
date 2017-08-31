package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.model.ProductMixWithFeature;
import com.example.cong.myapplication.model.ResultsCollection;
import com.example.cong.myapplication.utils.Constant;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cong on 30/05/2017.
 */

public class SafiraAdapter extends RecyclerView.Adapter {
    Context context;
    List<ResultsCollection> list;

    public SafiraAdapter(List<ResultsCollection> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(context);

        switch (viewType){
            case Constant.TypeCollection.TYPE_BANNER:
                View viewBanner = inflater.inflate(R.layout.item_banner,parent,false);
                viewHolder = new BannerViewHolder(viewBanner);
                break;
            case Constant.TypeCollection.TYPE_CAROUSEL:
                View viewCarousel = inflater.inflate(R.layout.item_safira,parent,false);
                viewHolder = new CarouselViewHolder(viewCarousel);
                break;
            case Constant.TypeCollection.TYPE_MIX_PRODUCT:
                View viewMix = inflater.inflate(R.layout.item_mix_product_collection,parent,false);
                viewHolder = new MixViewHolder(viewMix);
                break;

        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case Constant.TypeCollection.TYPE_BANNER:
                BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
                configBannerViewHolder(bannerViewHolder, position);
                break;
            case Constant.TypeCollection.TYPE_CAROUSEL:
                CarouselViewHolder carouselViewHolder = (CarouselViewHolder) holder;
                configCarouselViewHolder(carouselViewHolder,position);
                break;
            case Constant.TypeCollection.TYPE_MIX_PRODUCT:
                MixViewHolder mixViewHolder = (MixViewHolder) holder;
                configMixViewHolder(mixViewHolder,position);
        }

    }

    private void configMixViewHolder(MixViewHolder mixViewHolder, int position) {
        ResultsCollection typeMixProduct = list.get(position);
        ProductMixWithFeature productMixWithFeature = typeMixProduct.getProductMixWithFeature();

        Picasso.with(context).load(Constant.IMAGE_URL+productMixWithFeature.getImageFix())
                .placeholder(R.drawable.progress)
                .into(mixViewHolder.getImgProductMix());

        Picasso.with(context).load(Constant.IMAGE_URL+productMixWithFeature.getImageFeature1())
                .placeholder(R.drawable.progress)
                .into(mixViewHolder.getImgFeature1());

        Picasso.with(context).load(Constant.IMAGE_URL+productMixWithFeature.getImageFeature2())
                .placeholder(R.drawable.progress)
                .into(mixViewHolder.getImgFeature2());

        mixViewHolder.getTxtDesciption().setText(productMixWithFeature.getName() + "\n" + productMixWithFeature.getDescription());

    }

    private void configCarouselViewHolder(CarouselViewHolder carouselViewHolder, int position) {
        ResultsCollection typeCarousel =  list.get(position);
//        ModelProductWithCategory modelProductWithCategory = typeCarousel.getModelProductWithCategory();
//        List<Product> productList =  modelProductWithCategory.getListproduct();
//
//        carouselViewHolder.getTxtCategory().setText(modelProductWithCategory.getCategory());
//
//        InsideSafiraAdapter adapter = new InsideSafiraAdapter(context,productList);
//        carouselViewHolder.getRvSafiraItem().setAdapter(adapter);

    }

    private void configBannerViewHolder(BannerViewHolder bannerViewHolder, int position) {
        ResultsCollection typeBanner = list.get(position);

        Picasso.with(context).load(Constant.IMAGE_URL+typeBanner.getBanner().getPath())
                .placeholder(R.drawable.progress)
                .into(bannerViewHolder.getImgBanner());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    public class CarouselViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtCategory)
        TextView txtCategory;

        @BindView(R.id.rvSafiraItem)
        RecyclerView rvSafiraItem;

        public CarouselViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }

        public TextView getTxtCategory() {
            return txtCategory;
        }

        public RecyclerView getRvSafiraItem() {
            return rvSafiraItem;
        }
    }
    public class BannerViewHolder extends  RecyclerView.ViewHolder{

        @BindView(R.id.imgBanner)
        ImageView imgBanner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }

        public ImageView getImgBanner() {
            return imgBanner;
        }
    }

    public class MixViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imageProductMix)
        ImageView imgProductMix;

        @BindView(R.id.imgFeature1)
        ImageView imgFeature1;

        @BindView(R.id.imgFeature2)
        ImageView imgFeature2;

        @BindView(R.id.txtDesciption)
        TextView txtDesciption;

        public MixViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public ImageView getImgProductMix() {
            return imgProductMix;
        }

        public ImageView getImgFeature1() {
            return imgFeature1;
        }

        public ImageView getImgFeature2() {
            return imgFeature2;
        }

        public TextView getTxtDesciption() {
            return txtDesciption;
        }
    }

    private class CollectionTypeAdapter {
    }
}
