package com.example.cong.myapplication.interfaceView;

import com.example.cong.myapplication.model.Product;

import java.util.List;

/**
 * Created by Cong on 03/09/2017.
 */

public interface IFavoriteView {
 void  showViewFavorite(List<Product> productList, List<String> listKey);

    void deleteItem(int position);

    void showSizeDialog(List<String> sizes, Product product);
}
