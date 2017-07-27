package com.fire.broadcastdemo.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fire.broadcastdemo.R;
import com.fire.broadcastdemo.broadcast.CustomReceiver;

/**
 * Created by Administrator on 2017/7/27.
 * 动态注册广播 非常驻类型广播
 */
public class CustomActivity extends AppCompatActivity {

    public static final String CONNECTIVITY_CHANGE = "CONNECTIVITY_CHANGE";
    private CustomReceiver customReceiver;
    private IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //实例化BroadcastReceiver子类
        customReceiver = new CustomReceiver();
        ////实例化IntentFilter,设置接收广播的类型
        filter = new IntentFilter(CONNECTIVITY_CHANGE);
        //调用Context的registerReceiver（）方法进行动态注册
        registerReceiver(customReceiver, filter);

        /*
        在Manifest里面注册的话如下：

        <receiver
            //此广播接收者类是CustomReceiver
            android:name=".CustomReceiver" >
            //用于接收网络状态改变时发出的广播
            <intent-filter>
                <action android:name="CONNECTIVITY_CHANGE" />
            </intent-filter>
        </receiver>


        */
    }


    //注册广播后，要在相应位置记得销毁广播
    //即在onPause() 中unregisterReceiver(mBroadcastReceiver)
    //当此Activity实例化时，会动态将MyBroadcastReceiver注册到系统中
    //当此Activity销毁时，动态注册的MyBroadcastReceiver将不再接收到相应的广播。
    @Override
    protected void onPause() {
        super.onPause();
        //销毁在onResume()方法中的广播
        unregisterReceiver(customReceiver);
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent();
        //对应BroadcastReceiver中intentFilter的action
        intent.setAction(CONNECTIVITY_CHANGE);
        intent.putExtra("data","广播发送了，请接收");
        //发送广播
        sendBroadcast(intent);
    }
}
