package com.example.cong.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.activity.DetailsProduct;
import com.example.cong.myapplication.model.ResultPickProductAndRec;
import com.example.cong.myapplication.utils.Constant;
import com.example.cong.myapplication.utils.PicassoUtils;

import java.util.List;


/**
 * Created by CongNV4 on 5/21/2017.
 */
public class PickProductAdapter extends PagerAdapter {
    private List<ResultPickProductAndRec> recList;

    private Context context;
    private LayoutInflater mLayoutInflater;


    public PickProductAdapter(final Context context , List<ResultPickProductAndRec> recList ) {
        mLayoutInflater = LayoutInflater.from(context);
        this.recList = recList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return recList.size();
    }

    @Override
    public int getItemPosition(final Object object) {
        return POSITION_NONE;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final View view = mLayoutInflater.inflate(R.layout.item, container, false);

        final ResultPickProductAndRec resultPickProductAndRec = recList.get(position);

        final TextView txt = (TextView) view.findViewById(R.id.txt_item);
        txt.setText(resultPickProductAndRec.getProductName());

        final ImageView img = (ImageView) view.findViewById(R.id.img_item);

        PicassoUtils.loadImage(context,Constant.IMAGE_URL_SINGLE_IMAGE + resultPickProductAndRec.getPath(),img);

        container.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(context, DetailsProduct.class);
                intent.putExtra("code", resultPickProductAndRec.getCode());
                context.startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public boolean isViewFromObject(final View view, final Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        container.removeView((View) object);
    }

    public void addNewData(List<ResultPickProductAndRec> resultPickProductAndRecs) {
        recList.clear();
        recList.addAll(resultPickProductAndRecs);
        notifyDataSetChanged();


    }
}


