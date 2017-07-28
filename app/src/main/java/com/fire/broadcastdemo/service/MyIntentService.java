package com.fire.broadcastdemo.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2017/7/28.
 */

public class MyIntentService extends IntentService {

    /**
     * 构造函数
     */
    public MyIntentService() {
        //调用父类的构造函数
        //构造函数参数=工作线程的名字
        super("myIntentService");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     * 构造函数
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        //调用父类的构造函数
        //构造函数参数=工作线程的名字
        super(name);
    }

    /**
     * 复写onHandleIntent()方法
     * 实现耗时任务的操作
     * @param intent
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        //根据Intent的不同进行不同的事务处理
        String taskName = intent.getExtras().getString("taskName");
        switch (taskName) {
            case "task1":
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.e("TAG", "do task1");
                break;
            case "task2":
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.e("TAG", "do task2");
                break;
            default:
                break;
        }
    }

    @Override
    public void onCreate() {
        Log.e("TAG", "onCreate");
        super.onCreate();
    }

    /*复写onStartCommand()方法*/
    //默认实现将请求的Intent添加到工作队列里
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("TAG", "onDestroy");
        super.onDestroy();
    }

}
