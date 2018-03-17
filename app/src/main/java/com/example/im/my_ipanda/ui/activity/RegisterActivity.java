package com.example.im.my_ipanda.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.im.my_ipanda.R;
import com.example.im.my_ipanda.base.BaseActivity;
import com.example.im.my_ipanda.presneter.Presenter;
import com.example.im.my_ipanda.presneter.contract.Contract;
import com.example.im.my_ipanda.ui.fragment.Email_Register_Fragment;
import com.example.im.my_ipanda.ui.fragment.Phone_Register_Fragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by I'M宋国召 on 2018/3/17.
 */
public class RegisterActivity extends BaseActivity implements Contract.ViewInf {

    Contract.PresenterInf presenterInf;
    private FragmentManager manager;
    @Bind(R.id.Register_retreat_img)
    ImageView RegisterRetreatImg;
    @Bind(R.id.Register_phone)
    RadioButton RegisterPhone;
    @Bind(R.id.Register_email)
    RadioButton RegisterEmail;

    @Override
    protected void initData() {
        presenterInf = new Presenter(this);
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        FragmentTransaction transaction1 = transaction.add(R.id.register_Frame, new Phone_Register_Fragment());
        transaction1.commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void updataUI(String string) {

    }

    @OnClick({R.id.Register_retreat_img, R.id.Register_phone, R.id.Register_email})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Register_phone:
                FragmentTransaction transaction = manager.beginTransaction();
                FragmentTransaction transaction3 = transaction.replace(R.id.register_Frame, new Phone_Register_Fragment());
                transaction3.commit();
                break;
            case R.id.Register_email:
                FragmentTransaction transaction1 = manager.beginTransaction();
                FragmentTransaction transaction2 = transaction1.replace(R.id.register_Frame, new Email_Register_Fragment());
                transaction2.commit();
                break;
            case R.id.Register_retreat_img:
                finish();
                break;

        }
    }
}
