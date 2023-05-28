package view.viewdemo.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.derry.asdelegate.R;

/**
 * Created by zyand on 2019/4/18.
 */

public class ViewAnimationtwoActivity extends BaseActivity {

    Button button2;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    TextView textView10;
    ImageView imageView;
    ImageView imageView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewanimationtwo);
        button2 =findViewById(R.id.button2);
        textView6 =findViewById(R.id.textView6);
        textView7 =findViewById(R.id.textView7);
        textView8 =findViewById(R.id.textView8);
        textView9 =findViewById(R.id.textView9);
        textView10 =findViewById(R.id.textView10);
        imageView =findViewById(R.id.imageView);
        imageView2 =findViewById(R.id.imageView2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //缩放
                ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1.5f, 0, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(10000);
                textView6.startAnimation(scaleAnimation);

                //渐变
                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(10000);
                textView7.startAnimation(alphaAnimation);

                //平移
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 600, 0, 600);
                translateAnimation.setDuration(10000);
                //快慢
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                textView8.startAnimation(translateAnimation);

                //旋转
                RotateAnimation rotateAnimation = new RotateAnimation(0, 7200, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(10000);
                //匀速
                rotateAnimation.setInterpolator(new LinearInterpolator());
                textView9.startAnimation(rotateAnimation);

                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(rotateAnimation);
                animationSet.setDuration(10000);
                //固定结束状态
                animationSet.setFillAfter(true);
                textView10.setAnimation(animationSet);

                int fx = 0;
                int fy = 0;

                final TranslateAnimation translateAnimation1 = new TranslateAnimation(fx, 50, fy, 200);
                translateAnimation1.setDuration(3000);
                translateAnimation1.setFillAfter(true);
                //飞快、慢
                translateAnimation1.setInterpolator(new DecelerateInterpolator());
                imageView.startAnimation(translateAnimation1);

                translateAnimation1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        //开始

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //结束
                        TranslateAnimation translateAnimation2 = new TranslateAnimation(50, 80, 200, 30);
                        translateAnimation2.setDuration(3000);
                        //慢、飞快
                        translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
                        imageView.startAnimation(translateAnimation2);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        //重复

                    }
                });


                TranslateAnimation translateAnimation3 = new TranslateAnimation(0,0,0,600);
                ScaleAnimation scaleAnimation1 = new ScaleAnimation(1,1.5f,1,1.5f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                AnimationSet animationSet1 = new AnimationSet(true);
                animationSet1.addAnimation(translateAnimation3);
                animationSet1.addAnimation(scaleAnimation1);
                animationSet1.setInterpolator(new BounceInterpolator());
                animationSet1.setDuration(6000);
                imageView2.startAnimation(animationSet1);
            }
        });

    }


}
