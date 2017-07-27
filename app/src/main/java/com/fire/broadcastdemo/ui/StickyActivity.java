package com.fire.broadcastdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.fire.broadcastdemo.R;

/**
 * Created by Administrator on 2017/7/27.
 */
public class StickyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
    }

    public void sendBroadcast(View view) {
        Toast.makeText(this, "由于在Android5.0 & API 21中已经失效，所以不建议使用，在这里也不作过多的总结。", Toast.LENGTH_SHORT).show();
    }
}