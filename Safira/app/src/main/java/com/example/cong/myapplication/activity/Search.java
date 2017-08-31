package com.example.cong.myapplication.activity;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.SearchAdapter;
import com.example.cong.myapplication.interfaceView.ISearchView;
import com.example.cong.myapplication.model.ResultProducByGroupAndType;
import com.example.cong.myapplication.presenter.SearchPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Search extends AppCompatActivity implements ISearchView{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rvProductSearch)
    RecyclerView rvProductSearch;

    SearchAdapter searchAdapter;
    List<ResultProducByGroupAndType> resultProducByGroupAndTypes;

    SearchPresenter searchPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ButterKnife.bind(this);

        searchPresenter = new SearchPresenter(this);

        setUpViews();
    }

    private void setUpViews() {
        setSupportActionBar(toolbar);

        toolbar.setTitle("Search");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Search");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        resultProducByGroupAndTypes = new ArrayList<>();
        searchAdapter = new SearchAdapter(this, resultProducByGroupAndTypes);
        rvProductSearch.setAdapter(searchAdapter);
        rvProductSearch.setLayoutManager(new LinearLayoutManager(this));

    }
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(!"".equals(newText)){
                    loadResults(newText);

                }
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void loadResults(String newText) {

        searchPresenter.search(newText);
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
    public void loadProductVew(List<ResultProducByGroupAndType> resultProducByGroupAndTypes) {
        searchAdapter.addNewResult(resultProducByGroupAndTypes);
        searchAdapter.notifyDataSetChanged();

    }
}
