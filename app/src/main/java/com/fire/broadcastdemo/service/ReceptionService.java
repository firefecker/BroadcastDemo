package com.fire.broadcastdemo.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.fire.broadcastdemo.R;
import com.fire.broadcastdemo.ui.MainActivity;

/**
 * Created by Administrator on 2017/7/28.
 * 前台服务使用startService方式和bindService方式都可以
 * 此处使用start方式
 *
 */

public class ReceptionService extends Service {


    /**
     * 不显示有可能是你手机或者模拟器的权限问题。设置通知开启就ok了
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG","执行了onCreate()方法");
        //添加下列代码将后台Service变成前台Service
        //构建"点击通知后打开MainActivity"的Intent对象
        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);

        //新建Builer对象
        Notification.Builder builer = new Notification.Builder(this);
        builer.setContentTitle("前台服务通知的标题");//设置通知的标题
        builer.setContentText("前台服务通知的内容");//设置通知的内容
        builer.setSmallIcon(R.mipmap.ic_launcher);//设置通知的图标
        builer.setContentIntent(pendingIntent);//设置点击通知后的操作

        Notification notification = builer.getNotification();//将Builder对象转变成普通的notification
        startForeground(149, notification);//让Service变成前台Service,并在系统的状态栏显示出来

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
