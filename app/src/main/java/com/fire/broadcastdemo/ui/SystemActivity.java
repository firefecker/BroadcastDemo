package com.fire.broadcastdemo.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fire.broadcastdemo.R;
import com.fire.broadcastdemo.broadcast.PlugReceiver;


/**
 * Created by Administrator on 2017/7/27.
 * 系统广播
 */
public class SystemActivity extends AppCompatActivity {

    private PlugReceiver plugReceiver;
    private IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
    }

    public void sendBroadcast(View view) {

        //注意此处不需要自己去发送广播，系统广播会自己检测。不然会崩溃

        //此处检测耳机插拔广播，在Manifest里面注册是没有效果的，必须动态注册才有效果
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_HEADSET_PLUG);
//        sendBroadcast(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        plugReceiver = new PlugReceiver();
        filter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        registerReceiver(plugReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(plugReceiver);
    }
}
