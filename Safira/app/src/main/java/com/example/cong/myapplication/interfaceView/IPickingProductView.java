package com.example.cong.myapplication.interfaceView;

import com.example.cong.myapplication.model.ResultPickProductAndRec;

import java.util.List;

/**
 * Created by Cong on 26/08/2017.
 */

public interface IPickingProductView {
    void loadViewProduct(List<ResultPickProductAndRec> resultPickProductAndRecs);

    void loadFailView();


}
