package com.example.cong.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.OrderDetailsAdapter;
import com.example.cong.myapplication.interfaceView.IOrderDetailsView;
import com.example.cong.myapplication.model.CartOrder;
import com.example.cong.myapplication.presenter.OrderDetailsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderDetails extends AppCompatActivity implements IOrderDetailsView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.txtTotalPrice)
    TextView txtTotalPrice;

    @BindView(R.id.rvOderDetails)
    RecyclerView rvOderDetails;

    @BindView(R.id.txtAddress)
    TextView txtAddress;

    @BindView(R.id.btnConfirm)
    Button btnConfirm;

    CartOrder cartOrder;

    OrderDetailsPresenter orderDetailsPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        ButterKnife.bind(this);

        cartOrder = (CartOrder) getIntent().getSerializableExtra("cartOrder");

        orderDetailsPresenter = new OrderDetailsPresenter(this);

        setUpViews();

        setUpEvents();
    }

    private void setUpEvents() {
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderDetailsPresenter.submitOrderToBackEndAndFireBase(cartOrder);
            }
        });
    }

    private void setUpViews() {
        //toolbar

        toolbar.setTitle("Order Details");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //total price
        txtTotalPrice.setText("Total Price: " + cartOrder.getTotalPrice());

        //rvOder
        rvOderDetails.setAdapter(new OrderDetailsAdapter(cartOrder.getOrderDetails(),this));
        rvOderDetails.setLayoutManager(new LinearLayoutManager(this));

        //address
        txtAddress.setText(cartOrder.getOrderAddress().toString());




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
    public void endPurchasing() {
        startActivity(new Intent(this,Thank.class));
    }
}
