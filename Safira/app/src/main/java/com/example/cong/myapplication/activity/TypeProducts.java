package com.example.cong.myapplication.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.InsideSafiraAdapter;
import com.example.cong.myapplication.interfaceView.ITypeProductsView;
import com.example.cong.myapplication.model.Banner;
import com.example.cong.myapplication.model.Product;
import com.example.cong.myapplication.model.ResultProductsType;
import com.example.cong.myapplication.presenter.TypeProductsPresenter;
import com.example.cong.myapplication.utils.Constant;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TypeProducts extends AppCompatActivity implements ITypeProductsView {

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rvProductsType)
    RecyclerView rvProductsType;

    @BindView(R.id.imgCollapsing)
    ImageView imgCollapsing;

//    @BindView(R.id.layoutTypeProducts)
//    RelativeLayout layoutTypeProducts;
//
//    @BindView(R.id.pbLoading)
//    RelativeLayout pbloading;

    private TypeProductsPresenter typeProductsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_products);
        ButterKnife.bind(this);

        typeProductsPresenter = new TypeProductsPresenter(this);

        prepareView();

        typeProductsPresenter.loadData();

    }

    private void prepareView() {
        GridLayoutManager manager = new GridLayoutManager(getBaseContext(),2);
        rvProductsType.setLayoutManager(manager);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public void loadDataSuccess(ResultProductsType resultProductsType) {
        Banner banner = resultProductsType.getBanner();

        List<Product> productList = resultProductsType.getProducts();

        Picasso.with(this).load(Constant.IMAGE_URL + banner.getUrlBanner())
                .into(imgCollapsing);

        rvProductsType.setAdapter(new InsideSafiraAdapter(this,productList));

//        layoutTypeProducts.setVisibility(View.VISIBLE);
//        pbloading.setVisibility(View.GONE);
    }

    @Override
    public void loadViewFail() {
        Toast.makeText(this,"Failed connect",Toast.LENGTH_LONG).show();

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
}
