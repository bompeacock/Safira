package com.example.cong.myapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.MissyItemAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cong on 04/05/2017.
 */

public class MissyFragment extends Fragment {

    @BindView(R.id.rvMissy)
    RecyclerView rvMissy;

//    @BindView(R.id.fab)
//    FloatingActionButton fab;

    Context context;

    GridLayoutManager manager;

    public MissyFragment(Context context) {
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
        MissyItemAdapter missyItemAdapter = new MissyItemAdapter(this.getContext());
        rvMissy.setAdapter(missyItemAdapter);
        rvMissy.setHasFixedSize(true);
        manager = new GridLayoutManager(context,2);
        rvMissy.setLayoutManager(manager);

        return view;

    }
}
