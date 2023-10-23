package com.example.kotlindemo04.HuanFu;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

import com.lf.javademo.R;
import com.lf.skin_core.SkinManage;

import java.io.File;

public class SkinActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_skin);

        new EditText(this);
    }

    public void skin(View view) {
       String path = Environment.getExternalStorageDirectory() + File.separator + "app_skin-debug.apk";
      //  SkinManage.getInstance().loadSkin("/sdcard/app-skin-debug.skin");
        SkinManage.getInstance().loadSkin(path);
    }
}
