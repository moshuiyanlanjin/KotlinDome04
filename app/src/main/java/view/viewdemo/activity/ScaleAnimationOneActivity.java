package view.viewdemo.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import androidx.annotation.Nullable;

import android.view.View;
import android.widget.Button;

import com.derry.asdelegate.R;
import view.viewdemo.View.ScalseViea;


/**
 * Created by zyand on 2019/4/20.
 */

public class ScaleAnimationOneActivity extends BaseActivity {


    ScalseViea text;

    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaleanimation);
        text = findViewById(R.id.text);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(text,"ScalseSizex",6);
                animator.setDuration(3000);
                animator.setRepeatCount(ObjectAnimator.INFINITE);
                animator.start();
            }
        });
    }


}
