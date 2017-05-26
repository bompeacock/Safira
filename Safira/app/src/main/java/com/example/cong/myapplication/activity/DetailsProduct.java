package com.example.cong.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.PickDetailsImageProductAdapter;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_product);
        ButterKnife.bind(this);

        List<String> urls = new ArrayList<>();
        urls.add("https://www.vividlinen.com/images/product_photo/list/t3534_20170316043911_12209.jpg");
        urls.add("https://www.vividlinen.com/images/product_photo/detail/t3534_20170316043924_12211.jpg");
        urls.add("https://www.vividlinen.com/images/product_photo/list/t3534_20170316043911_12209.jpg");
        urls.add("https://www.vividlinen.com/images/product_photo/list/t3534_20170316043911_12209.jpg");
        PickDetailsImageProductAdapter mPickDetailsImageProductAdapter = new PickDetailsImageProductAdapter(this,urls);
        rvImageProduct.setAdapter(mPickDetailsImageProductAdapter);

    }

    @Override
    public void updateImage(String url) {
        Picasso.with(this).load(url)
                .placeholder(R.drawable.progress)
                .into(mImageProduct);

    }
}
