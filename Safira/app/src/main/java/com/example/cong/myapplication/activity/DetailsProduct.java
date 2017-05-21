package com.example.cong.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.cong.myapplication.R;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

public class DetailsProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_product);
        final HorizontalInfiniteCycleViewPager viewPager = (HorizontalInfiniteCycleViewPager) findViewById(R.id.pageImage);

    }
}
