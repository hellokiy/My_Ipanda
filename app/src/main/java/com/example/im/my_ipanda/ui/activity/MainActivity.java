package com.example.im.my_ipanda.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;

import com.example.im.my_ipanda.R;
import com.example.im.my_ipanda.base.BaseActivity;
import com.example.im.my_ipanda.presneter.Presenter;
import com.example.im.my_ipanda.presneter.contract.Contract;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements Contract.ViewInf {
    Contract.PresenterInf presenterInf;
    @Bind(R.id.begin_Image)
    ImageView beginImage;
    private Handler handler = new Handler();

    @Override
    protected void initData() {
        presenterInf = new Presenter(this);
        handler.postDelayed(run, 3000);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
    Runnable run = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    public void updataUI(String string) {


    }



}
