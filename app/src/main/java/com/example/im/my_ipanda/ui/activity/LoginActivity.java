package com.example.im.my_ipanda.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.im.my_ipanda.R;
import com.example.im.my_ipanda.base.BaseActivity;
import com.example.im.my_ipanda.presneter.Presenter;
import com.example.im.my_ipanda.presneter.contract.Contract;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by I'M宋国召 on 2018/3/17.
 */
public class LoginActivity extends BaseActivity implements Contract.ViewInf {
    Contract.PresenterInf presenterInf;
    @Bind(R.id.Login_retreat_img)
    ImageView LoginRetreatImg;
    @Bind(R.id.Login_register)
    TextView LoginRegister;

    @Override
    protected void initData() {
        presenterInf = new Presenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void updataUI(String string) {

    }

    @OnClick({R.id.Login_retreat_img, R.id.Login_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Login_retreat_img:
                finish();
                break;
            case R.id.Login_register:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
