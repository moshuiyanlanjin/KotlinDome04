package view.viewdemo.activity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import androidx.annotation.Nullable;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.derry.asdelegate.R;



/**
 * Created by zyand on 2019/5/8.
 */

public class ShapeInstanceActivity extends BaseActivity {


    Button addShapeCorner;

    TextView shapeTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_instance);
        addShapeCorner = findViewById(R.id.add_shape_corner);
        shapeTv = findViewById(R.id.shape_tv);
        addShapeCorner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GradientDrawable drawable = (GradientDrawable) shapeTv.getBackground();
                drawable.setCornerRadius(20);
            }
        });
    }

}
