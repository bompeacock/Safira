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
import com.example.cong.myapplication.adapter.ColorMiniAdapter;
import com.example.cong.myapplication.adapter.InsideSafiraAdapter;
import com.example.cong.myapplication.interfaceView.ITypeProductsView;
import com.example.cong.myapplication.model.Banner;
import com.example.cong.myapplication.model.Product;
import com.example.cong.myapplication.model.ResultProducByGroupAndType;
import com.example.cong.myapplication.presenter.TypeProductsPresenter;
import com.example.cong.myapplication.utils.Constant;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TypeProducts extends AppCompatActivity implements ITypeProductsView, ColorMiniAdapter.IMiniColor {

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

    int groupId;
    int typeId;
    String title;

    private TypeProductsPresenter typeProductsPresenter;

    private InsideSafiraAdapter insideSafiraAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_products);
        ButterKnife.bind(this);

        groupId = getIntent().getIntExtra("groupId",-1);
        typeId = getIntent().getIntExtra("typeId",-1);
        title = getIntent().getStringExtra("title");

        typeProductsPresenter = new TypeProductsPresenter(this);

        prepareView(title);



    }

    private void prepareView(String title) {
        GridLayoutManager manager = new GridLayoutManager(getBaseContext(),2);
        rvProductsType.setLayoutManager(manager);

        setSupportActionBar(toolbar);
        toolbar.setTitle(title);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        typeProductsPresenter.loadDataBanner(groupId, typeId);
        typeProductsPresenter.loadDataProduct(groupId, typeId);

    }

    @Override
    public void loadListProduct(List<ResultProducByGroupAndType> resultProducByGroupAndTypes) {
        insideSafiraAdapter =new InsideSafiraAdapter(this,resultProducByGroupAndTypes);
        rvProductsType.setAdapter(insideSafiraAdapter);

    }

    @Override
    public void loadBanner(Banner banner) {
        Picasso.with(this).load(Constant.IMAGE_URL_BANNER + banner.getPath())
                .into(imgCollapsing);
    }

    @Override
    public void loadViewFail() {
        Toast.makeText(this,"Failed connect",Toast.LENGTH_LONG).show();

    }

    @Override
    public void loadImage(Product product, int position) {
        insideSafiraAdapter.changeInfoItem(product, position);
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
    public void updateImageProduct(int id, int position) {
        typeProductsPresenter.loadDataItemByColor(id,position);
    }
}
