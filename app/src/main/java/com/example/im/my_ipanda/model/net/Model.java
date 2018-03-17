package com.example.im.my_ipanda.model.net;

import android.os.Handler;

import com.example.im.my_ipanda.model.ModelInf;
import com.example.im.my_ipanda.utils.OkHttpUtils;

/**
 * Created by I'M宋国召 on 2018/3/17.
 */


public class Model implements ModelInf {
    @Override
    public void getData(String[] strings, Handler handler) {
        OkHttpUtils.getInstance().get(strings[0], handler);
    }
}
