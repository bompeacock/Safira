package com.example.cong.myapplication.presenter;

import android.widget.Toast;

import com.example.cong.myapplication.api.IRequest;
import com.example.cong.myapplication.interfaceView.ICollectionView;
import com.example.cong.myapplication.model.ResultsCollection;
import com.example.cong.myapplication.utils.RetrofitUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Cong on 01/07/2017.
 */

public class ColFragmentPresenter {
    private ICollectionView collectionView;

    public ColFragmentPresenter(ICollectionView collectionView) {
        this.collectionView = collectionView;
    }

    public void loadComplexData(){

        IRequest request  = RetrofitUtils.getNormally().create(IRequest.class);

        request.listCollection().enqueue(new Callback<List<ResultsCollection>>() {
            @Override
            public void onResponse(Call<List<ResultsCollection>> call, Response<List<ResultsCollection>> response) {
                if(response!=null){
                   collectionView.loadViewsCollection(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ResultsCollection>> call, Throwable t) {
                collectionView.showFailView();
            }
        });

    }
}
