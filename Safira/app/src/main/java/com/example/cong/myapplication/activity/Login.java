package com.example.cong.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.interfaceView.ILoginView;
import com.example.cong.myapplication.presenter.LoginPresenter;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity implements ILoginView{

    private final int RC_SIGN_IN = 14;

    @BindView(R.id.btnSign_in)
    SignInButton btnSign_in;

    private LoginPresenter mLoginPresenter;
    private GoogleApiClient mGoogleApiClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        setPresenterAndRelated();

        setEvents();

    }

    private void setEvents() {
        btnSign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(signInIntent, RC_SIGN_IN);

            }
        });

    }

    private void setPresenterAndRelated() {
        ButterKnife.bind(this);

        mLoginPresenter = new LoginPresenter(this);

        btnSign_in.setSize(SignInButton.SIZE_STANDARD);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            mLoginPresenter.loginWithGoogle(result);
        }

    }

    @Override
    public void loginSuccessfuly(GoogleSignInAccount signInAccount) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("signInAccount",signInAccount);
        startActivity(intent);
    }

    @Override
    public void loginFaild() {
        Toast.makeText(this,"login faild",Toast.LENGTH_LONG).show();
    }
}
