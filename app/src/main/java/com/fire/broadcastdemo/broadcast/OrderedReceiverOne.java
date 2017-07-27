package com.fire.broadcastdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/7/27.
 */

public class OrderedReceiverOne extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "接收到Intent的Action为：" + intent.getAction() + "\n 消息内容是：" + intent.getStringExtra("msg"), Toast.LENGTH_LONG).show();
        //创建一个Bundle对象并存入数据
        Bundle bundle = new Bundle();
        bundle.putString("first", "LaLaLaLa!!!");
        //将Bundle放入结果中。因为广播优先级限制。可以将优先级高的广播的值传送到优先级低的广播里面
        setResultExtras(bundle);
    }

}
