package view.viewdemo.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Bundle;
import androidx.annotation.Nullable;
import view.viewdemo.MyEvaluation.SimoleEvaluation;
import view.viewdemo.View.simpleparbolocview;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.derry.asdelegate.R;

/**
 * Created by zyand on 2019/4/19.
 */

public class SimpleparabolicActivity extends BaseActivity  {


    Button button5;

    ImageView imageView7;

    Button button;

    simpleparbolocview yuan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpleparabolic);
        yuan = findViewById(R.id.yuan);
        imageView7 = findViewById(R.id.imageView7);
        button5 = findViewById(R.id.button5);
        button = findViewById(R.id.button);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator animator = ValueAnimator.ofObject(new SimoleEvaluation(), new Point(0, 0), new Point(500, 500));
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Point point = (Point) valueAnimator.getAnimatedValue();
                        imageView7.layout(point.x, point.y, point.x + imageView7.getWidth(), point.y + imageView7.getHeight());
                    }
                });
                animator.setDuration(3000);
                animator.start();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("zlc", "点击了");
                ObjectAnimator animator1 = ObjectAnimator.ofObject(yuan, "simpleparabolic", new SimoleEvaluation(), new Point(0, 0), new Point(500, 500));
                animator1.setDuration(3000);
                animator1.start();
            }
        });
    }







}
