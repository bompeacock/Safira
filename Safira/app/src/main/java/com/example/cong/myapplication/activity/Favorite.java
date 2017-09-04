package com.example.cong.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.FavoriteAdapter;
import com.example.cong.myapplication.interfaceView.IFavoriteView;
import com.example.cong.myapplication.model.Product;
import com.example.cong.myapplication.presenter.FavoritePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Favorite extends AppCompatActivity implements IFavoriteView, FavoriteAdapter.IActionFavorite {

    @BindView(R.id.rvFavorite)
    RecyclerView rvFavorite;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    FavoritePresenter favoritePresenter;


    MaterialDialog.Builder progressBuilder;

    MaterialDialog progress;

    AlertDialog alert;

    AlertDialog.Builder builder;

    FavoriteAdapter favoriteAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        ButterKnife.bind(this);

        favoritePresenter = new FavoritePresenter(this);

        setUpViews();

        setUpEvents();

    }

    private void setUpEvents() {

    }

    private void setUpViews() {
        //toolbar
        toolbar.setTitle("Favorite");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBuilder = new MaterialDialog.Builder(this)
                .content("Please wait ...")
                .progress(true, 0);
        progress = progressBuilder.build();
        progress.show();

        favoritePresenter.loadDataFavorive();


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case android.R.id.home:
                finish();
                break;
            case R.id.mnFavorite:
                Intent intent = new Intent(this, Favorite.class);
                startActivity(intent);
                break;
            case R.id.mnSearch:
                startActivity(new Intent(this,Search.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showViewFavorite(List<Product> productList, List<String> listKey) {
        favoriteAdapter = new FavoriteAdapter(this,productList,listKey);
        rvFavorite.setAdapter(favoriteAdapter);
        rvFavorite.setLayoutManager(new LinearLayoutManager(this));
        progress.dismiss();
    }

    @Override
    public void deleteItem(int position) {
        favoriteAdapter.removeItem(position);
    }

    @Override
    public void showSizeDialog(final List<String> sizes, final Product product) {
        new MaterialDialog.Builder(this)
                .title("Pick Size")
                .items(sizes)
                .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        /**
                         * If you use alwaysCallSingleChoiceCallback(), which is discussed below,
                         * returning false here won't allow the newly selected radio button to actually be selected.
                         **/
                        if(which!=-1){
                            Product p = product;

                            p.setSize(sizes.get(which));
                            favoritePresenter.addProductToCart(p);
                            showMessageAddToBag();

                        }
                        return true;
                    }
                })
                .positiveText("Choose")
                .show();
    }

    private void showMessageAddToBag() {

        Snackbar.make(this.getCurrentFocus(),"Add to cart successfully",Snackbar.LENGTH_LONG)
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
    public void removeItemFavorite(String key, int position) {
        favoritePresenter.removeItemFavorite(key,position);
    }

    @Override
    public void addToCart(Product product) {
       favoritePresenter.loadSize(product);

    }
}
