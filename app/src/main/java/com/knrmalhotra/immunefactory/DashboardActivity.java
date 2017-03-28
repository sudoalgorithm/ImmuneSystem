package com.knrmalhotra.immunefactory;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;

public class DashboardActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private FrameLayout mFrameLayout;
    private ListView mListView;
    private String[] menuList = {""};
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private ActionBar mActionBar;
    private ImageButton mImageButton1, mImageButton2, mImageButton3, mImageButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mActionBar = getSupportActionBar();
        if (getSupportActionBar() != null){
            mActionBar.setDisplayShowHomeEnabled(true);
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setDisplayShowTitleEnabled(false);
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        //mFrameLayout = (FrameLayout) findViewById(R.id.content_frame);
        mListView = (ListView) findViewById(R.id.list_view);

        mListView.setAdapter(new ArrayAdapter<String>(this, R.layout.row_view,menuList));

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.drawer_open, R.string.drawer_closed){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setHomeButtonEnabled(true);

        mImageButton1 = (ImageButton) findViewById(R.id.vaccine);
        mImageButton2 = (ImageButton) findViewById(R.id.schedule);
        mImageButton3 = (ImageButton) findViewById(R.id.group);
        mImageButton4 = (ImageButton) findViewById(R.id.travel);


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mActionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
