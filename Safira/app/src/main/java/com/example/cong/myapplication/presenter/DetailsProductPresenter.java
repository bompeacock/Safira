package com.example.cong.myapplication.presenter;

import com.example.cong.myapplication.api.IRequestSingleImage;
import com.example.cong.myapplication.interfaceView.IDetailsProductView;
import com.example.cong.myapplication.model.ResultDetails;
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

    public DetailsProductPresenter(IDetailsProductView detailsProductView) {
        this.detailsProductView = detailsProductView;
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
}
