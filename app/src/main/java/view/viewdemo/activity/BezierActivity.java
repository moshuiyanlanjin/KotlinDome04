package view.viewdemo.activity;

import android.os.Bundle;

import com.derry.asdelegate.R;

import androidx.annotation.Nullable;


/**
 * Created by zyand on 2019/4/29.
 */

public class BezierActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier);
    }
}
