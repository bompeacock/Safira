package com.example.cong.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.CustomExpandableListAdapter;
import com.example.cong.myapplication.adapter.TabLayoutAdapter;
import com.example.cong.myapplication.fragment.MissyFragment;
import com.example.cong.myapplication.fragment.SafiraFragment;
import com.example.cong.myapplication.interfaceView.IMainView;
import com.example.cong.myapplication.model.Group;
import com.example.cong.myapplication.model.Type;
import com.example.cong.myapplication.presenter.MainViewPresenter;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

//    @BindView(R.id.drawerlayout)
//    FlowingDrawer mDrawer;

    @BindView(R.id.expandableListView)
    ExpandableListView expandableListView;


    private DrawerLayout mDrawerLayout;

    private FirebaseAuth mAuth;

    private MainViewPresenter mainViewPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mainViewPresenter = new MainViewPresenter(this);

        setViews();


        mAuth = FirebaseAuth.getInstance();

        setEvents();

    }

    private void setViews() {
        // Adding Toolbar to Main screen
        setSupportActionBar(toolbar);
        // Setting ViewPager for each Tabs  //set view Drawer
        mainViewPresenter.loadDataForDrawer();

        // Set Tabs inside Toolbar
        tabLayout.setupWithViewPager(viewPager);
        // Create Navigation drawer and inlfate layout
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        // Adding menu icon to Toolbar
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            VectorDrawableCompat indicator
                    = VectorDrawableCompat.create(getResources(), R.drawable.ic_menu, getTheme());
            indicator.setTint(ResourcesCompat.getColor(getResources(), R.color.white, getTheme()));
            supportActionBar.setHomeAsUpIndicator(indicator);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        // Set behavior of Navigation drawer


        viewPager.setOffscreenPageLimit(tabLayout.getTabCount());






    }

    private void setEvents() {


    }

    private void setupViewPager(ViewPager viewPager,List<Group> groups) {
        TabLayoutAdapter adapter = new TabLayoutAdapter(getSupportFragmentManager());

        adapter.addFragment(new SafiraFragment(this), "COLLECTION");
        for (int i = 1; i< groups.size(); i++){
            adapter.addFragment(new MissyFragment(this, groups.get(i).getId()), groups.get(i).getName());
            viewPager.setAdapter(adapter);
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
                    case R.id.mnCart:
                    startActivity(new Intent(this, Cart.class));
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

    private void signOut() {
        mAuth.signOut();
        Intent intent = new Intent(this, Login.class);
        intent.putExtra("logout", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void setUpViewOfDraw(List<Group> groups, HashMap<Group, List<Type>> types) {
        setupViewPager(viewPager, groups);

        CustomExpandableListAdapter customExpandableListAdapter
                = new CustomExpandableListAdapter(this,groups,types);
        expandableListView.setAdapter(customExpandableListAdapter);
    }
}
