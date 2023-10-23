package RecyclerView;

import android.view.View;

import java.util.Stack;

/**
 * 回收站
 */
public class Recycler {

    //回收站缓存的栈数组，（因为存入的数据类型可能不至一个，所以要用栈数组）
    private Stack<View>[] stacks;
    public Recycler(int viewTypeCount) {

        stacks = new Stack[viewTypeCount];
        for (int i = 0; i < viewTypeCount; i++) {
            stacks[i] = new Stack<>();
        }
    }

    //取出回收站的item
    public View getRecyclerView(int type){

        try {
            return stacks[type].pop();
        }catch (Exception e){
            return null;
        }

    }

    //将可以回收的view存入栈中
    public void setRecycleView(int type ,View view){
        stacks[type].push(view);
    }

}
