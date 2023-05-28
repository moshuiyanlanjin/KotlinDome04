package view.viewdemo;

import android.content.Intent;
import android.os.Bundle;


import com.derry.asdelegate.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import view.viewdemo.activity.AliPlayActivity;
import view.viewdemo.activity.AvatorActivity;
import view.viewdemo.activity.BezierActivity;
import view.viewdemo.activity.BezierThreeActivity;
import view.viewdemo.activity.BezierTwoActivity;
import view.viewdemo.activity.BitmapShaderViewActivity;
import view.viewdemo.activity.BlendAnimationOneActivity;
import view.viewdemo.activity.BlurMaskFilterOneActivity;
import view.viewdemo.activity.CanvasActivity;
import view.viewdemo.activity.CanvasTwoActivity;
import view.viewdemo.activity.CliprgnActivity;
import view.viewdemo.activity.CustomCircleActivity;
import view.viewdemo.activity.CustomDrawableActivity;
import view.viewdemo.activity.EraserActivity;
import view.viewdemo.activity.FunctiononeActivity;
import view.viewdemo.activity.ImageValueanimtoroneActivity;
import view.viewdemo.activity.ItemAnimatorActivity;
import view.viewdemo.activity.LightBookActivity;
import view.viewdemo.activity.LinearGradientActivity;
import view.viewdemo.activity.MATRIX_SAVE_FLAG_Activity;
import view.viewdemo.activity.PorterDuffXfermodeActivity;
import view.viewdemo.activity.RadialGradientActivity;
import view.viewdemo.activity.RegiononeActivity;
import view.viewdemo.activity.Rotatethepop_upActivity;
import view.viewdemo.activity.RotatingloadActivity;
import view.viewdemo.activity.SVGuseActivity;
import view.viewdemo.activity.ScaleAnimationOneActivity;
import view.viewdemo.activity.ScannerActivity;
import view.viewdemo.activity.ShadowoneLayerActivity;
import view.viewdemo.activity.ShapeInstanceActivity;
import view.viewdemo.activity.ShimmerTextActivity;
import view.viewdemo.activity.SimpleparabolicActivity;
import view.viewdemo.activity.SpiderActivity;
import view.viewdemo.activity.TelescopeActivity;
import view.viewdemo.activity.TelescopeoneActivity;
import view.viewdemo.activity.TextOneActivity;
import view.viewdemo.activity.TextViewDemooneActivity;
import view.viewdemo.activity.ThelettermailActivity;
import view.viewdemo.activity.ThephonerangthebellActivity;
import view.viewdemo.activity.ValueAnimatoroneActivity;
import view.viewdemo.activity.ViewAnimationOneActivity;
import view.viewdemo.activity.ViewAnimationtwoActivity;
import view.viewdemo.adapter.MainAdapter;


public class ViewMainActivity extends AppCompatActivity {



    RecyclerView recy;

