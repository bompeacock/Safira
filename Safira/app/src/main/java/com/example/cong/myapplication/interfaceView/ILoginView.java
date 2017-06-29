package com.example.cong.myapplication.interfaceView;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/**
 * Created by Cong on 29/06/2017.
 */

public interface ILoginView {
    void loginSuccessfuly(GoogleSignInAccount signInAccount);
    void loginFaild();
}
