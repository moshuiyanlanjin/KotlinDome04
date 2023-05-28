package view.viewdemo.activity;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import androidx.annotation.Nullable;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.derry.asdelegate.R;



/**
 * Created by zyand on 2019/4/22.
 */

public class ThephonerangthebellActivity extends BaseActivity {


    ImageView phone;

    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_phonerangthebell);
        phone = findViewById(R.id.phone);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone.animate().rotation(60).scaleX(2).scaleY(2).rotation(-60).setDuration(5000);
            }
        });
    }

//    @OnClick(R.id.button)
//    public void onViewClicked() {
//        /*Keyframe keyframe = Keyframe.ofFloat(0.1f,30);
//        Keyframe keyframe1 = Keyframe.ofFloat(0.2f,-30);
//        Keyframe keyframe2 = Keyframe.ofFloat(0.3f,20);
//        Keyframe keyframe3 = Keyframe.ofFloat(0.4f,-20);
//        Keyframe keyframe4 = Keyframe.ofFloat(0.5f,60);
//        Keyframe keyframe5 = Keyframe.ofFloat(0.6f,-50);
//        Keyframe keyframe6 = Keyframe.ofFloat(0.7f,30);
//        Keyframe keyframe7 = Keyframe.ofFloat(0.8f,-30);
//        Keyframe keyframe8 = Keyframe.ofFloat(0.9f,20);
//        Keyframe keyframe9 = Keyframe.ofFloat(1f,0);
//        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("rotation",keyframe,keyframe1,keyframe2,keyframe3,keyframe4,
//                keyframe5,keyframe6,keyframe7,keyframe8,keyframe9);
//
//        Animator animator = ObjectAnimator.ofPropertyValuesHolder(phone,holder);
//        animator.setDuration(3000);
//        animator.start();*/
//
//        //animate不能重复使用某一个属性，他会以相同属性的最后一个为准
//        phone.animate().rotation(60).scaleX(2).scaleY(2).rotation(-60).setDuration(5000);
//
//    }
}
