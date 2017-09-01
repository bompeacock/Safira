package com.example.cong.myapplication.presenter;

import com.example.cong.myapplication.api.IRequestForBanner;
import com.example.cong.myapplication.api.IRequestForGroupAndType;
import com.example.cong.myapplication.api.IRequestSingleImage;
import com.example.cong.myapplication.interfaceView.ITypeProductsView;
import com.example.cong.myapplication.model.Banner;
import com.example.cong.myapplication.model.ResultDetails;
import com.example.cong.myapplication.model.ResultProducByGroupAndType;
import com.example.cong.myapplication.model.SearchRequest;
import com.example.cong.myapplication.utils.RetrofitUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Cong on 12/07/2017.
 */

public class TypeProductsPresenter  {
    ITypeProductsView  typeProductsView;


    IRequestForGroupAndType request;

    IRequestForBanner requestForBanner;

    IRequestSingleImage requestSingleImage;

    public TypeProductsPresenter(ITypeProductsView typeProductsView) {
        this.typeProductsView = typeProductsView;

        request = RetrofitUtils.getRetrofitWithRealServer().create(IRequestForGroupAndType.class);

        requestForBanner = RetrofitUtils.getRetrofitWithRealServer().create(IRequestForBanner.class);

        requestSingleImage = RetrofitUtils.getRetrofitWithRealServer().create(IRequestSingleImage.class);
    }

    public void loadDataBanner(int groupId, int typeId) {
        requestForBanner.getBanner(groupId,typeId,true).enqueue(new Callback<Banner>() {
            @Override
            public void onResponse(Call<Banner> call, Response<Banner> response) {
                if(response!=null){
                    typeProductsView.loadBanner(response.body());
                }
            }

            @Override
            public void onFailure(Call<Banner> call, Throwable t) {

            }
        });
    }

    public void loadDataProduct(int groupId, int typeId) {

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setGroup(groupId);
        searchRequest.setTypeId(typeId);

        request.getProductType(searchRequest.castToMap(),true,4).enqueue(new Callback<List<ResultProducByGroupAndType>>() {
            @Override
            public void onResponse(Call<List<ResultProducByGroupAndType>> call, Response<List<ResultProducByGroupAndType>> response) {
                typeProductsView.loadListProduct(response.body());
            }

            @Override
            public void onFailure(Call<List<ResultProducByGroupAndType>> call, Throwable t) {

            }
        });
    }

    public void loadDataItemByColor(int id, final int position) {
        requestSingleImage.getInfoFromColor(id).enqueue(new Callback<ResultDetails>() {
            @Override
            public void onResponse(Call<ResultDetails> call, Response<ResultDetails> response) {
                typeProductsView.loadImage(response.body(),position);
            }

            @Override
            public void onFailure(Call<ResultDetails> call, Throwable t) {

            }
        });

    }
}
