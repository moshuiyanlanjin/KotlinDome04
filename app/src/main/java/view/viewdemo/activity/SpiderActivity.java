package view.viewdemo.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;

import com.derry.asdelegate.R;

/**
 * Created by zyand on 2019/4/17.
 */

public class SpiderActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spider);
        if(true || false){
            Log.d("ceshi",1+"");
        }else if(true && true){
            Log.d("ceshi","2");
        }


    }
}
