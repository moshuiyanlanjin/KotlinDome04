package RecyclerView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

import com.lf.javademo.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclrView extends ViewGroup {

    //是否需要重绘
    public boolean needRelayout;

    //屏幕上显示陈View集合
    private List<View> viewList;

    private Adapter adapter;

    private int rawCount;

    private int[] heights;

    //回收站
    private Recycler recycler;

    //最小滑动距离
    private int touchSlop;

    private int currentY;

    private Context context;

    public RecyclrView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        needRelayout = true;
        viewList = new ArrayList<>();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        //获取最小滑动距离
        touchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(Adapter adapter){
        if(adapter != null){
            needRelayout = true;
            this.adapter = adapter;
            recycler = new Recycler(this.adapter.getViewTypeCount());

        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //用于测量，一般需要去遍历chilView，比较耗时
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if(needRelayout || changed){
            //测量
            needRelayout = false;

            viewList.clear();
            //清空所有的view，会非常耗时
            removeAllViews();


            if(adapter != null){
                rawCount = adapter.getCount();
                heights = new int[rawCount];
                for (int i = 0; i < rawCount; i++) {
                    heights[i] = adapter.getHeight(i);
                }


                int width = r - 1;
                int height = b - t;

                int top = 0,bottom;

                for (int i = 0; i < rawCount && top<height; i++) {
                    bottom = top + heights[i];
                    //实例化item布局
                    View view = MakeAndSetUp(i,0,top,width,bottom);
                    //将加载的布局缓存到viewList中
                    viewList.add(view);

                    top = bottom;
                }
            }
        }
    }

    private View MakeAndSetUp(int i, int lift, int top, int right, int bottom) {
        View view = obtain(i,right-lift,bottom-top);
        view.layout(lift,top,right,bottom);
        return view;
    }

    private View obtain(int i, int width, int height) {
        int type = adapter.getItemViewType(i);
        View recyclerView = recycler.getRecyclerView(type);
        View view = null;
        if(recyclerView == null){
            view =  adapter.onCreatrViewHolder(i,null,this);
            if(view == null){
                throw new RuntimeException("必须初始化：onCreatrViewHolder");
            }
        }else{
            view = adapter.onBinderViewHolder(i,recyclerView,this);
        }

        Log.d("当前执行：","postion:" + i);
        view.setTag(R.id.tag_type_view,type);
        view.measure(MeasureSpec.makeMeasureSpec(width,MeasureSpec.EXACTLY),MeasureSpec.makeMeasureSpec(height,MeasureSpec.EXACTLY));

        //将item布局添加进入布局中
        addView(view,0);

        return view;
    }

    @Override
    public void removeView(View view) {
        int type = (int) view.getTag(R.id.tag_type_view);
        Log.d("当前执行：","type:" + type);
        recycler.setRecycleView(type,view);

    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        boolean intercept = false;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                currentY = (int) event.getRawY();
                Log.d("当前点击的点是：",currentY + "");
                break;
            case MotionEvent.ACTION_UP:
                int y2 = Math.abs(currentY - (int)event.getRawY());
                if(y2 > touchSlop){
                    intercept = true;
                }
                break;
        }

        return intercept;
    }

    @Override
    public void scrollBy(int x, int y) {
        super.scrollBy(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_MOVE:
                int rawY = (int) event.getRawY();
                int y = currentY-rawY;
                Log.d("当前滑动的值为：",y + "");
                scrollBy(0,y);
                break;
        }

        return super.onTouchEvent(event);
    }

    interface Adapter{
        View onCreatrViewHolder(int position,View convertView,ViewGroup parent);

        View onBinderViewHolder(int position,View convertView,ViewGroup parent);

        //item的类型
        int getItemViewType(int row);

        //item类型的数量
        int getViewTypeCount();

        //item的数量
        int getCount();

        //获取itemview的高度
       public int getHeight(int index);
    }
}
