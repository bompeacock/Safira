package com.example.cong.myapplication.api;

import com.example.cong.myapplication.model.Banner;
import com.example.cong.myapplication.model.Group;
import com.example.cong.myapplication.model.ResultProducByGroupAndType;
import com.example.cong.myapplication.model.Type;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Cong on 30/08/2017.
 */

public interface IRequestForGroupAndType {
    @GET("group")
    Call<List<Group>> getGroup(@Query("location") boolean location);

    @GET("type")
    Call<List<Type>>  getType(@Query("groupId") int groupId, @Query("location") boolean location);


    @GET("single-image")
    Call<List<ResultProducByGroupAndType>> getProductType(@QueryMap(encoded = true)Map<String,String> option
            , @Query("location") boolean location, @Query("feature") int a);


}
