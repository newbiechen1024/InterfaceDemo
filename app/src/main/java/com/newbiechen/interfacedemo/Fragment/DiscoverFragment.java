package com.newbiechen.interfacedemo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.newbiechen.interfacedemo.R;

/**
 * Created by PC on 2016/9/14.
 */
public class DiscoverFragment extends Fragment {
    private TextView mTvContent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all,container,false);
        mTvContent = (TextView) view.findViewById(R.id.all_tv_content);
        mTvContent.setText(R.string.discover);
        return view;
    }
}
