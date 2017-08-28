package com.example.cong.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.PickProductAdapter;
import com.example.cong.myapplication.interfaceView.IPickingProductView;
import com.example.cong.myapplication.model.ResultPickProductAndRec;
import com.example.cong.myapplication.presenter.PickingProductPresenter;
import com.gigamole.infinitecycleviewpager.VerticalInfiniteCycleViewPager;

import java.util.List;

public class Pick_product extends AppCompatActivity  implements IPickingProductView{

    Intent intent;

    PickingProductPresenter pickingProductPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_product);

        intent = getIntent();

        int mixImageId = intent.getIntExtra("mixImageId",-1);
        int groupId = intent.getIntExtra("groupId", -1);


        pickingProductPresenter = new PickingProductPresenter(this,mixImageId);


        setupView();




    }

    private void setupView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Pick product");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pickingProductPresenter.loadData();

    }

    @Override
    public void loadViewProduct(List<ResultPickProductAndRec> resultPickProductAndRecs) {
        final VerticalInfiniteCycleViewPager verticalInfiniteCycleViewPager =
                (VerticalInfiniteCycleViewPager) findViewById(R.id.vicvp);
        verticalInfiniteCycleViewPager.setAdapter(new PickProductAdapter(this, resultPickProductAndRecs));
        verticalInfiniteCycleViewPager.setScrollDuration(2000);
        verticalInfiniteCycleViewPager.animate();
    }

    @Override
    public void loadFailView() {

    }
}
