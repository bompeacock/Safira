package com.example.cong.myapplication.interfaceView;

import com.example.cong.myapplication.model.Banner;
import com.example.cong.myapplication.model.ResultProducByGroupAndType;

import java.util.List;

/**
 * Created by Cong on 12/07/2017.
 */

public interface ITypeProductsView {
    void loadListProduct(List<ResultProducByGroupAndType> resultProducByGroupAndTypes);
    void loadBanner(Banner banner);
    void loadViewFail();
}
