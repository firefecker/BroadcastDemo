package com.fire.test;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TestActivity extends AppCompatActivity {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                sendData();
            }
        }
    };

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alwaysSendBroad(View view) {
        handler.sendEmptyMessageDelayed(1,1000);
    }

    /**
     * 这里延迟发送广播，让另一个APP一直去只想相关操作。测试APP内广播的效果
     */
    private void sendData() {
        intent = new Intent();
        intent.setAction("OrderedActivity");
        intent.putExtra("msg","Hello");
        sendOrderedBroadcast(intent,null);
        handler.sendEmptyMessageDelayed(1,5000);
    }
}
