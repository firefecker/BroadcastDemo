package com.fire.broadcastdemo.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.fire.broadcastdemo.R;
import com.fire.broadcastdemo.service.LinkService;

/**
 * Created by Administrator on 2017/7/28.
 */
public class LinkServiceActivity extends AppCompatActivity {

    //创建Service里面的Binder对象
    private LinkService.LinkBinder myBinder;

    //创建ServiceConnection的匿名类
    private ServiceConnection connection = new ServiceConnection() {

        //重写onServiceConnected()方法和onServiceDisconnected()方法
        //在Activity与Service建立关联和解除关联的时候调用
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("TAG",name.toString());
        }

        //在Activity与Service建立关联的时候调用
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //实例化Service的内部类myBinder
            //通过向下转型得到了MyBinder的实例
            myBinder = (LinkService.LinkBinder) service;
            //在Activity调用Service类的方法
            myBinder.service_connect_Activity();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_service);
    }

    /**
     * 绑定Service
     * @param view
     */
    public void bindService(View view) {
        //构建绑定服务的Intent对象
        Intent bindIntent = new Intent(this, LinkService.class);
        //调用bindService()方法,以此停止服务
        bindService(bindIntent,connection,BIND_AUTO_CREATE);
        //参数说明
        //第一个参数:Intent对象
        //第二个参数:上面创建的Serviceconnection实例
        //第三个参数:标志位
        //这里传入BIND_AUTO_CREATE表示在Activity和Service建立关联后自动创建Service
        //这会使得MyService中的onCreate()方法得到执行，但onStartCommand()方法不会执行

    }

    /**
     * 解绑service
     * @param view
     */
    public void unbindService(View view) {
        //调用unbindService()解绑服务
        //参数是上面创建的Serviceconnection实例
        unbindService(connection);
    }




}
