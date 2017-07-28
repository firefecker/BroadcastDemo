package com.fire.broadcastdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.fire.broadcastdemo.AIDL_Service;

/**
 * Created by Administrator on 2017/7/28.
 * AIDL服务端代码  IPC进程间通信
 */

public class AIDLService extends Service {

    // 实例化AIDL的Stub类(Binder的子类)。不是实例化AIDL接口
    AIDL_Service.Stub mBinder = new AIDL_Service.Stub() {
        /**
         * 重写里面的方法
         * @param anInt
         * @param aLong
         * @param aBoolean
         * @param aFloat
         * @param aDouble
         * @param aString
         * @throws RemoteException
         */
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        /**
         * 重写里面的方法
         * @throws RemoteException
         */
        @Override
        public void AIDL_Service1() throws RemoteException {
            Log.e("TAG","客户端通过AIDL与远程后台成功通信");
        }
    };


    //重写与Service生命周期的相关方法
    @Override
    public void onCreate() {
        super.onCreate();

        Log.e("TAG","执行了onCreat()");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG","执行了onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG","执行了onDestory()");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.e("TAG","执行了onBind()");
        //在onBind()返回继承自Binder的Stub类型的Binder，非常重要
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("TAG","执行了onUnbind()");
        return super.onUnbind(intent);
    }

}
