package com.fire.broadcastdemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.fire.broadcastdemo.R;

/**
 * 静态注册广播，常驻类型。检测网络连接状态
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 检测网络连接
     * @param view
     */
    public void NetWorkConnectChange(View view) {
        startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
    }

    /**
     * 普通广播
     * @param view
     */
    public void CustomReceiver(View view) {
        startActivity(new Intent(this,CustomActivity.class));
    }

    /**
     * 系统广播
     * @param view
     */
    public void SystemReceiver(View view) {
        startActivity(new Intent(this,SystemActivity.class));
    }

    /**
     * 有序广播
     * @param view
     */
    public void OrderedReceiver(View view) {
        startActivity(new Intent(this,OrderedActivity.class));
    }

    /**
     * 粘性广播
     * @param view
     */
    public void StickyReceiver(View view) {
        startActivity(new Intent(this,StickyActivity.class));
    }

    /**
     * App应用内广播
     * @param view
     */
    public void LocalReceiver(View view) {
        startActivity(new Intent(this,LocalActivity.class));
    }

    /**
     * 本地服务
     * @param view
     */
    public void LocalService(View view) {
        startActivity(new Intent(this,LocalServiceActivity.class));
    }

    /**
     * 可通信的服务
     * @param view
     */
    public void LinkService(View view) {

    }

    // 跳转到无线网络设置界面
//    startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
    // 跳转到无限wifi网络设置界面
//    startActivity(new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS));
}
