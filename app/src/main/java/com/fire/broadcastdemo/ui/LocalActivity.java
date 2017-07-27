package com.fire.broadcastdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fire.broadcastdemo.R;

/**
 * Created by Administrator on 2017/7/27.
 * Android中的广播可以跨App直接通信（exported对于有intent-filter情况下默认值为true）
 *
 * 可能出现的问题（会出现安全性 & 效率性的问题）：
 * 1、其他App针对性发出与当前App intent-filter相匹配的广播，由此导致当前App不断接收广播并处理；
 * 2、其他App注册与当前App一致的intent-filter用于接收广播，获取广播具体信息；
 *
 * 解决方案：使用App应用内广播（Local Broadcast）
 *
 * 具体使用 - 将全局广播设置成局部广播
 * 1、注册广播时将exported属性设置为false，使得非本App内部发出的此广播不被接收；
 * 2、在广播发送和接收时，增设相应权限permission，用于权限验证；
 * 3、发送广播时指定该广播接收器所在的包名，此广播将只会发送到此包中的App内与之相匹配的有效广播接收器中。
 *    通过intent.setPackage(packageName)指定报名
 *
 */
public class LocalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
    }

    public void sendBroadcast(View view) {
        //当我在另一个APP内增加一个广播并在manifest里面注册的，设置action为LocalActivity。不设置exported属性为false。
        //后台运行另一个APP。在运行本app。点击按钮的时候就会触发相关结果。使另一个app接收到相关广播。设置exported属性为true则接受不到
        Intent intent = new Intent();
        intent.setPackage("com.fire.test");
        intent.setAction("LocalActivity");
        intent.putExtra("msg","Hello");
        sendOrderedBroadcast(intent,null);
    }
}