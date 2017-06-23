package com.example.cong.myapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.SafiraAdapter;
import com.example.cong.myapplication.api.IRequest;
import com.example.cong.myapplication.model.ResultsCollection;
import com.example.cong.myapplication.utils.RetrofitUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Cong on 30/05/2017.
 */

public class SafiraFragment extends Fragment{
    @BindView(R.id.rvMissy)
    RecyclerView rvMissy;

    Context context;

    GridLayoutManager manager;

    public SafiraFragment(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //test Retrofit
        IRequest request  = RetrofitUtils.getNormally().create(IRequest.class);

        request.listCollection().enqueue(new Callback<List<ResultsCollection>>() {
            @Override
            public void onResponse(Call<List<ResultsCollection>> call, Response<List<ResultsCollection>> response) {
                if(response!=null){
                    Toast.makeText(context,response.body().toString()+"ok",Toast.LENGTH_LONG).show();
                }else Toast.makeText(context,"nothing here",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<ResultsCollection>> call, Throwable t) {
                Toast.makeText(context,"Failed",Toast.LENGTH_LONG).show();
            }
        });



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_missy,container,false);
        ButterKnife.bind(this,view);




        SafiraAdapter safiraAdapter = new SafiraAdapter(this.getContext());
        rvMissy.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvMissy.setLayoutManager(llm);


        rvMissy.setAdapter(safiraAdapter);

        return view;

    }
}
