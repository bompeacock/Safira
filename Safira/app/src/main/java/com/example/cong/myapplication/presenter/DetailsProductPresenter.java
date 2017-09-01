package com.example.cong.myapplication.presenter;

import com.example.cong.myapplication.api.IRequestForDetails;
import com.example.cong.myapplication.api.IRequestSingleImage;
import com.example.cong.myapplication.interfaceView.IDetailsProductView;
import com.example.cong.myapplication.model.Color;
import com.example.cong.myapplication.model.ResultDetails;
import com.example.cong.myapplication.model.ResultGetCode;
import com.example.cong.myapplication.utils.RetrofitUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Cong on 27/08/2017.
 */

public class DetailsProductPresenter {
    IDetailsProductView detailsProductView;

    IRequestForDetails requestForDetails;
    public DetailsProductPresenter(IDetailsProductView detailsProductView) {
        this.detailsProductView = detailsProductView;
        requestForDetails = RetrofitUtils.getRetrofitWithRealServer()
                .create(IRequestForDetails.class);
    }

    public void loadDataImagesProduct(String code) {
        IRequestSingleImage requestSingleImage = RetrofitUtils.getRetrofitWithRealServer()
                .create(IRequestSingleImage.class);

        requestSingleImage.getImagesDetails(code).enqueue(new Callback<List<ResultDetails>>() {
            @Override
            public void onResponse(Call<List<ResultDetails>> call, Response<List<ResultDetails>> response) {
                List<String> urlList =  handleResponse(response.body());

                if(urlList!=null)detailsProductView.loadViewImagesDetails(urlList);
            }

            @Override
            public void onFailure(Call<List<ResultDetails>> call, Throwable t) {

            }
        });

    }

    private List<String> handleResponse(List<ResultDetails> body) {
        List<String> list = new ArrayList<>();
        for(ResultDetails resultDetails: body){
            list.add(resultDetails.getPath());
        }
        return list;
    }

    public void loadDataImageColor(String code) {

        requestForDetails.getColors(code).enqueue(new Callback<List<Color>>() {
            @Override
            public void onResponse(Call<List<Color>> call, Response<List<Color>> response) {
                detailsProductView.loadViewProductColor(response.body());
            }

            @Override
            public void onFailure(Call<List<Color>> call, Throwable t) {

            }
        });
    }

    public void loadDataCode(int productId) {
        requestForDetails.getCode(productId).enqueue(new Callback<ResultGetCode>() {
            @Override
            public void onResponse(Call<ResultGetCode> call, Response<ResultGetCode> response) {

                loadDataImagesProduct(response.body().getImageTarget().getResultDetails().getCode());
            }

            @Override
            public void onFailure(Call<ResultGetCode> call, Throwable t) {

            }
        });

    }
}
