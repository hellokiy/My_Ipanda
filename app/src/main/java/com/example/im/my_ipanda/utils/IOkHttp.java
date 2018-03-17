package com.example.im.my_ipanda.utils;

import android.os.Handler;

import java.util.Map;

/**
 * Created by I'M宋国召 on 2018/3/17.
 */
public interface IOkHttp {

    void get(String url, Handler handler);

    void post(String url, Map<String, String> map, Map<String, String> header, Handler handler);


}
