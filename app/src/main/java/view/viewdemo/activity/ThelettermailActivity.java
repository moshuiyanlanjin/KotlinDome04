package view.viewdemo.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import androidx.annotation.Nullable;
import view.viewdemo.MyEvaluation.TheleEvaluation;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.derry.asdelegate.R;


/**
 * Created by zyand on 2019/4/19.
 */

public class ThelettermailActivity extends BaseActivity {


    Button button4;
    TextView textView11;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thelettermail);
        button4 = findViewById(R.id.button4);
        textView11 = findViewById(R.id.textView11);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator animator = ValueAnimator.ofObject(new TheleEvaluation(), new Character('A'),new Character('Z'));

                animator.setDuration(3000);
                animator.setRepeatCount(ValueAnimator.INFINITE);
                /*animator.setDuration(ValueAnimator.RESTART);*/

                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        char animatedValue = (Character) valueAnimator.getAnimatedValue();
                        Log.d("zlc",animatedValue+"");
                        textView11.setText(String.valueOf(animatedValue));
                    }
                });

                animator.start();
            }
        });
    }


}
