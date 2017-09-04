package com.example.cong.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.PickProductAdapter;
import com.example.cong.myapplication.interfaceView.IPickingProductView;
import com.example.cong.myapplication.model.ResultPickProductAndRec;
import com.example.cong.myapplication.presenter.PickingProductPresenter;
import com.gigamole.infinitecycleviewpager.VerticalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Pick_product extends AppCompatActivity  implements IPickingProductView{


    PickingProductPresenter pickingProductPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.vicvp)
    VerticalInfiniteCycleViewPager verticalInfiniteCycleViewPager;

    List<ResultPickProductAndRec> resultPickProductAndRecs;

    PickProductAdapter pickProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_product);

        ButterKnife.bind(this);

        int mixImageId = getIntent().getIntExtra("mixImageId",-1);

        resultPickProductAndRecs = new ArrayList<>();
        pickProductAdapter  = new PickProductAdapter(this, resultPickProductAndRecs);

        pickingProductPresenter = new PickingProductPresenter(this,mixImageId);


        setupView();




    }

    private void setupView() {
        toolbar.setTitle("Pick product");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        verticalInfiniteCycleViewPager.setAdapter(pickProductAdapter);
        verticalInfiniteCycleViewPager.setScrollDuration(2000);
        verticalInfiniteCycleViewPager.animate();
//        verticalInfiniteCycleViewPager.setMaxPageScale(0.8F);
//        verticalInfiniteCycleViewPager.setMinPageScale(0.5F);
//        verticalInfiniteCycleViewPager.setCenterPageScaleOffset(30.0F);
//        verticalInfiniteCycleViewPager.setMinPageScaleOffset(5.0F);

        pickingProductPresenter.loadData();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loadViewProduct(List<ResultPickProductAndRec> resultPickProductAndRecs) {
//        verticalInfiniteCycleViewPager.setOffscreenPageLimit(resultPickProductAndRecs.size());
        pickProductAdapter.addNewData(resultPickProductAndRecs);
        toolbar.setTitle("Mix (" + resultPickProductAndRecs.size()+") " +"products");


    }

    @Override
    public void loadFailView() {

    }
}
