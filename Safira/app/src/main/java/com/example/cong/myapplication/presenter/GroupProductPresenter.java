package com.example.cong.myapplication.presenter;

import com.example.cong.myapplication.api.IProductMixGroupRequest;
import com.example.cong.myapplication.interfaceView.IGroupProductView;
import com.example.cong.myapplication.model.MixProduct;
import com.example.cong.myapplication.model.SearchRequest;
import com.example.cong.myapplication.utils.RetrofitUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Cong on 26/08/2017.
 */

public class GroupProductPresenter {
    IGroupProductView groupProductView;

    private SearchRequest searchRequest;


    public GroupProductPresenter(IGroupProductView groupProductView) {
        this.groupProductView = groupProductView;
    }


    public void loadData(int groupId) {
        searchRequest = new SearchRequest();
        searchRequest.setGroup(groupId);

        IProductMixGroupRequest productMixGroupRequest = RetrofitUtils.getRetrofitWithRealServer().create(IProductMixGroupRequest.class);
        productMixGroupRequest.getProductMix(searchRequest.castToMap()).enqueue(new Callback<List<MixProduct>>() {
            @Override
            public void onResponse(Call<List<MixProduct>> call, Response<List<MixProduct>> response) {
                if(response!=null)groupProductView.loadDataView(response.body());
            }

            @Override
            public void onFailure(Call<List<MixProduct>> call, Throwable t) {

            }
        });
    }

}
