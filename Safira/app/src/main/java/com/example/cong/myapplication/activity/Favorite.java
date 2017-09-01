package com.example.cong.myapplication.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.cong.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Favorite extends AppCompatActivity {

    @BindView(R.id.btnAddToCart)
    Button btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        ButterKnife.bind(this);

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Add to Cart successfully",Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
