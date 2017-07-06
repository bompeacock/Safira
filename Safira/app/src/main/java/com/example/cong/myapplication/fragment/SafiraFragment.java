package com.example.cong.myapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.SafiraAdapter;
import com.example.cong.myapplication.interfaceView.ICollectionView;
import com.example.cong.myapplication.model.ResultsCollection;
import com.example.cong.myapplication.presenter.ColFragmentPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cong on 30/05/2017.
 */

public class SafiraFragment extends Fragment implements ICollectionView{
    @BindView(R.id.rvCollection)
    RecyclerView rvCollection;

    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;

    @BindView(R.id.layoutCollection)
    LinearLayout linearLayout;

    Context context;
    ColFragmentPresenter colFragmentPresenter;

    public SafiraFragment(Context context) {
        this.context = context;
        colFragmentPresenter = new ColFragmentPresenter(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(context,"onCreate",Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_collection,container,false);
        ButterKnife.bind(this,view);

        colFragmentPresenter.loadComplexData();
        Toast.makeText(context,"onView",Toast.LENGTH_SHORT).show();
        return view;

    }

    @Override
    public void loadViewsCollection(List<ResultsCollection> listColleciton) {

        SafiraAdapter safiraAdapter = new SafiraAdapter(listColleciton,context);
        rvCollection.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvCollection.setLayoutManager(llm);
        rvCollection.setAdapter(safiraAdapter);

        linearLayout.setVisibility(View.VISIBLE);
        pbLoading.setVisibility(View.GONE);

    }

    @Override
    public Context getContextView() {
        return this.context;
    }

    @Override
    public void showFailView() {
        Toast.makeText(context,"Failed connect",Toast.LENGTH_LONG).show();
    }
}
