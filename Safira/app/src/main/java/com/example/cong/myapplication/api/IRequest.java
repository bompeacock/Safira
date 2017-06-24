package com.example.cong.myapplication.api;

import com.example.cong.myapplication.model.ResultsCollection;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Cong on 22/06/2017.
 */

public interface IRequest {
    @GET("product/complexAPI")
    Call<List<ResultsCollection>> listCollection();





}
