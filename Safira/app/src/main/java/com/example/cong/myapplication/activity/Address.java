package com.example.cong.myapplication.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;

import com.example.cong.myapplication.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        ButterKnife.bind(this);

        setupViews();

        setupFloatingLabelError();
    }

    private void setupViews() {
        toolbar.setTitle("Shipping Address");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setupFloatingLabelError() {
        txtILStreet.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() > 0 && text.length() <= 4) {
                    txtILStreet.setError("You have enter this field");
                    txtILStreet.setErrorEnabled(true);
                } else {
                    txtILStreet.setErrorEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

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
}
