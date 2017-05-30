package com.example.cong.myapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.MenAdapter;
import com.example.cong.myapplication.model.Product;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cong on 30/05/2017.
 */

public class MenFragment extends Fragment {
    @BindView(R.id.rvMissy)
    RecyclerView rvMissy;

    Context context;

    GridLayoutManager manager;

    public MenFragment(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_missy,container,false);
        ButterKnife.bind(this,view);

        List<Product> listProduct = new ArrayList<>();
        listProduct.add(new Product("product 1"));
        listProduct.add(new Product("product 2"));
        listProduct.add(new Product("product 3"));
        listProduct.add(new Product("product 4"));
        listProduct.add(new Product("product 5"));
        listProduct.add(new Product("product 6"));
        listProduct.add(new Product("product 7"));
        listProduct.add(new Product("product 8"));
        MenAdapter menAdapter = new MenAdapter(listProduct,this.getContext());
        rvMissy.setAdapter(menAdapter);
        rvMissy.setHasFixedSize(true);
        manager = new GridLayoutManager(context,2);
//        manager.getSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return 0;
//            }
//        });

        rvMissy.setLayoutManager(manager);

        return view;

    }
}
