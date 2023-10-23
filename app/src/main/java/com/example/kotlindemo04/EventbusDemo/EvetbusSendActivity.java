package com.example.kotlindemo04.EventbusDemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.lf.javademo.R;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.Nullable;

public class EvetbusSendActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecetbus_send);

    }

    public void send(View view) {
        EventBus.getDefault().post(new EvetbusBean("张三",21));
    }
}
