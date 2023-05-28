package view.viewdemo.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.derry.asdelegate.R;


/**
 * Created by zyand on 2019/4/18.
 */

public class ValueAnimatoroneActivity extends BaseActivity {


    Button button3;

    ImageView imageView6;
    Button button1;
    Button button2;

    private ValueAnimator redeanimator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valueanimator);
        button3 =findViewById(R.id.button3);
        imageView6 =findViewById(R.id.imageView6);
        button1 =findViewById(R.id.button1);
        button2 =findViewById(R.id.button2);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dovalueAnimator();
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("zlc", "点钟了");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redeanimator = toValueAnimator();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redeanimator.cancel();
            }
        });


    }


    private ValueAnimator toValueAnimator() {
        ValueAnimator animator = ValueAnimator.ofInt(400,500,300,400);
        animator.setDuration(5000);


        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer value = (Integer) valueAnimator.getAnimatedValue();
                imageView6.layout(value,value,value+imageView6.getWidth(),value+imageView6.getHeight());

            }
        });
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();
        return animator;
    }

    private void dovalueAnimator() {

        ValueAnimator animator = ValueAnimator.ofInt(0, 400);

        animator.setDuration(3000);
        animator.start();

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int animatedValue = (int) valueAnimator.getAnimatedValue();
                imageView6.layout(animatedValue, animatedValue, animatedValue + imageView6.getWidth(), animatedValue + imageView6.getHeight());
            }
        });
    }
}
