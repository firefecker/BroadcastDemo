package com.fire.broadcastdemo.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fire.broadcastdemo.R;
import com.fire.broadcastdemo.service.MyIntentService;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 * 多线程的应用在Android开发中是非常常见的，常用方法主要有：
 *
 * 1、继承Thread类
 * 2、实现Runnable接口
 * 3、AsyncTask
 * 4、Handler
 * 5、HandlerThread
 * 6、IntentService
 *
 * 今天，我将全面解析多线程其中一种常见用法：IntentService
 * IntentService是Android里面的一个封装类，继承自四大组件之一的Service。作用是处理异步请求，实现多线程
 *
 * 注意：若启动IntentService 多次，那么每个耗时操作则以队列的方式在 IntentService的onHandleIntent回调方法中依次执行，执行完自动结束。
 *
 * 实现步骤
 * 步骤1：定义IntentService的子类：传入线程名称、复写onHandleIntent()方法
 * 步骤2：在Manifest.xml中注册服务
 * 步骤3：在Activity中开启Service服务
 */
public class IntentServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        //同一服务只会开启一个工作线程
        //在onHandleIntent函数里依次处理intent请求。


        //java.lang.IllegalArgumentException: Service Intent must be explicit(报错，Intent必须显示声明)
        //此错为android 5.0后才会出现的
        //Intent i1 = new Intent("com.fire.intentservice");
        //解决方法1：显示声明开启的服务
        Intent i = new Intent(this, MyIntentService.class);
        Bundle bundle = new Bundle();
        bundle.putString("taskName", "task1");
        i.putExtras(bundle);
        startService(i);


        //解决方法2：
        Intent i2 = new Intent();
        i2.setAction("com.fire.intentservice");
        Intent eintent = new Intent(createExplicitFromImplicitIntent(this,i2));
        Bundle bundle2 = new Bundle();
        bundle2.putString("taskName", "task2");
        eintent.putExtras(bundle2);
        startService(eintent);



        startService(i);  //多次启动

    }

    /***
     * Android L (lollipop, API 21) introduced a new problem when trying to invoke implicit intent,
     * "java.lang.IllegalArgumentException: Service Intent must be explicit"
     *
     * If you are using an implicit intent, and know only 1 target would answer this intent,
     * This method will help you turn the implicit intent into the explicit form.
     *
     * Inspired from SO answer: http://stackoverflow.com/a/26318757/1446466
     * @param context
     * @param implicitIntent - The original implicit intent
     * @return Explicit Intent created from the implicit original intent
     */
    public static Intent createExplicitFromImplicitIntent(Context context, Intent implicitIntent) {
        // Retrieve all services that can match the given intent
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent, 0);

        // Make sure only one match was found
        if (resolveInfo == null || resolveInfo.size() != 1) {
            return null;
        }

        // Get component info and create ComponentName
        ResolveInfo serviceInfo = resolveInfo.get(0);
        String packageName = serviceInfo.serviceInfo.packageName;
        String className = serviceInfo.serviceInfo.name;
        ComponentName component = new ComponentName(packageName, className);

        // Create a new intent. Use the old one for extras and such reuse
        Intent explicitIntent = new Intent(implicitIntent);

        // Set the component to be explicit
        explicitIntent.setComponent(component);

        return explicitIntent;
    }

}
