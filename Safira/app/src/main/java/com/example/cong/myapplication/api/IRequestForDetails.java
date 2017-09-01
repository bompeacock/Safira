package com.example.cong.myapplication.api;

import com.example.cong.myapplication.model.Color;
import com.example.cong.myapplication.model.ResultGetCode;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Cong on 01/09/2017.
 */

public interface IRequestForDetails {

    @GET("product/get-color-by-image")
    Call<List<Color>>  getColors(@Query("imageCode") String imageCode);

    @GET("product/get-product-by-id")
    Call<ResultGetCode> getCode(@Query("productId") int groupId);
}
