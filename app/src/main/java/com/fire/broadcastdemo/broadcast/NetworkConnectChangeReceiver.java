package com.fire.broadcastdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

/**
 * Created by Administrator on 2017/7/27.
 */

public class NetworkConnectChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (WifiManager.WIFI_STATE_CHANGED_ACTION.equals(intent.getAction())) {// 监听wifi的打开与关闭，与wifi的连接无关
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0);
            switch (wifiState) {
                //WIFI关闭
                case WifiManager.WIFI_STATE_DISABLED:
                    Log.e("TAG","WIFI关闭");
                    break;
                //WIFI打开
                case WifiManager.WIFI_STATE_DISABLING:
                    Log.e("TAG","WIFI打开");
                    break;
            }
        }


        // 监听网络连接，包括wifi和移动数据的打开和关闭,以及连接上可用的连接都会接到监听
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            //获取联网状态的NetworkInfo对象
            NetworkInfo info = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            String subtypeName = info.getSubtypeName();
            Log.e("TAG",subtypeName+"");
            if (info != null) {
                //如果当前的网络连接成功并且网络连接可用
                if (NetworkInfo.State.CONNECTED == info.getState() && info.isAvailable()) {
                    if (info.getType() == ConnectivityManager.TYPE_WIFI
                            || info.getType() == ConnectivityManager.TYPE_MOBILE
                            || info.getType() == ConnectivityManager.TYPE_BLUETOOTH) {
                        Log.e("TAG", getConnectionType(info.getType()) + "连上");
                    }
                } else {
                    Log.e("TAG", getConnectionType(info.getType()) + "断开");
                }
            }
        }
    }

    private String getConnectionType(int type) {
        String connType = "";
        if (type == ConnectivityManager.TYPE_MOBILE) {
            connType = "移动数据";
        } else if (type == ConnectivityManager.TYPE_WIFI) {
            connType = "WIFI网络";
        } else if (type == ConnectivityManager.TYPE_BLUETOOTH) {
            connType = "蓝牙";
        }
        return connType;
    }
}
