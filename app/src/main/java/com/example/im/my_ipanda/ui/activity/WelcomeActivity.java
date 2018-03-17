package com.example.im.my_ipanda.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.im.my_ipanda.R;
import com.example.im.my_ipanda.base.BaseActivity;
import com.example.im.my_ipanda.presneter.Presenter;
import com.example.im.my_ipanda.presneter.contract.Contract;
import com.example.im.my_ipanda.ui.adapter.WelcomePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by I'M宋国召 on 2018/3/17.
 */
public class WelcomeActivity extends BaseActivity implements Contract.ViewInf {

    Contract.PresenterInf presenterInf;
    @Bind(R.id.weicome_page_Vp)
    ViewPager weicome_page_Vp;
    private List<View> list = new ArrayList<>();
    private WelcomePagerAdapter welcomePagerAdapter;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = WelcomeActivity.this.getSharedPreferences("user", MODE_PRIVATE);
        editor = preferences.edit();
        boolean isTrue = preferences.getBoolean("isTrue", false);
        if (isTrue) {
            Intent intent = new Intent(WelcomeActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    protected void initData() {
        presenterInf = new Presenter(this);
        View view = getLayoutInflater().inflate(R.layout.welcome_viewthree, null);
        ImageView image = view.findViewById(R.id.Experience_Btn);
        list.add(getLayoutInflater().inflate(R.layout.welcome_viewone, null));
        list.add(getLayoutInflater().inflate(R.layout.welcome_viewtwo, null));
        list.add(view);
        welcomePagerAdapter = new WelcomePagerAdapter(list);
        weicome_page_Vp.setAdapter(welcomePagerAdapter);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putBoolean("isTrue", true);
                editor.commit();
                startActivity(new Intent(WelcomeActivity.this, HomeActivity.class));
                finish();
            }
        });


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void updataUI(String string) {

    }


}
