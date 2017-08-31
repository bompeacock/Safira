package com.example.cong.myapplication.presenter;

import com.example.cong.myapplication.api.IRequestSingleImage;
import com.example.cong.myapplication.interfaceView.ISearchView;
import com.example.cong.myapplication.model.ResultProducByGroupAndType;
import com.example.cong.myapplication.utils.RetrofitUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Cong on 31/08/2017.
 */

public class SearchPresenter {
    ISearchView searchView;

    IRequestSingleImage requestSingleImage;
    public SearchPresenter(ISearchView searchView) {
        this.searchView = searchView;
        requestSingleImage = RetrofitUtils.getRetrofitWithRealServer().create(IRequestSingleImage.class);
    }

    public void search(String newText) {
        requestSingleImage.search(newText,true).enqueue(new Callback<List<ResultProducByGroupAndType>>() {
            @Override
            public void onResponse(Call<List<ResultProducByGroupAndType>> call, Response<List<ResultProducByGroupAndType>> response) {
                searchView.loadProductVew(response.body());
            }

            @Override
            public void onFailure(Call<List<ResultProducByGroupAndType>> call, Throwable t) {

            }
        });
    }
}
