package com.fire.broadcastdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2017/7/27.
 * 本地服务，这是最普通、最常用的服务
 *
 * 步骤1：新建子类继承Service类
 *       需重写父类的onCreate()、onStartCommand()、onDestroy()和onBind()方法
 *
 * 步骤2：构建用于启动Service的Intent对象
 *
 * 步骤3：调用startService()启动Service、调用stopService()停止服务
 *
 * 步骤4：在AndroidManifest.xml里注册Service
 *
 */

public class LocalService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG","执行了onCreate()方法");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG","执行了onStartCommand()方法");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("TAG","执行了onBind()方法");
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG","执行了onDestroy()方法");
    }
}
