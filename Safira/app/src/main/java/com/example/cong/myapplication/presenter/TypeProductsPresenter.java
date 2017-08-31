package com.example.cong.myapplication.presenter;

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

    Banner banner ;

    List<ResultProducByGroupAndType> resultProducByGroupAndTypes;
    public TypeProductsPresenter(ITypeProductsView typeProductsView) {
        this.typeProductsView = typeProductsView;
    }

    public void loadData(int groupId, int typeId){
        IRequestForGroupAndType request = RetrofitUtils.getRetrofitWithRealServer().create(IRequestForGroupAndType.class);
        request.getBanner(groupId,typeId,true).enqueue(new Callback<Banner>() {
            @Override
            public void onResponse(Call<Banner> call, Response<Banner> response) {
                  response.body();
            }

            @Override
            public void onFailure(Call<Banner> call, Throwable t) {
                typeProductsView.loadViewFail();
            }
        });


        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setGroup(groupId);
        searchRequest.setTypeId(typeId);

        request.getProductType(searchRequest.castToMap(),true,4).enqueue(new Callback<List<ResultProducByGroupAndType>>() {
            @Override
            public void onResponse(Call<List<ResultProducByGroupAndType>> call, Response<List<ResultProducByGroupAndType>> response) {
                resultProducByGroupAndTypes = response.body();
            }

            @Override
            public void onFailure(Call<List<ResultProducByGroupAndType>> call, Throwable t) {

            }
        });

        typeProductsView.loadDataSuccess(banner,resultProducByGroupAndTypes);

    }
}
