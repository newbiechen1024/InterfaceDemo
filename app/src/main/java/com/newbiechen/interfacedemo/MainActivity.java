package com.newbiechen.interfacedemo;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mNavigationView;
    private List<Fragment> mFragmentLists;
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
        mTabLayout = getViewById(R.id.tab_layout);
        mViewPager = getViewById(R.id.viewpager);
        mNavigationView = getViewById(R.id.navigation_view);
    }

    private void initWidget(){
        //初始化Widget
        mFragmentLists = new ArrayList<>();
        //设置NavigationMenu的icon的颜色
        mNavigationView.setItemIconTintList(null);
        //设置Toolbar
        setUpToolbar();
        //设置Drawer与Toolbar关联
        setUpToggle();
        //设置TabLayout的按钮
        setUpTabMenu();
        //设置ViewPager
        setUpViewPager();
    }

    private void setUpToolbar(){
        setSupportActionBar(mToolbar);
        //用户头像
        mToolbar.setLogo(R.mipmap.ic_launcher);
        //设置用户名的显示
        mToolbar.setTitle(R.string.app_title);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
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

    private void setUpTabMenu(){
        for(NavMenu menu : NavMenu.values()){
            mTabLayout.addTab(mTabLayout.newTab().setText(menu.getTitle()));
            mFragmentLists.add(menu.getFragment());
        }
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));
    }

    private void setUpViewPager(){
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentLists.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentLists.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                NavMenu [] navMenus = NavMenu.values();
                int titleId = navMenus[position].getTitle();
                String title = getResources().getString(titleId);
                return title;
            }
        });
        //TabLayout联合ViewPager
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private <VT extends View> VT  getViewById(int id){
        return (VT) findViewById(id);
    }

    /**
     * 官方写法
     */
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mToggle.syncState();
    }

    /**
     * 当资源配置改变的时候调用
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}

