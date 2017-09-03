package com.example.cong.myapplication.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.CartAdapter;
import com.example.cong.myapplication.interfaceView.ICartView;
import com.example.cong.myapplication.model.CartOrder;
import com.example.cong.myapplication.model.OrderAddress;
import com.example.cong.myapplication.model.Product;
import com.example.cong.myapplication.presenter.CartPresenter;
import com.example.cong.myapplication.utils.OrderConstants;

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

    @BindView(R.id.txtTotalPrice)
    TextView txtTotalPrice;

    CartPresenter cartPresenter;

    CartAdapter cartAdapter;

    CartOrder cartOrder;

    MaterialDialog.Builder progressBuilder;

    MaterialDialog progress;

    AlertDialog alert;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ButterKnife.bind(this);

        cartPresenter = new CartPresenter(this);

        cartOrder = new CartOrder();
        //initialize Address Object
        cartOrder.setOrderAddress(new OrderAddress());

        setupView();

        setUpEvents();
    }

    private void setUpEvents() {
        txtCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cartOrder.getOrderDetails().size()>0){
                    Intent intent = new Intent(view.getContext(), Address.class);
                    intent.putExtra("cartOrder",cartOrder);
                    startActivity(intent);
                }else Snackbar.make(view,"No product in cart",Snackbar.LENGTH_SHORT).show();


            }
        });

    }

    private void setupView() {


        toolbar.setTitle("Cart");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBuilder = new MaterialDialog.Builder(this)
                .content("Please wait ...")
                .progress(true, 0);


        progress = progressBuilder.build();
        progress.show();
        cartPresenter.loadDataCart();



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case android.R.id.home:
                finish();
                break;
            case R.id.mnFavorite:
                Intent intent = new Intent(this, Favorite.class);
                startActivity(intent);
                break;
            case R.id.mnSearch:
                startActivity(new Intent(this,Search.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_for_cart,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void loadViewCart(List<Product> cart, List<String> listKey) {
        cartAdapter = new CartAdapter(this, cart, listKey);
        rvProductCart.setAdapter(cartAdapter);
        rvProductCart.setLayoutManager(new LinearLayoutManager(this));

        cartOrder.setOrderDetails(cart);
        txtTotalPrice.setText(cartOrder.getTotalPrice());

        progress.dismiss();
    }

    @Override
    public void loadFailView() {
    }

    @Override
    public void removeItemCart(int position) {
        cartAdapter.removeItem(position);
    }

    @Override
    public void reloadView(int quantity, int position) {
        cartOrder.setType(OrderConstants.ORDER_FROM_CART);
        cartOrder.getOrderDetails().get(position).setQuantity(quantity);
        txtTotalPrice.setText(cartOrder.getTotalPrice());
    }


    @Override
    public void removeItemCart(final String key, final int position) {
        builder = new AlertDialog.Builder(Cart.this)
                .setTitle("Delete a product")
                .setMessage("Do you want to delete your product?")
                .setCancelable(true)
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cartPresenter.deleteItemCart(key,position);

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        alert = builder.create();
        alert.show();
    }

    @Override
    public void updateQuantity(String key, int quantity, int position) {
        cartPresenter.updateQuantity(key,quantity, position);

    }
}
