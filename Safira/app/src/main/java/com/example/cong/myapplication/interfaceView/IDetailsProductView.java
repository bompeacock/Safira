package com.example.cong.myapplication.interfaceView;

import com.example.cong.myapplication.model.CartOrder;
import com.example.cong.myapplication.model.Color;
import com.example.cong.myapplication.model.Product;
import com.example.cong.myapplication.model.ResultProducByGroupAndType;

import java.util.List;

/**
 * Created by Cong on 27/08/2017.
 */

public interface IDetailsProductView {
    void loadViewImagesDetails(List<String> urlList);
    void loadViewInfoProduct(Product product);
    void loadViewProductColor(List<Color> colors);
    void loadViewRecommandation(List<ResultProducByGroupAndType> products);

    void showMessageAddToCart(String message);

    void loadViewChoseSize(List<String> body);

    void processForPurchasing(CartOrder cartOrder);

    void showMessageAddToFavorite(String message);
}
