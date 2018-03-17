package com.example.im.my_ipanda.presneter.contract;

import com.example.im.my_ipanda.base.BasePresenter;
import com.example.im.my_ipanda.base.BaseView;

/**
 * Created by I'M宋国召 on 2018/3/17.
 */

public interface Contract {

    public interface PresenterInf extends BasePresenter {
        public void getData(String[] strings);
    }

    public interface ViewInf extends BaseView {
        public void updataUI(String string);
    }

}