package com.example.im.my_ipanda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.im.my_ipanda.R;
import com.example.im.my_ipanda.base.BaseActivity;
import com.example.im.my_ipanda.presneter.Presenter;
import com.example.im.my_ipanda.presneter.contract.Contract;
import com.example.im.my_ipanda.ui.fragment.ChinaFragment;
import com.example.im.my_ipanda.ui.fragment.CultureFragment;
import com.example.im.my_ipanda.ui.fragment.HomeFragment;
import com.example.im.my_ipanda.ui.fragment.LiveFragment;
import com.example.im.my_ipanda.ui.fragment.ObserveFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by I'M宋国召 on 2018/3/17.
 */
public class HomeActivity extends BaseActivity implements Contract.ViewInf {
    Contract.PresenterInf presenterInf;
    @Bind(R.id.top_ipanda_img)
    ImageView topIpandaImg;
    @Bind(R.id.top_mi_image)
    ImageView topMiImage;
    @Bind(R.id.top_original_image)
    ImageView topOriginalImage;
    @Bind(R.id.top_name)
    TextView topName;
    @Bind(R.id.rb_home)
    RadioButton rbHome;
    @Bind(R.id.rb_observe)
    RadioButton rbObserve;
    @Bind(R.id.rb_culture)
    RadioButton rbCulture;
    @Bind(R.id.rb_live)
    RadioButton rbLive;
    @Bind(R.id.rb_china)
    RadioButton rbChina;
    private FragmentManager manager;

    @Override
    protected void initData() {
        presenterInf = new Presenter(this);
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.Home_Frame, new HomeFragment()).commit();


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void updataUI(String string) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.top_mi_image, R.id.rb_home, R.id.rb_observe, R.id.rb_culture, R.id.rb_live, R.id.rb_china})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.top_mi_image:
                Intent intent = new Intent(HomeActivity.this, Me_CenterActivity.class);
                startActivity(intent);
                break;
            case R.id.rb_china:
                topName.setText("直播中国");
                topOriginalImage.setVisibility(View.GONE);
                topIpandaImg.setVisibility(View.GONE);
                manager.beginTransaction().replace(R.id.Home_Frame, new ChinaFragment()).commit();
                break;

            case R.id.rb_home:
                topOriginalImage.setVisibility(View.VISIBLE);
                topIpandaImg.setVisibility(View.VISIBLE);
                topName.setText("");
                manager.beginTransaction().replace(R.id.Home_Frame, new HomeFragment()).commit();

                break;
            case R.id.rb_culture:
                topName.setText("熊猫文化");
                topOriginalImage.setVisibility(View.GONE);
                topIpandaImg.setVisibility(View.GONE);
                manager.beginTransaction().replace(R.id.Home_Frame, new CultureFragment()).commit();

                break;
            case R.id.rb_live:
                topName.setText("熊猫直播");
                topOriginalImage.setVisibility(View.GONE);
                topIpandaImg.setVisibility(View.GONE);
                manager.beginTransaction().replace(R.id.Home_Frame, new LiveFragment()).commit();

                break;
            case R.id.rb_observe:
                topName.setText("熊猫观察");
                topOriginalImage.setVisibility(View.GONE);
                topIpandaImg.setVisibility(View.GONE);
                manager.beginTransaction().replace(R.id.Home_Frame, new ObserveFragment()).commit();

                break;


        }
    }
}
