package view.viewdemo.activity;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.derry.asdelegate.R;



/**
 * Created by zyand on 2019/4/24.
 */

public class SVGuseActivity extends BaseActivity {

    //解决23.2.0的兼容问题
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }


    ImageView imag;
    Button butt;
    EditText edit;
    ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svguse);
        imag = findViewById(R.id.imag);
        butt = findViewById(R.id.butt);
        edit = findViewById(R.id.edit);
        image = findViewById(R.id.image);

        final AnimatedVectorDrawableCompat compat = AnimatedVectorDrawableCompat.create(SVGuseActivity.this, R.drawable.line_animated_vectorone);
        imag.setImageDrawable(compat);
        ((Animatable) imag.getDrawable()).start();

        //将焦点放在ImageView上
        image.setFocusable(true);
        image.setFocusableInTouchMode(true);
        image.requestFocus();
        image.requestFocusFromTouch();

        //当Edittext获取焦点时开始动画
        edit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    AnimatedVectorDrawableCompat animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(
                            SVGuseActivity.this, R.drawable.animated_vector_search
                    );
                    image.setImageDrawable(animatedVectorDrawableCompat);
                    ((Animatable) image.getDrawable()).start();
                }
            }
        });
    }
}
