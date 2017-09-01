package com.example.cong.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.CartAdapter;
import com.example.cong.myapplication.interfaceView.ICartView;
import com.example.cong.myapplication.model.ProductInCart;
import com.example.cong.myapplication.presenter.CartPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Cart extends AppCompatActivity implements ICartView{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rvProductCart)
    RecyclerView rvProductCart;

    @BindView(R.id.txtCheckOut)
    TextView txtCheckOut;

    CartPresenter cartPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ButterKnife.bind(this);

        cartPresenter = new CartPresenter(this);

        setupView();

        setUpEvents();
    }

    private void setUpEvents() {
        txtCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Address.class);
                startActivity(intent);
            }
        });
    }

    private void setupView() {


        toolbar.setTitle("Cart");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cartPresenter.loadDataCart();



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
    public void loadViewCart(List<ProductInCart> cart) {
        rvProductCart.setAdapter(new CartAdapter(this, cart));
        rvProductCart.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void loadFailView() {

    }
}
