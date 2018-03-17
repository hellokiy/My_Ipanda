package com.example.im.my_ipanda.utils;

import android.os.Handler;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by I'M宋国召 on 2018/3/17.
 */
public class OkHttpUtils implements IOkHttp {

    private OkHttpClient okHttpClient;

    private static OkHttpUtils okHttpUtils;

    public static OkHttpUtils getInstance() {
        if (okHttpUtils == null) {
            synchronized (OkHttpUtils.class) {
                if (okHttpUtils == null) {
                    okHttpUtils = new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }

    private OkHttpUtils() {
        okHttpClient = new OkHttpClient.Builder().build();
    }


    @Override
    public void get(String url, final Handler handler) {

        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handler.obtainMessage(0, response.body().string()).sendToTarget();
            }
        });


    }

    @Override
    public void post(String url, Map<String, String> map, Map<String, String> header, Handler handler) {

    }
}
