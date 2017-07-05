package com.example.cong.myapplication.interfaceView;

import android.content.Context;

import com.example.cong.myapplication.model.ResultsCollection;

import java.util.List;

/**
 * Created by Cong on 01/07/2017.
 */

public interface ICollectionView {
    public void loadViewsCollection(List<ResultsCollection> listColleciton);
    public Context getContextView();
    public void showFailView();
}
