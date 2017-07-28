package com.fire.broadcastdemo.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2017/7/28.
 */

public class LinkService extends Service {

    private LinkBinder linkBinder = new LinkBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG","执行了onCreate()方法");

    }

    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        Log.e("TAG","执行了bindService()方法");
        return super.bindService(service, conn, flags);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("TAG","执行了onBind()方法");
        //返回实例
        return linkBinder;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("TAG","执行了onUnbind()方法");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG","执行了onDestroy()方法");
    }


   public class LinkBinder extends Binder {

        public void service_connect_Activity() {
            Log.e("TAG","Service关联了Activity,并在Activity执行了Service的方法");

        }

    }

}
