package view.viewdemo.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.derry.asdelegate.R;


/**
 * Created by zyand on 2019/4/18.
 */

public class ViewAnimationOneActivity extends BaseActivity {


    Button button;
    TextView textView;
    TextView textView2;


    Animation animation;
    TextView textView3;
    TextView textView4;
    TextView textView5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaleanimationone);

        button =findViewById(R.id.button);
        textView =findViewById(R.id.textView);
        textView2 =findViewById(R.id.textView2);
        textView3 =findViewById(R.id.textView3);
        textView4 =findViewById(R.id.textView4);
        textView5 =findViewById(R.id.textView5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //缩放
                animation = AnimationUtils.loadAnimation(ViewAnimationOneActivity.this, R.anim.scaleoneanim);
                textView.startAnimation(animation);

                //渐变透明
                animation = AnimationUtils.loadAnimation(ViewAnimationOneActivity.this, R.anim.alphaoneanim);
                textView2.startAnimation(animation);

                //旋转
                animation = AnimationUtils.loadAnimation(ViewAnimationOneActivity.this, R.anim.rotateoneanim);
                textView3.startAnimation(animation);

                //平移
                animation = AnimationUtils.loadAnimation(ViewAnimationOneActivity.this, R.anim.translateoneanim);
                textView4.startAnimation(animation);

                //集合
                animation = AnimationUtils.loadAnimation(ViewAnimationOneActivity.this, R.anim.setoneanim);
                textView5.startAnimation(animation);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("zlc", "点击了");
            }
        });


    }


}
