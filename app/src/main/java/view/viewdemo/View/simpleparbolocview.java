package view.viewdemo.View;

import android.content.Context;
import android.graphics.Point;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by zyand on 2019/4/19.
 */

public class simpleparbolocview extends AppCompatImageView {
    public simpleparbolocview(Context context) {
        super(context);
    }

    public simpleparbolocview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public simpleparbolocview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setSimpleparabolic(Point point){
        layout(point.x,point.y,point.x+getWidth(),point.y+getHeight());
    }

}
