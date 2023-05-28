package view.viewdemo.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.derry.asdelegate.R;
import view.viewdemo.View.CustomDrawableViewe;

/**
 * Created by zyand on 2019/5/8.
 */

public class CustomDrawableActivity extends BaseActivity {


    ImageView image;

    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customdrawable);
        image = findViewById(R.id.image);
        tv = findViewById(R.id.tv);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.avator);
        CustomDrawableViewe drawableViewe = new CustomDrawableViewe(bitmap);

        image.setImageDrawable(drawableViewe);

        tv.setBackgroundDrawable(drawableViewe);
    }
}
