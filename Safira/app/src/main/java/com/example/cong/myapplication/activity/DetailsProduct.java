package com.example.cong.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.ColorAdapter;
import com.example.cong.myapplication.adapter.ColorMiniAdapter;
import com.example.cong.myapplication.adapter.InsideSafiraAdapter;
import com.example.cong.myapplication.adapter.PickDetailsImageProductAdapter;
import com.example.cong.myapplication.interfaceView.IDetailsProductView;
import com.example.cong.myapplication.model.CartOrder;
import com.example.cong.myapplication.model.Color;
import com.example.cong.myapplication.model.Product;
import com.example.cong.myapplication.model.ResultProducByGroupAndType;
import com.example.cong.myapplication.presenter.DetailsProductPresenter;
import com.example.cong.myapplication.utils.PicassoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsProduct extends AppCompatActivity implements PickDetailsImageProductAdapter.IClicklistener, IDetailsProductView,ColorAdapter.IImageProduct,ColorMiniAdapter.IMiniColor {

    @BindView(R.id.img_details_product)
    ImageView mImageProduct;

    @BindView(R.id.rvImageProduct)
    RecyclerView rvImageProduct;

    @BindView(R.id.rvColor)
    RecyclerView rvImgColor;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rvRecommend)
    RecyclerView rvRecommend;

    @BindView(R.id.btnAddToCart)
    Button btnAddToCart;

    @BindView(R.id.btnBuyNow)
    Button btnBuyNow;

    @BindView(R.id.btnLike)
    ImageView btnLike;

    @BindView(R.id.txtProductName)
    TextView txtProductName;

    @BindView(R.id.txtProductPrice)
    TextView txtProductPrice;

    private String code;

    private DetailsProductPresenter detailsProductPresenter;

    Product product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_product);
        ButterKnife.bind(this);


        code = getIntent().getStringExtra("code");

        detailsProductPresenter = new DetailsProductPresenter(this);

        setupView();

        setUpEvents();


    }

    private void setUpEvents() {
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(product.getSize()!=null&&!"".equals(product.getSize())){
                      detailsProductPresenter.addToCart(product);
                }else detailsProductPresenter.loadDataSize(product.getCode());

            }
        });
        btnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(product.getSize()!=null&&!"".equals(product.getSize())){
                    detailsProductPresenter.loadDataForPurchasing(product);
                }else detailsProductPresenter.loadDataSize(product.getCode());
            }
        });
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Review.class);
                intent.putExtra("imageCode", product.getCode());
                startActivity(intent);
//                Snackbar.make(view,"Add to Favorite successfully",Snackbar.LENGTH_LONG)
//                        .show();

            }
        });
    }

    private void setupView() {
        //set toolbar
        toolbar.setTitle("Details Product");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager  = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        rvRecommend.setLayoutManager(staggeredGridLayoutManager);
        //fill data layout image product
        detailsProductPresenter.loadDataImagesProduct(code);
        detailsProductPresenter.loadDataImageColor(code);
        detailsProductPresenter.loadDataRecommandation(code);
    }

    @Override
    public void updateImage(String url) {
        PicassoUtils.loadImage(this, url, mImageProduct);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case android.R.id.home:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loadViewImagesDetails(List<String> urlProducts) {
        PickDetailsImageProductAdapter mPickDetailsImageProductAdapter = new PickDetailsImageProductAdapter(this,urlProducts);
        rvImageProduct.setAdapter(mPickDetailsImageProductAdapter);

    }

    @Override
    public void loadViewInfoProduct(Product product2) {
        product = product2;
        txtProductName.setText(product.getName());
        txtProductPrice.setText("$"+product.getPrice());

    }

    @Override
    public void loadViewProductColor(List<Color> colors) {
        //fill data image color

        ColorAdapter colorAdapter = new ColorAdapter(this,colors);
        rvImgColor.setAdapter(colorAdapter);

    }

    @Override
    public void loadViewRecommandation(List<ResultProducByGroupAndType> products) {
        InsideSafiraAdapter adapter  =  new InsideSafiraAdapter(this, products);
        rvRecommend.setAdapter(adapter);
    }

    @Override
    public void showMessageAddToCart(String message) {
        Snackbar.make(this.getCurrentFocus(),message,Snackbar.LENGTH_LONG)
                .setAction("GO TO BAG", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(view.getContext(),Cart.class));
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.button_goto_bag))
                .setDuration(3000)
                .show();
    }

    @Override
    public void loadViewChoseSize(final List<String> body) {
        new MaterialDialog.Builder(this)
                .title("Pick Size")
                .items(body)
                .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        /**
                         * If you use alwaysCallSingleChoiceCallback(), which is discussed below,
                         * returning false here won't allow the newly selected radio button to actually be selected.
                         **/
                        if(which!=-1){
                            product.setSize(body.get(which));
                        }
                        return true;
                    }
                })
                .positiveText("Close")
                .show();
    }

    @Override
    public void processForPurchasing(CartOrder cartOrder) {
        Intent intent = new Intent(this, Address.class);
        intent.putExtra("cartOrder",cartOrder);
        startActivity(intent);
    }

    @Override
    public void setImageProduct(int productId) {
        detailsProductPresenter.loadDataCode(productId);

    }

    @Override
    public void updateImageProduct(int id, int position) {
        // DO NOTHING
    }
}
