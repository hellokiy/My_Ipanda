package com.example.im.my_ipanda.base;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by I'M宋国召 on 2018/3/17.
 */


public abstract class BaseFragment extends Fragment {

    public Activity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract View initView();

    protected abstract void initData();

    public static Drawable byteToDrawable(byte[] byteArray) {
        try {
            String string = new String(byteArray, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ByteArrayInputStream ins = new ByteArrayInputStream(byteArray);
        return Drawable.createFromStream(ins, null);
    }
}