package com.newbiechen.interfacedemo;

import android.support.v4.app.Fragment;

import com.newbiechen.interfacedemo.Fragment.AreaFragment;
import com.newbiechen.interfacedemo.Fragment.AttentionFragment;
import com.newbiechen.interfacedemo.Fragment.DiscoverFragment;
import com.newbiechen.interfacedemo.Fragment.RecommendFragment;
import com.newbiechen.interfacedemo.Fragment.ShowLineFragment;

/**
 * Created by PC on 2016/9/14.
 * Fragment的枚举类型。
 * 方便使用，与修改
 */
public enum  NavMenu {
    SHOWLINE(1,R.string.line_show,new ShowLineFragment()),
    RECOMMEND(2,R.string.recommend,new RecommendFragment()),
    ANIMATION(3,R.string.animation,new RecommendFragment()),
    AREA(4,R.string.area,new AreaFragment()),
    ATTENTION(5,R.string.attention,new AttentionFragment()),
    DISCOVER(6,R.string.discover,new DiscoverFragment());
    private int mId;
    private int mTitleId;
    private Fragment mFragment;
    private NavMenu(int id, int titleId,Fragment fragment){
        mId = id;
        mTitleId = titleId;
        mFragment = fragment;
    }

    public int getId(){
        return mId;
    }

    public int getTitle(){
        return mTitleId;
    }

    public Fragment getFragment(){
        return mFragment;
    }
}
