package com.newbiechen.interfacedemo;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNvLeftDrawer;
    private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initWidget();
    }

    private void initView(){
        mToolbar = getViewById(R.id.toolbar);
        mDrawerLayout = getViewById(R.id.drawer_layout);
        mNvLeftDrawer = getViewById(R.id.navigation_view);
    }

    private void initWidget(){
        //设置Toolbar
        setUpToolbar();
        //设置Drawer与Toolbar关联
        setUpToggle();
    }

    private void setUpToolbar(){
        setSupportActionBar(mToolbar);
        mToolbar.setTitle(R.string.app_title);
        //是否显示Nav的icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setUpToggle(){
        //设置与Toolbar关联的DrawerLayout监听器
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,
                mToolbar,R.string.drawer_open,R.string.drawer_close);
        //关联
        mDrawerLayout.addDrawerListener(mToggle);
        //设置指示器
        mToggle.syncState();
    }


    private <VT> VT  getViewById(int id){
        return (VT) findViewById(id);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mToggle.onConfigurationChanged(newConfig);
    }
}

