package com.example.cong.myapplication.api;

import com.example.cong.myapplication.model.Banner;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by CongNV4 on 8/31/2017.
 */

public interface IRequestForBanner {
    @GET("banner/single-images")
    Call<Banner> getBanner(@Query("groupId") int groupId, @Query("typeId") int typeId, @Query("location") boolean location);

}
