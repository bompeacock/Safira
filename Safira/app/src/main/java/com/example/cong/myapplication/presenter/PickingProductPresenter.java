package com.example.cong.myapplication.presenter;

import com.example.cong.myapplication.api.IRequestSingleImage;
import com.example.cong.myapplication.interfaceView.IPickingProductView;
import com.example.cong.myapplication.model.ResultPickProductAndRec;
import com.example.cong.myapplication.utils.RetrofitUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Cong on 26/08/2017.
 */

public class PickingProductPresenter {

    IPickingProductView pickingProductView;

    private int mixImageid;
    public PickingProductPresenter(IPickingProductView pickingProductView, int mixImageid) {
        this.pickingProductView = pickingProductView;
        this.mixImageid = mixImageid;
    }

    public void loadData() {
        IRequestSingleImage requestSingleImage = RetrofitUtils.getRetrofitWithRealServer().create(IRequestSingleImage.class);
        requestSingleImage.getProductForPicking(mixImageid).enqueue(new Callback<List<ResultPickProductAndRec>>() {
            @Override
            public void onResponse(Call<List<ResultPickProductAndRec>> call, Response<List<ResultPickProductAndRec>> response) {

                if(response!=null) pickingProductView.loadViewProduct(response.body());

            }

            @Override
            public void onFailure(Call<List<ResultPickProductAndRec>> call, Throwable t) {

            }
        });

    }


}
