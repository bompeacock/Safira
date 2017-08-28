package com.example.cong.myapplication.interfaceView;

import com.example.cong.myapplication.model.MixProduct;

import java.util.List;

/**
 * Created by Cong on 26/08/2017.
 */

public interface IGroupProductView {
    void loadDataView(List<MixProduct> mixProducts);
    void loadDataViewMore();
    void showFailView();
}
