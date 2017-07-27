package com.fire.broadcastdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/7/27.
 */

public class PlugReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_HEADSET_PLUG.equals(action)) {
            if (intent.hasExtra("state")) {
                int state = intent.getIntExtra("state", 0);
                if (state == 1) {
                    Toast.makeText(context, "插入耳机", Toast.LENGTH_SHORT).show();
                } else if(state == 0){
                    Toast.makeText(context, "拔出耳机", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
