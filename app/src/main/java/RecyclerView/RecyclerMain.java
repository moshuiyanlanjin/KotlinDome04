package RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.lf.javademo.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class RecyclerMain extends Activity {

    private List<String> lists = new ArrayList<>();
    RecyclrView recyclrView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        recyclrView = findViewById(R.id.recy);
        initData();
        initView();
    }

    private void initView() {
        recyclrView.setAdapter(new DemoMainAdapter(this,lists));
    }

    private void initData() {
        for (int i = 0; i < 5000; i++) {
            lists.add("第" + i+ "杭");
        }
    }
}
