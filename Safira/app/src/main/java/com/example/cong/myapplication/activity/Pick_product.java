package com.example.cong.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.VerticalPagerAdapter;
import com.gigamole.infinitecycleviewpager.VerticalInfiniteCycleViewPager;

public class Pick_product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_product);

        final VerticalInfiniteCycleViewPager verticalInfiniteCycleViewPager =
                (VerticalInfiniteCycleViewPager) findViewById(R.id.vicvp);
        verticalInfiniteCycleViewPager.setAdapter(new VerticalPagerAdapter(this));

        verticalInfiniteCycleViewPager.setScrollDuration(1000);
    }
}
