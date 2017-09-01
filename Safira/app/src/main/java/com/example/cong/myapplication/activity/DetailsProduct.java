package com.example.cong.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.ColorAdapter;
import com.example.cong.myapplication.adapter.PickDetailsImageProductAdapter;
import com.example.cong.myapplication.interfaceView.IDetailsProductView;
import com.example.cong.myapplication.model.Color;
import com.example.cong.myapplication.presenter.DetailsProductPresenter;
import com.example.cong.myapplication.utils.PicassoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsProduct extends AppCompatActivity implements PickDetailsImageProductAdapter.IClicklistener, IDetailsProductView,ColorAdapter.IImageProduct {

    @BindView(R.id.img_details_product)
    ImageView mImageProduct;
    @BindView(R.id.rvImageProduct)
    RecyclerView rvImageProduct;
    @BindView(R.id.rvColor)
    RecyclerView rvImgColor;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rvRecommend)
    RecyclerView rvRecommend;

    private String code;

    private DetailsProductPresenter detailsProductPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_product);
        ButterKnife.bind(this);

        code = getIntent().getStringExtra("code");

        detailsProductPresenter = new DetailsProductPresenter(this);

        setupView();



        //fill data rv recommandation
//        MissyItemAdapter missyItemAdapter  = new MissyItemAdapter(this,);
//        rvRecommend.setAdapter(missyItemAdapter);
//        GridLayoutManager manager  = new GridLayoutManager(this,2);
//        rvRecommend.setLayoutManager(manager);
    }

    private void setupView() {
        //set toolbar
        toolbar.setTitle("Details Product");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //fill data layout image product
        detailsProductPresenter.loadDataImagesProduct(code);
        detailsProductPresenter.loadDataImageColor(code);
    }

    @Override
    public void updateImage(String url) {
        PicassoUtils.loadImage(this, url, mImageProduct);

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
    public void loadViewImagesDetails(List<String> urlProducts) {
        PickDetailsImageProductAdapter mPickDetailsImageProductAdapter = new PickDetailsImageProductAdapter(this,urlProducts);
        rvImageProduct.setAdapter(mPickDetailsImageProductAdapter);

    }

    @Override
    public void loadViewInfoProduct() {

    }

    @Override
    public void loadViewProductColor(List<Color> colors) {
        //fill data image color

        ColorAdapter colorAdapter = new ColorAdapter(this,colors);
        rvImgColor.setAdapter(colorAdapter);

    }

    @Override
    public void loadViewRecommandation() {

    }

    @Override
    public void setImageProduct(int productId) {
        detailsProductPresenter.loadDataCode(productId);
    }
}
