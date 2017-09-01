package com.example.cong.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cong on 31/08/2017.
 */

public class ResultProducByGroupAndType {
    @SerializedName("singleImage")
    private Product product;
    @SerializedName("colors")
    private List<Object[]> colors;

    public ResultProducByGroupAndType(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public List<Color> getColors() {
        List<Color> l= new ArrayList<>();
        if(colors!=null)for (Object[] object :colors){
            double id  = (double) object[0];
            String path  = (String) object[1];
            l.add(new Color((int) id,path));
        }

        return l;
    }
}
