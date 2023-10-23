package com.example.kotlindemo04.EventbusDemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lf.javademo.EventbusDemo.yuan.DNEventbus;
import com.lf.javademo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.annotation.Nullable;

public class EvetbusMain extends Activity {

    TextView text;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      //  LruCache
        setContentView(R.layout.activity_eventbus);
        Button button = findViewById(R.id.btn);
        text = findViewById(R.id.text);
        //注册
       // EventBus.getDefault().register(this);
        DNEventbus.getDefault().register(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EvetbusMain.this,EvetbusSendActivity.class));
            }
        });
    }
    //@DNSubscribe(threadMode = DNThreadMode.MAIN)
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void setText(EvetbusBean evetbusBean){
        text.setText(evetbusBean.toString());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销
        EventBus.getDefault().unregister(this);
    //    DNEventbus.getDefault().unregister(this);
    }
}
