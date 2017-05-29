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
import com.example.cong.myapplication.model.Color;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsProduct extends AppCompatActivity implements PickDetailsImageProductAdapter.IClicklistener {

    @BindView(R.id.img_details_product)
    ImageView mImageProduct;
    @BindView(R.id.rvImageProduct)
    RecyclerView rvImageProduct;
    @BindView(R.id.rvColor)
    RecyclerView rvImgColor;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_product);
        ButterKnife.bind(this);

        //set toolbar

        toolbar.setTitle("Details Product");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //fill data layout image product
        List<String> urlProducts = new ArrayList<>();
        urlProducts.add("https://www.vividlinen.com/images/product_photo/list/t3534_20170316043911_12209.jpg");
        urlProducts.add("https://www.vividlinen.com/images/product_photo/detail/t3534_20170316043924_12211.jpg");
        urlProducts.add("https://www.vividlinen.com/images/product_photo/list/t3534_20170316043911_12209.jpg");
        urlProducts.add("https://www.vividlinen.com/images/product_photo/list/t3534_20170316043911_12209.jpg");
        PickDetailsImageProductAdapter mPickDetailsImageProductAdapter = new PickDetailsImageProductAdapter(this,urlProducts);
        rvImageProduct.setAdapter(mPickDetailsImageProductAdapter);

        //fill data image color
        List<Color> colors = new ArrayList<>();
        colors.add(new Color("","http://vividlinen.com/images/product_color_box_main/thumb/color_20141114103634_11818.jpg"));
        colors.add(new Color("","http://vividlinen.com/images/product_color_box_main/thumb/p3431_20140801084539_17147.jpg"));
        colors.add(new Color("","http://vividlinen.com/images/product_color_box_main/thumb/p3431_20140801084539_17147.jpg"));
        ColorAdapter colorAdapter = new ColorAdapter(this,colors);
        rvImgColor.setAdapter(colorAdapter);
    }

    @Override
    public void updateImage(String url) {
        Picasso.with(this).load(url)
                .placeholder(R.drawable.progress)
                .into(mImageProduct);

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
