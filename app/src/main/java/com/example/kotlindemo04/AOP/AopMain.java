package com.example.kotlindemo04.AOP;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lf.javademo.AOP.annotation.PermissionMeed;
import com.lf.javademo.R;

import androidx.annotation.Nullable;

public class AopMain extends Activity  {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aop_main);
        Button btn1 = findViewById(R.id.btu1);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reluestioncation();
            }
        });
    }

    @PermissionMeed(value = Manifest.permission.ACCESS_COARSE_LOCATION,requestCode = 11)
    private void reluestioncation() {
         /*long begin = System.currentTimeMillis();
         SystemClock.sleep(new Random().nextInt(2000));
         long duration = System.currentTimeMillis() - begin;*/
        Log.d("当前权限授权成功","返回：0");
    }

    @PermissionMeed(value = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA},requestCode = 11)
    private void reluestioncations() {
        Log.d("当前权限授权成功","返回：0");
    }

    private void onPermissionDenied(int requestCode){
        Log.d("当前权限拒绝","返回：" + requestCode);
    }
}
