package com.example.im.my_ipanda.presneter;

import android.os.Handler;
import android.os.Message;

import com.example.im.my_ipanda.model.ModelInf;
import com.example.im.my_ipanda.model.net.Model;
import com.example.im.my_ipanda.presneter.contract.Contract;

/**
 * Created by I'M宋国召 on 2018/3/17.
 */

public class Presenter implements Contract.PresenterInf {
    private ModelInf modelInf;
    private Contract.ViewInf viewInf;

    public Presenter(Contract.ViewInf viewInf) {
        this.modelInf = new Model();
        this.viewInf = viewInf;
    }

    @Override
    public void getData(String[] strings) {
        modelInf.getData(strings, new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                viewInf.updataUI(msg.obj.toString());

            }
        });
    }
}