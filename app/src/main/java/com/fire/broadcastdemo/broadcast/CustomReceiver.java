package com.fire.broadcastdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/7/27.
 */

public class CustomReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String data = intent.getStringExtra("data");
        if (TextUtils.isEmpty(data)) {
            return;
        }
        Toast.makeText(context, data+"", Toast.LENGTH_SHORT).show();
    }
}
