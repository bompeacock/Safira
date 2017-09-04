package com.example.cong.myapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.MissyItemAdapter;
import com.example.cong.myapplication.interfaceView.IGroupProductView;
import com.example.cong.myapplication.model.MixProduct;
import com.example.cong.myapplication.presenter.GroupProductPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cong on 04/05/2017.
 */

public class MissyFragment extends Fragment implements IGroupProductView{

    @BindView(R.id.rvMissy)
    RecyclerView rvMissy;


    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;

    @BindView(R.id.layoutCollection)
    LinearLayout layoutCollection;


//    @BindView(R.id.fab)
//    FloatingActionButton fab;
    private int groupId;

    Context context;

    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    GroupProductPresenter groupProductPresenter;

    public MissyFragment() {
    }

    public MissyFragment(Context context, int groupId) {
        this.groupId = groupId;
        this.context = context;
        groupProductPresenter = new GroupProductPresenter(this);
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

        setUpViews();

        return view;

    }

    private void setUpViews() {
        groupProductPresenter.loadData(groupId);

    }

    @Override
    public void loadDataView(List<MixProduct> mixProducts) {
        MissyItemAdapter missyItemAdapter = new MissyItemAdapter(this.getContext(), mixProducts,groupId);

        staggeredGridLayoutManager  = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        rvMissy.setLayoutManager(staggeredGridLayoutManager);

        rvMissy.setAdapter(missyItemAdapter);

        layoutCollection.setVisibility(View.VISIBLE);
        pbLoading.setVisibility(View.GONE);


    }

    @Override
    public void loadDataViewMore() {

    }

    @Override
    public void showFailView() {

    }
}
