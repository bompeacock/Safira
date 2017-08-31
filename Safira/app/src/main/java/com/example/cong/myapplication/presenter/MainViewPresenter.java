package com.example.cong.myapplication.presenter;

import com.example.cong.myapplication.api.IRequestForGroupAndType;
import com.example.cong.myapplication.interfaceView.IMainView;
import com.example.cong.myapplication.model.Group;
import com.example.cong.myapplication.model.Type;
import com.example.cong.myapplication.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Cong on 30/08/2017.
 */

public class MainViewPresenter {
    IMainView iMainView;


    HashMap<Group, List<Type>> types = new HashMap<>();

    IRequestForGroupAndType requestForGroupAndType;
    public MainViewPresenter(IMainView iMainView) {
        this.iMainView = iMainView;
        requestForGroupAndType = RetrofitUtils.getRetrofitWithRealServer().create(IRequestForGroupAndType.class);

    }

    public void loadDataForDrawer() {
        loadDataForGroup();
    }


    private void handleGroup(Response<List<Group>> response) {
        List<Group> groups = response.body();
        for(final Group group: groups){
            requestForGroupAndType.getType(group.getId(),true).enqueue(new Callback<List<Type>>() {
                @Override
                public void onResponse(Call<List<Type>> call, Response<List<Type>> response) {
                        Group g =  group;
                       handleType(g, response.body());
                }

                @Override
                public void onFailure(Call<List<Type>> call, Throwable t) {

                }
            });
        }
        iMainView.setUpViewOfDraw(groups,types);

    }

    private void handleType(Group g, List<Type> body) {
        types.put(g,body);
    }


    private void loadDataForGroup() {
        requestForGroupAndType.getGroup(true).enqueue(new Callback<List<Group>>() {
            @Override
            public void onResponse(Call<List<Group>> call, Response<List<Group>> response) {
                handleGroup(response);
            }

            @Override
            public void onFailure(Call<List<Group>> call, Throwable t) {

            }
        });
    }




}
