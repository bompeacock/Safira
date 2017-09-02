package com.example.cong.myapplication.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import com.example.cong.myapplication.model.Product;
import com.example.cong.myapplication.presenter.CartPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Cart extends AppCompatActivity implements ICartView, CartAdapter.ICartEvents{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rvProductCart)
    RecyclerView rvProductCart;

    @BindView(R.id.txtCheckOut)
    TextView txtCheckOut;

    CartPresenter cartPresenter;

    CartAdapter cartAdapter;
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
    public void loadViewCart(List<Product> cart, List<String> listKey) {
        cartAdapter = new CartAdapter(this, cart, listKey);
        rvProductCart.setAdapter(cartAdapter);
        rvProductCart.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void loadFailView() {
    }

    @Override
    public void removeItemCart(int position) {
        cartAdapter.removeItem(position);
    }

    @Override
    public void removeItemCart(final String key, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Cart.this)
                .setTitle("Delete a product")
                .setMessage("Do you want to delete your product?")
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cartPresenter.deleteItemCart(key,position);

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void updateQuantity(String key, int quantity) {

    }
}
