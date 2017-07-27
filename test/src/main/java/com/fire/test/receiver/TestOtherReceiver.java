package com.fire.test.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/7/27.
 */

public class TestOtherReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        Toast.makeText(context, "我在另一个APP额，但是我接收到Intent的Action为：" + intent.getAction() + "\n 消息内容是：" + intent.getStringExtra("msg"), Toast.LENGTH_LONG).show();
    }
}
