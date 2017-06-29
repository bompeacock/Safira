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
import android.widget.Toast;

import com.example.cong.myapplication.R;
import com.example.cong.myapplication.adapter.TabLayoutAdapter;
import com.example.cong.myapplication.fragment.MenFragment;
import com.example.cong.myapplication.fragment.MissyFragment;
import com.example.cong.myapplication.fragment.SafiraFragment;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class MainActivity extends AppCompatActivity {

//    @BindView(R.id.toolbar)
//    Toolbar toolbar;
//
//    @BindView(R.id.tabs)
//    TabLayout tabLayout;
//
//    @BindView(R.id.viewpager)
//    ViewPager viewPager;

//    @BindView(R.id.drawerlayout)
//    FlowingDrawer mDrawer;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Adding Toolbar to Main screen
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
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
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    // This method will trigger on item Click of navigation menu
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Set item in checked state
                        menuItem.setChecked(true);

                        // TODO: handle navigation

                        // Closing drawer on item click
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });

        Intent intent = getIntent();
        GoogleSignInAccount mGoogleSignInAccount = (GoogleSignInAccount) intent.getSerializableExtra("signInAccount");
        if(mGoogleSignInAccount!=null){
            Toast.makeText(this,mGoogleSignInAccount.getIdToken(),Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this,"FAiD",Toast.LENGTH_LONG).show();
    }

    private void setupViewPager(ViewPager viewPager) {
        TabLayoutAdapter adapter = new TabLayoutAdapter(getSupportFragmentManager());
        adapter.addFragment(new SafiraFragment(this), "SAFIRA");
        adapter.addFragment(new MenFragment(this), "MISSY");
        adapter.addFragment(new MissyFragment(this), "PLUS");
        adapter.addFragment(new MenFragment(this), "MEN");
        adapter.addFragment(new MissyFragment(this), "ACCESSORIES");
        viewPager.setAdapter(adapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


}
