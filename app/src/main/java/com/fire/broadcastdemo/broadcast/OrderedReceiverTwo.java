package com.fire.broadcastdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/7/27.
 */

public class OrderedReceiverTwo extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = getResultExtras(true);//获取优先级高里面存入的数据
        //解析前一个BroadcastReceiver所存入的key为first的消息
        String first = bundle.getString("first");
        System.out.println(first);
        Toast.makeText(context, "我是第二个BroadcastReceiver，我收到的消息是：" + first, Toast.LENGTH_LONG).show();
    }

}
