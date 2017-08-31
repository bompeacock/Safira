package com.example.cong.myapplication.presenter;

import com.example.cong.myapplication.api.IRequestForBanner;
import com.example.cong.myapplication.api.IRequestForGroupAndType;
import com.example.cong.myapplication.interfaceView.ITypeProductsView;
import com.example.cong.myapplication.model.Banner;
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


    public TypeProductsPresenter(ITypeProductsView typeProductsView) {
        this.typeProductsView = typeProductsView;


        request = RetrofitUtils.getRetrofitWithRealServer().create(IRequestForGroupAndType.class);

        requestForBanner = RetrofitUtils.getRetrofitWithRealServer().create(IRequestForBanner.class);

    }

    public void loadData(final int groupId, final int typeId){


        requestForBanner.getBanner(groupId,typeId,true).enqueue(new Callback<Banner>() {
            @Override
            public void onResponse(Call<Banner> call, Response<Banner> response) {
                if(response!=null){
                    handleBanner(response,groupId,typeId);
                }
            }

            @Override
            public void onFailure(Call<Banner> call, Throwable t) {

            }
        });





    }

    private void handleBanner(Response<Banner> response, int groupId, int typeId) {
        final Banner banner = response.body();

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setGroup(groupId);
        searchRequest.setTypeId(typeId);

        request.getProductType(searchRequest.castToMap(),true,4).enqueue(new Callback<List<ResultProducByGroupAndType>>() {
            @Override
            public void onResponse(Call<List<ResultProducByGroupAndType>> call, Response<List<ResultProducByGroupAndType>> response) {
                handleProducts(response, banner);
            }

            @Override
            public void onFailure(Call<List<ResultProducByGroupAndType>> call, Throwable t) {

            }
        });

    }

    private void handleProducts(Response<List<ResultProducByGroupAndType>> response, Banner banner) {
        List<ResultProducByGroupAndType> resultProducByGroupAndTypes = response.body();
        typeProductsView.loadDataSuccess(banner,resultProducByGroupAndTypes);


    }

}
