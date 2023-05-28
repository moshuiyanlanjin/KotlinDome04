package view.viewdemo.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.derry.asdelegate.R;
import view.viewdemo.View.ShadowLayerView;

/**
 * Created by zyand on 2019/5/4.
 */

public class ShadowoneLayerActivity extends BaseActivity {


    Button clice;
    ShadowLayerView layerview;
    Button add;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadowone);
        clice = findViewById(R.id.clice);
        layerview = findViewById(R.id.layerview);
        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layerview.setShadow(true);
            }
        });
        clice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layerview.setShadow(false);
            }
        });
    }


}
