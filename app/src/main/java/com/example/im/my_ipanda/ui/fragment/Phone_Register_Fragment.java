package com.example.im.my_ipanda.ui.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.im.my_ipanda.R;
import com.example.im.my_ipanda.base.BaseFragment;
import com.example.im.my_ipanda.presneter.Presenter;
import com.example.im.my_ipanda.presneter.contract.Contract;
import com.example.im.my_ipanda.utils.OkHttpUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by I'M宋国召 on 2018/3/13.
 */
public class Phone_Register_Fragment extends BaseFragment implements Contract.ViewInf, View.OnClickListener {
    Contract.PresenterInf presenterInf;
    private ImageView captcha_img;
    public String JSESSIONID = null;
    private EditText username;
    private EditText phone_captcha;
    private EditText password;
    private EditText image_captcha;

    @Override
    protected View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_phone_fragment, null);
        username = view.findViewById(R.id.Register_username);
        phone_captcha = view.findViewById(R.id.Register_mobile_Captcha);
        password = view.findViewById(R.id.Register_passwird);
        image_captcha = view.findViewById(R.id.Register_image_Captcha);
        captcha_img = view.findViewById(R.id.getImage_Captcha);
        captcha_img.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {
        presenterInf = new Presenter(this);
    }

    @Override
    public void updataUI(String string) {
    }

    public void initImageCaptcha() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    CookieManager manager = new CookieManager();
                    CookieHandler.setDefault(manager);
                    URL url = new URL("http://reg.cntv.cn/simple/verificationCode.action");
                    Log.e("Phone_Register_Fragment", "44444444");
                    try {
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.connect();
                        connection.getResponseCode();
                        CookieStore cookieStore = manager.getCookieStore();
                        List<HttpCookie> cookies = cookieStore.getCookies();
                        for (HttpCookie cookie : cookies) {
                            if ("JSESSIONID".equals(cookie.getName())) {
                                JSESSIONID = cookie.getValue();
                                break;
                            }

                            Log.e("Phone_Register_Fragment", "cookie:" + cookie);
                        }
                        InputStream is = connection.getInputStream();
                        final Bitmap bitmap = BitmapFactory.decodeStream(is);
                        is.close();
                        connection.disconnect();
                        mActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                captcha_img.setImageBitmap(bitmap);
                                Log.e("Phone_Register_Fragment", "5555555555555555");
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.getImage_Captcha:
                initImageCaptcha();
                Log.e("Phone_Register_Fragment", "666666666666666");
                break;
        }
    }

    private void initOkHttp_post() {
        String name = username.getText().toString().trim();
        String imgcaptcha = image_captcha.getText().toString().trim();
        String url = "http://reg.cntv.cn/regist/getVerifiCode.action";
        String from = "http://cbox_mobile.regclientuser.cntv.cn";
        Map<String, String> headerMap = new HashMap<String, String>();
        try {
            headerMap.put("Referer", URLEncoder.encode(from, "UTF-8"));
            headerMap.put("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"));
            headerMap.put("Cookie", "JSESSIONID=" + JSESSIONID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map<String, String> params = new HashMap<String, String>();
        params.put("method", "getRequestVerifiCodeM");
        params.put("mobile", name);
        params.put("verfiCodeType", "1");
        params.put("verificationCode", imgcaptcha);
        OkHttpUtils.getInstance().post(url, params, headerMap, new Handler());

    }
}
