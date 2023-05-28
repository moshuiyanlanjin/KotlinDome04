package view.viewdemo.activity;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Bundle;

import android.util.AttributeSet;
import android.view.View;

import com.derry.asdelegate.R;

import androidx.annotation.Nullable;


/**
 * Created by zyand on 2019/4/30.
 */

public class BezierThreeActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_bezier);
    }
}
