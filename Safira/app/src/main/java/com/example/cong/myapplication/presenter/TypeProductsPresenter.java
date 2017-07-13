package com.example.cong.myapplication.presenter;

import com.example.cong.myapplication.api.IRequest;
import com.example.cong.myapplication.interfaceView.ITypeProductsView;
import com.example.cong.myapplication.model.ResultProductsType;
import com.example.cong.myapplication.utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Cong on 12/07/2017.
 */

public class TypeProductsPresenter  {
    ITypeProductsView  typeProductsView;

    public TypeProductsPresenter(ITypeProductsView typeProductsView) {
        this.typeProductsView = typeProductsView;
    }

    public void loadData(){
        IRequest request = RetrofitUtils.getNormally().create(IRequest.class);
        request.getProductsByType().enqueue(new Callback<ResultProductsType>() {
            @Override
            public void onResponse(Call<ResultProductsType> call, Response<ResultProductsType> response) {
                if(response!=null){
                    typeProductsView.loadDataSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResultProductsType> call, Throwable t) {
                typeProductsView.loadViewFail();
            }
        });

    }
}
