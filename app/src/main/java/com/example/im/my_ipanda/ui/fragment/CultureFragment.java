package com.example.im.my_ipanda.ui.fragment;

import android.view.View;

import com.example.im.my_ipanda.R;
import com.example.im.my_ipanda.base.BaseFragment;
import com.example.im.my_ipanda.presneter.contract.Contract;


/**
 * Created by I'M宋国召 on 2018/3/13.
 */
public class CultureFragment extends BaseFragment implements Contract.ViewInf {
    @Override
    protected View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_culture, null);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void updataUI(String string) {

    }
}
