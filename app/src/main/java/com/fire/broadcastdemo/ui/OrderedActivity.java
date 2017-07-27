package com.fire.broadcastdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fire.broadcastdemo.R;

/**
 * Created by Administrator on 2017/7/27.
 */
public class OrderedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
    }

    /**
     * 此处发送的一个有序广播，两个广播的action是相同的。但是优先级是不一样的。优先级的值越大越快接收到值
     *
     * 此处注册的两个广播在manifest里面。动态注册也是可以的
     *
     * 详情操作请看OrderedReceiverOne 和 OrderedReceiverTwo两个类
     * @param view
     */
    public void sendBroadcast(View view) {
        Intent intent = new Intent();
        intent.setAction("OrderedActivity");
        intent.putExtra("msg","Hello");
        sendOrderedBroadcast(intent, null);
    }
}