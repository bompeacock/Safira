package com.example.cong.myapplication.interfaceView;

import com.example.cong.myapplication.model.ResultProductsType;

/**
 * Created by Cong on 12/07/2017.
 */

public interface ITypeProductsView {
    void loadDataSuccess(ResultProductsType resultProductsType);
    void loadViewFail();
}
