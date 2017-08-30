package com.example.cong.myapplication.utils;

import android.content.Context;
import android.widget.ImageView;

import com.example.cong.myapplication.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Cong on 27/08/2017.
 */

public class PicassoUtils {
    public static void loadImage(Context context, String urlImage, ImageView img){
        Picasso.with(context)
                .load(urlImage)
                .placeholder(R.drawable.progress)
                .into(img);
    }
    public static void loadImageAnResize(Context context, String urlImage, ImageView img){
        Picasso.with(context)
                .load(urlImage)
                .placeholder(R.drawable.progress)
                .resize(40,60)
                .into(img);
    }
    public static void loadImageAndResizeForMix(Context context, String urlImage, ImageView img){
        Picasso.with(context)
                .load(urlImage)
                .placeholder(R.drawable.progress)
                .resize(200,250)
                .into(img);
    }
    public static void loadImageAndResizeForCart(Context context, String urlImage, ImageView img){
        Picasso.with(context)
                .load(urlImage)
                .placeholder(R.drawable.progress)
                .resize(150,200)
                .into(img);
    }

}
