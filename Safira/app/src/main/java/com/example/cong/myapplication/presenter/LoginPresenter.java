package com.example.cong.myapplication.presenter;

import com.example.cong.myapplication.interfaceView.ILoginView;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;

/**
 * Created by Cong on 29/06/2017.
 */

public class LoginPresenter {
    private ILoginView mlLoginView;



    public LoginPresenter(ILoginView mlLoginView) {
        this.mlLoginView = mlLoginView;
    }

    public boolean loginWithGoogle(GoogleSignInResult result){
        if(result.isSuccess()){
            mlLoginView.loginSuccessfuly(result.getSignInAccount());
            return  true;

        }else {
            mlLoginView.loginFaild();
            return false;
        }
    }

}
