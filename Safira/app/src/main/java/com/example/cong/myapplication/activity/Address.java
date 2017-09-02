package com.example.cong.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.model.CartOrder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Address extends AppCompatActivity {

    @BindView(R.id.txtILStreet)
    TextInputLayout txtILStreet;

    @BindView(R.id.txtILWar)
    TextInputLayout txtILWar;

    @BindView(R.id.txtILDistrict)
    TextInputLayout txtILDistrict;

    @BindView(R.id.txtILCity)
    TextInputLayout txtILCity;

    @BindView(R.id.txtILCountry)
    TextInputLayout txtILCountry;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.btnBack)
    Button btnBack;

    @BindView(R.id.btnNextStep)
    Button btnNextStep;

    @BindView(R.id.txtILPhone)
    TextInputLayout txtILPhone;

    CartOrder cartOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        ButterKnife.bind(this);

        cartOrder = (CartOrder) getIntent().getSerializableExtra("cartOrder");

        setupViews();

        setupFloatingLabelError();

        setUpEvent();
    }

    private void setUpEvent() {
        btnNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cartOrder.getOrderAddress().check()){
                    Intent intent = new Intent(view.getContext(),OrderDetails.class);
                    intent.putExtra("cartOrder", cartOrder);
                    startActivity(intent);

                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setupViews() {
        toolbar.setTitle("Shipping Address");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setupFloatingLabelError() {
        txtILStreet.setError("You have to enter this field");
        txtILWar.setError("You have to enter this field");
        txtILDistrict.setError("You to have enter this field");
        txtILCity.setError("You have to enter this field");
        txtILCountry.setError("You have to enter this field");
        txtILStreet.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {

                txtILStreet.setErrorEnabled(true);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    txtILStreet.setError("You have enter this field");
                    txtILStreet.setErrorEnabled(true);
                } else {
                    cartOrder.getOrderAddress().setStreet(editable.toString());

                    txtILStreet.setErrorEnabled(false);
                }
            }
        });
        txtILWar.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    txtILWar.setError("You have enter this field");
                    txtILWar.setErrorEnabled(true);
                } else {
                    cartOrder.getOrderAddress().setWar(editable.toString());
                    txtILWar.setErrorEnabled(false);
                }
            }
        });
        txtILDistrict.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {


                if (editable.length() == 0) {
                    txtILDistrict.setError("You have enter this field");
                    txtILDistrict.setErrorEnabled(true);
                } else {
                    cartOrder.getOrderAddress().setDistrict(editable.toString());

                    txtILDistrict.setErrorEnabled(false);
                }
            }
        });
        txtILCity.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.length() == 0) {
                    txtILCity.setError("You have enter this field");
                    txtILCity.setErrorEnabled(true);
                } else {
                    cartOrder.getOrderAddress().setCity(editable.toString());

                    txtILCity.setErrorEnabled(false);
                }
            }
        });
        txtILCountry.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.length() == 0) {
                    txtILCountry.setError("You have enter this field");
                    txtILCountry.setErrorEnabled(true);
                } else {
                    cartOrder.getOrderAddress().setCountry(editable.toString());

                    txtILCountry.setErrorEnabled(false);
                }
            }
        });

        txtILPhone.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                try{
                    int a = Integer.parseInt(editable.toString());
                    cartOrder.getOrderAddress().setPhone(String.valueOf(a));

                    txtILPhone.setErrorEnabled(false);
                }
                catch (NumberFormatException ignored){
                    txtILPhone.setError("You have to enter number");
                    txtILPhone.setEnabled(true);
                }
            }
        });
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
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode==KeyEvent.KEYCODE_ENTER)
        {
            // Just ignore the [Enter] key
            return true;
        }
        // Handle all other keys in the default way
        return super.onKeyDown(keyCode, event);
    }
}
