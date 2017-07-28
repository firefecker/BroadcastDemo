package com.fire.broadcastdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fire.broadcastdemo.R;
import com.fire.broadcastdemo.service.ReceptionService;

/**
 * Created by Administrator on 2017/7/28.
 * 前台的service
 *
 */
public class ReceptionServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reception_service);
    }

    /**
     * 开启一个Service，注意打印的日志。观察其生命周期的流程
     * @param view
     */
    public void startService(View view) {
        Intent startIntent = new Intent(this, ReceptionService.class);
        startService(startIntent);
    }

    /**
     * 停止一个Service，注意打印的日志。观察其生命周期的流程
     * @param view
     */
    public void stopService(View view) {
        Intent stopIntent = new Intent(this, ReceptionService.class);
        stopService(stopIntent);
    }
}
