package com.example.kotlindemo04.AOP.AopFun;


import android.content.Context;
import android.util.Log;

import com.lf.javademo.AOP.PermissionRequestActivity;
import com.lf.javademo.AOP.annotation.PermissionMeed;
import com.lf.javademo.AOP.annotation.onPermissionDenied;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



//添加@Aspect，表示这是一个切面类
@Aspect
public class PermissionAsecpt {

    //定义切入点
    //MethodSignature -- @注解 访问权限（如public，private...没有可以不写） 返回值类型（没有可以写*） 类名.函数名（没有可以写*）（参数（不限定..））
    //如果没有注解
    //@Pointcut("execution(private * AOP.AopMain.reluestioncation(..)) ")
    @Pointcut("execution(@com.lf.javademo.AOP.annotation.PermissionMeed * *(..)) && @annotation(permissionMeed)")
    public void requestperMission(PermissionMeed permissionMeed){
        Log.d("进入切入点" ,"....");
    }

    //定义通知方法
    //也可以将上方的requestperMission方法注释掉直接：@Around(execution(@AOP.annotation.PermissionMeed * * (..)) && @annotation(permissionMeed))
    @Around("requestperMission(permissionMeed)")
    public void aroundJoinPoint(final ProceedingJoinPoint proceedingJoinPoint, PermissionMeed permissionMeed){
        Log.d("我执行到这里了：","....");
        final Object o = proceedingJoinPoint.getThis();
        Context context = (Context)o;

        if(context == null && permissionMeed == null){
            Log.d("当前的参数为空","....");
            return;
        }

        //申请权限
        PermissionRequestActivity.startPermissionRequest(context, permissionMeed.value(), permissionMeed.requestCode(), new IperMission() {
            @Override
            public void onPermissionGranted() {
                try {
                    //执行切入点的方法
                    proceedingJoinPoint.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }

            @Override
            public void onPermissionDenied(int requestCode) {
                //因为这里可能是个普通类，所以不能使用context只能用object
                invokAnnotation(o, onPermissionDenied.class,requestCode);
            }

            @Override
            public void onPermissionCanceled(int requestCode) {

            }
        });
    }

    //反射
    private void invokAnnotation(Object object,Class annotionClass,int requestCode){
        //获取切面上下文的类型
        Class<?> aClass = object.getClass();
        //获取类型中的方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method m: declaredMethods){
            Log.d("方法名是：",m.getName());
            //获取该方法是否有annotionClass注解
            boolean annotationPresent = m.isAnnotationPresent(annotionClass);
            if(annotationPresent){
                //判断是否仅有一个参数
                Class<?>[] parameterTypes = m.getParameterTypes();
                if(parameterTypes.length != 1){
                    throw new RuntimeException("需有且仅有一个参数");
                }
                m.setAccessible(true);

                try {
                    m.invoke(object,requestCode);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
