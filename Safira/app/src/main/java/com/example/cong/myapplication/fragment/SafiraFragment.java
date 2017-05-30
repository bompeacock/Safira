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

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.SafiraAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

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
//        manager.getSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return 0;
//            }
//        });

        rvMissy.setAdapter(safiraAdapter);

        return view;

    }
}
