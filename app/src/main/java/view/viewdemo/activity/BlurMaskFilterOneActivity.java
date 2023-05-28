package view.viewdemo.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.derry.asdelegate.R;
import view.viewdemo.View.BlurMaskFilterOneView;



/**
 * Created by zyand on 2019/5/4.
 */

public class BlurMaskFilterOneActivity extends BaseActivity {


    Button add;
    Button clice;
    BlurMaskFilterOneView views;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluermask_one);
        add = findViewById(R.id.add);
        clice = findViewById(R.id.clice);
        views = findViewById(R.id.viewss);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                views.setBlur(true);
            }
        });
        clice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                views.setBlur(false);
            }
        });
    }


}
