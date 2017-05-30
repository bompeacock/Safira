package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cong.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cong on 30/05/2017.
 */

public class SafiraAdapter extends RecyclerView.Adapter {
    Context context;
    List<String> list;

    public SafiraAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public SafiraAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_safira,parent,false);

        return new SafiraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class SafiraViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rvSafiraItem)
        RecyclerView rvSafiraItem;

        public SafiraViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            InsideSafiraAdapter adapter = new InsideSafiraAdapter(context);
            rvSafiraItem.setAdapter(adapter);
        }
    }
}
