package com.example.cong.myapplication.api;

import com.example.cong.myapplication.model.MixProduct;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Cong on 26/08/2017.
 */

public interface IProductMixGroupRequest {
    @GET("mix-image/getPageMixImage")
    Call<List<MixProduct>> getProductMix(@QueryMap(encoded = true)Map<String,String> option);

    

}
