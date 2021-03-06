package com.fire.broadcastdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fire.broadcastdemo.R;
import com.fire.broadcastdemo.service.LocalService;

/**
 * Created by Administrator on 2017/7/27.
 * 远程服务与本地服务最大的区别是：远程Service与调用者不在同一个进程里（即远程Service是运行在另外一个进程）；而本地服务则是与调用者运行在同一个进程里
 */
public class LocalServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_service);
    }

    /**
     * 开启一个Service，注意打印的日志。观察其生命周期的流程
     * @param view
     */
    public void startService(View view) {
        Intent startIntent = new Intent(this, LocalService.class);
        startService(startIntent);
    }

    /**
     * 停止一个Service，注意打印的日志。观察其生命周期的流程
     * @param view
     */
    public void stopService(View view) {
        Intent stopIntent = new Intent(this, LocalService.class);
        stopService(stopIntent);
    }
}
