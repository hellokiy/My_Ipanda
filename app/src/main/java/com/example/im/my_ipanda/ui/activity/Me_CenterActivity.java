package com.example.im.my_ipanda.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.im.my_ipanda.R;
import com.example.im.my_ipanda.base.BaseActivity;
import com.example.im.my_ipanda.presneter.contract.Contract;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by I'M宋国召 on 2018/3/17.
 */
public class Me_CenterActivity extends BaseActivity implements Contract.ViewInf {
    @Bind(R.id.Me_retreat)
    ImageView MeRetreat;
    @Bind(R.id.Me_login)
    RelativeLayout MeLogin;
    @Bind(R.id.Me_watch)
    RelativeLayout MeWatch;
    @Bind(R.id.Me_collect)
    RelativeLayout MeCollect;
    @Bind(R.id.Me_setting)
    RelativeLayout MeSetting;

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_me;
    }

    @Override
    public void updataUI(String string) {

    }


    @OnClick({R.id.Me_retreat, R.id.Me_login, R.id.Me_watch, R.id.Me_collect, R.id.Me_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Me_retreat:
                finish();
                break;
            case R.id.Me_login:
                Intent intent = new Intent(Me_CenterActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.Me_watch:
                break;
            case R.id.Me_collect:
                break;
            case R.id.Me_setting:
                break;
        }
    }
}
