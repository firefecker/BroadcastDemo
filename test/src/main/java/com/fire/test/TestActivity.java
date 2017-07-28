package com.fire.test;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fire.broadcastdemo.AIDL_Service;

public class TestActivity extends AppCompatActivity {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                sendData();
            }
        }
    };

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alwaysSendBroad(View view) {
        handler.sendEmptyMessageDelayed(1,1000);
    }

    /**
     * 这里延迟发送广播，让另一个APP一直去只想相关操作。测试APP内广播的效果
     */
    private void sendData() {
        intent = new Intent();
        intent.setAction("OrderedActivity");
        intent.putExtra("msg","Hello");
        sendOrderedBroadcast(intent,null);
        handler.sendEmptyMessageDelayed(1,5000);
    }


    /**
     * IPC 进程间通信的客户端  AIDL
     */

    //定义aidl接口变量
    private AIDL_Service mAIDL_Service;

    //创建ServiceConnection的匿名类
    private ServiceConnection connection = new ServiceConnection() {

        //重写onServiceConnected()方法和onServiceDisconnected()方法
        //在Activity与Service建立关联和解除关联的时候调用
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

        //在Activity与Service建立关联时调用
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            //使用AIDLService1.Stub.asInterface()方法获取服务器端返回的IBinder对象
            //将IBinder对象传换成了mAIDL_Service接口对象
            mAIDL_Service = AIDL_Service.Stub.asInterface(service);

            try {
                //通过该对象调用在MyAIDLService.aidl文件中定义的接口方法,从而实现跨进程通信
                mAIDL_Service.AIDL_Service1();

            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };



    /**
     * 设置绑定服务的按钮
     * @param view
     */
    public void bindService(View view) {

        Log.e("TAG","点击了[绑定服务]按钮");

        //通过Intent指定服务端的服务名称和所在包，与远程Service进行绑定
        //参数与服务器端的action要一致,即"服务器包名.aidl接口文件名"
        Intent intent = new Intent("com.fire.broadcastdemo.AIDL_Service");

        //Android5.0后无法只通过隐式Intent绑定远程Service
        //需要通过setPackage()方法指定包名
        intent.setPackage("com.fire.broadcastdemo");

        //绑定服务,传入intent和ServiceConnection对象
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
}