    private List<String> recylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_main);
        recy = findViewById(R.id.recy);
        initDate();
        initview();
    }

    private void initDate() {
        recylist = new ArrayList<>();
        recylist.add("蜘蛛网状图");
        recylist.add("文字");
        recylist.add("区域");
        recylist.add("画布");
        recylist.add("圆形头像");
        recylist.add("会和动画效果");
        recylist.add("简单的视图动画效果1");
        recylist.add("简单的视图动画效果2");
        recylist.add("放射动画");
        recylist.add("属性动画1");
        recylist.add("弹跳动画");
        recylist.add("字母闪图动画");
        recylist.add("简单的抛物动画");
        recylist.add("简单的伸缩动画");
        recylist.add("简单的混合动画");
        recylist.add("旋转弹出动画");
        recylist.add("电话响铃动画");
        recylist.add("item入场动画");
        recylist.add("简单函数使用");
        recylist.add("旋转加载动画");
        recylist.add("支付宝支付成功动画");
        recylist.add("SVG应用");
        recylist.add("TextViewDemo1");
        recylist.add("贝济埃曲线");
        recylist.add("贝塞尔曲线之波浪");
        recylist.add("贝塞尔曲线之抛物线动画");
        recylist.add("阴影1");
        recylist.add("发光1");
        recylist.add("颜色填充");
        recylist.add("望远镜效果");
        recylist.add("不规则头像");
        recylist.add("线性颜色渐变");
        recylist.add("闪光文字");
        recylist.add("放射渐变");
        recylist.add("合并颜色");
        recylist.add("灯光效果");
        recylist.add("橡皮擦");
        recylist.add("画布操作1");
        recylist.add("画布操作2");
        recylist.add("shape测试1");
        recylist.add("放大镜效果");
        recylist.add("Draeable操作之圆角图片");
    }

    private void initview() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recy.setLayoutManager(manager);
        MainAdapter adapter = new MainAdapter(this,recylist);
        recy.setAdapter(adapter);
        adapter.SetItemOnclike(new MainAdapter.Onclike() {
            @Override
            public void textonclike(int position) {
                switch (position){
                    case 0:
                        //蜘蛛网状图
                        startActivity(new Intent(ViewMainActivity.this, SpiderActivity.class));
                        break;
                    case 1:
                        //文字
                        startActivity(new Intent(ViewMainActivity.this, TextOneActivity.class));
                        break;
                    case 2:
                        //区域
                        startActivity(new Intent(ViewMainActivity.this, RegiononeActivity.class));
                        break;
                    case 3:
                        //画布
                        startActivity(new Intent(ViewMainActivity.this, CanvasActivity.class));
                        break;
                    case 4:
                        //圆形图像
                        startActivity(new Intent(ViewMainActivity.this, CustomCircleActivity.class));
                        break;
                    case 5:
                        //会和动画效果
                        startActivity(new Intent(ViewMainActivity.this, CliprgnActivity.class));
                        break;
                    case 6:
                        //简单的视图动画效果1
                        startActivity(new Intent(ViewMainActivity.this, ViewAnimationOneActivity.class));
                        break;
                    case 7:
                        //简单的视图动画效果二
                        startActivity(new Intent(ViewMainActivity.this, ViewAnimationtwoActivity.class));
                        break;
                    case 8:
                        //放射动画
                        startActivity(new Intent(ViewMainActivity.this, ScannerActivity.class));
                        break;
                    case 9:
                        //属性动画1
                        startActivity(new Intent(ViewMainActivity.this, ValueAnimatoroneActivity.class));
                        break;
                    case 10:
                        //弹跳动画
                        startActivity(new Intent(ViewMainActivity.this, ImageValueanimtoroneActivity.class));
                        break;
                    case 11:
                        //字母闪图动画
                        startActivity(new Intent(ViewMainActivity.this, ThelettermailActivity.class));
                        break;
                    case 12:
                        //简单的抛物动画
                        startActivity(new Intent(ViewMainActivity.this, SimpleparabolicActivity.class));
                        break;
                    case 13:
                        //简单的缩放动画
                        startActivity(new Intent(ViewMainActivity.this, ScaleAnimationOneActivity.class));
                        break;
                    case 14:
                        //简单的混合动画1
                        startActivity(new Intent(ViewMainActivity.this, BlendAnimationOneActivity.class));
                        break;
                    case 15:
                        //旋转弹出动画
                        startActivity(new Intent(ViewMainActivity.this, Rotatethepop_upActivity.class));
                        break;
                    case 16:
                        //电话响铃动画
                        startActivity(new Intent(ViewMainActivity.this, ThephonerangthebellActivity.class));
                        break;
                    case 17:
                        //item入场动画
                        startActivity(new Intent(ViewMainActivity.this, ItemAnimatorActivity.class));
                        break;
                    case 18:
                        //简单的函数使用
                        startActivity(new Intent(ViewMainActivity.this, FunctiononeActivity.class));
                        break;
                    case 19:
                        //旋转加载动画
                        startActivity(new Intent(ViewMainActivity.this, RotatingloadActivity.class));
                        break;
                    case 20:
                        //支付宝支付动画
                        startActivity(new Intent(ViewMainActivity.this, AliPlayActivity.class));
                        break;
                    case 21:
                        //SVGz应用
                        startActivity(new Intent(ViewMainActivity.this, SVGuseActivity.class));
                        break;
                    case 22:
                        //TextViewDemo1
                        startActivity(new Intent(ViewMainActivity.this, TextViewDemooneActivity.class));
                        break;
                    case 23:
                        //贝济埃曲线（贝塞尔曲线）
                        startActivity(new Intent(ViewMainActivity.this, BezierActivity.class));
                        break;
                    case 24:
                        //贝塞尔曲线之波浪
                        startActivity(new Intent(ViewMainActivity.this, BezierTwoActivity.class));
                        break;
                    case 25:
                        //贝塞尔曲线之抛物线动画
                        startActivity(new Intent(ViewMainActivity.this, BezierThreeActivity.class));
                        break;
                    case 26:
                        //阴影1
                        startActivity(new Intent(ViewMainActivity.this, ShadowoneLayerActivity.class));
                        break;
                    case 27:
                        //发光
                        startActivity(new Intent(ViewMainActivity.this, BlurMaskFilterOneActivity.class));
                        break;
                    case 28:
                        //颜色填充
                        startActivity(new Intent(ViewMainActivity.this, BitmapShaderViewActivity.class));
                        break;
                    case 29:
                        //望远镜效果
                        startActivity(new Intent(ViewMainActivity.this, TelescopeActivity.class));
                        break;
                    case 30:
                        //不规则头像
                        startActivity(new Intent(ViewMainActivity.this, AvatorActivity.class));
                        break;
                    case 31:
                        //颜色渐变
                        startActivity(new Intent(ViewMainActivity.this, LinearGradientActivity.class));
                        break;
                    case 32:
                        //闪光文字
                        startActivity(new Intent(ViewMainActivity.this, ShimmerTextActivity.class));
                        break;
                    case 33:
                        //放射渐变
                        startActivity(new Intent(ViewMainActivity.this, RadialGradientActivity.class));
                        break;
                    case 34:
                        //合并颜色
                        startActivity(new Intent(ViewMainActivity.this, PorterDuffXfermodeActivity.class));
                        break;
                    case 35:
                        //灯光效果
                        startActivity(new Intent(ViewMainActivity.this, LightBookActivity.class));
                        break;
                    case 36:
                        //橡皮擦
                        startActivity(new Intent(ViewMainActivity.this, EraserActivity.class));
                        break;
                    case 37:
                        //画布操作
                        startActivity(new Intent(ViewMainActivity.this, MATRIX_SAVE_FLAG_Activity.class));
                        break;
                    case 38:
                        //画布操作
                        startActivity(new Intent(ViewMainActivity.this, CanvasTwoActivity.class));
                        break;
                    case 39:
                        //shape测试
                        startActivity(new Intent(ViewMainActivity.this, ShapeInstanceActivity.class));
                        break;
                    case 40:
                        //放大镜效果
                        startActivity(new Intent(ViewMainActivity.this, TelescopeoneActivity.class));
                        break;
                    case 41:
                        //Drawable操作之圆角图片
                        startActivity(new Intent(ViewMainActivity.this, CustomDrawableActivity.class));
                        break;
                }
            }
        });
    }
}
