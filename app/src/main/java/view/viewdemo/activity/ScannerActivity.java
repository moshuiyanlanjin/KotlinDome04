package view.viewdemo.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


import com.derry.asdelegate.R;


/**
 * Created by zyand on 2019/4/18.
 */

public class ScannerActivity extends BaseActivity {


    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;


    Animation animation1;
    Animation animation2;
    Animation animation3;
    Animation animation4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);

        initView();
    }

    private void initView() {

        animation1 = AnimationUtils.loadAnimation(ScannerActivity.this,R.anim.scanneranim);
        animation2 = AnimationUtils.loadAnimation(ScannerActivity.this,R.anim.scanneranim);
        animation3 = AnimationUtils.loadAnimation(ScannerActivity.this,R.anim.scanneranim);
        animation4 = AnimationUtils.loadAnimation(ScannerActivity.this,R.anim.scanneranim);
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView4.startAnimation(animation1);

                animation2.setStartOffset(600);
                imageView3.startAnimation(animation2);

                animation3.setStartOffset(1200);
                imageView2.startAnimation(animation3);

                animation4.setStartOffset(1800);
                imageView1.startAnimation(animation4);
            }
        });

    }

}
