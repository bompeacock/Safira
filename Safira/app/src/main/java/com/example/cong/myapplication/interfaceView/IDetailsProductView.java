package com.example.cong.myapplication.interfaceView;

import com.example.cong.myapplication.model.Color;

import java.util.List;

/**
 * Created by Cong on 27/08/2017.
 */

public interface IDetailsProductView {
    void loadViewImagesDetails(List<String> urlList);
    void loadViewInfoProduct();
    void loadViewProductColor(List<Color> colors);
    void loadViewRecommandation();
}
