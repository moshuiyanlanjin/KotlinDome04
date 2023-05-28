package view.viewdemo.activity;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import view.viewdemo.adapter.ItemAnimatorAdapter;

import android.view.View;
import android.widget.Button;

import com.derry.asdelegate.R;


import java.util.ArrayList;
import java.util.List;



/**
 * Created by zyand on 2019/4/22.
 */

public class ItemAnimatorActivity extends BaseActivity {


    RecyclerView recy;
    Button button;
    Button button1;
    int i = 1;

    ItemAnimatorAdapter adapter;

    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemanimator);
        recy = findViewById(R.id.recy);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);

        initDate();
        initView();
    }

    private void initDate() {
        list.add("1");
    }

    private void initView() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        LayoutTransition transition = new LayoutTransition();

        ObjectAnimator animator = ObjectAnimator.ofFloat(null, "TranslationY", 0, 360, 0);
        transition.setAnimator(LayoutTransition.APPEARING, animator);

      //  recy.setLayoutTransition(transition);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        adapter = new ItemAnimatorAdapter(this, list);
        recy.setAdapter(adapter);
        recy.setLayoutManager(manager);
    }



    private void add() {
        i++;

       list.add(0,i+"");
        adapter.addDate(list);
    }
}
