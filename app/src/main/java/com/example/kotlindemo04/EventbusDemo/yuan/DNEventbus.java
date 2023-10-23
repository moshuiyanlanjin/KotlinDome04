package com.example.kotlindemo04.EventbusDemo.yuan;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DNEventbus {

    private static DNEventbus instance = new DNEventbus();

    private Map<Object, List<SubscribleMethod>> cacheMap;

    private Handler handler;

    //线程池
    private ExecutorService executorService;

    public static DNEventbus getDefault(){
        return instance;
    }

    public DNEventbus(){
        cacheMap = new HashMap<>();
        handler = new Handler(Looper.getMainLooper());
        executorService = Executors.newCachedThreadPool();

    }

    //注册
    public void register(Object subsriber){
        Class<?> aClass = subsriber.getClass();
        //获取缓存中当前注册类绑定的SubscribleMethod集合
        List<SubscribleMethod> subscribleMethods = cacheMap.get(subsriber);
        if(subscribleMethods == null){
            //如果当前注册类没有绑定SubscribleMethod集合，则
            subscribleMethods = getSubscribleMethods(subsriber);
            //添加到缓存
            cacheMap.put(subsriber,subscribleMethods);
        }
    }

    private List<SubscribleMethod> getSubscribleMethods(Object subsriber) {
        List<SubscribleMethod> list = new ArrayList<>();
        Class<?> aClass = subsriber.getClass();
        while (aClass != null){
            String name = aClass.getName();
            //如果是系统的方法则不执行
            if(name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")){
                break;
            }
            //拿到当前类的所有方法
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method method : declaredMethods){
                //判断当前方法是否有DNSubscribe注解
                DNSubscribe annotation = method.getAnnotation(DNSubscribe.class);
                if(annotation == null){
                    continue;
                }

                //获取包含注解的方法内的参数类型
                Class<?>[] parameterTypes = method.getParameterTypes();
                Log.d("当前的参数是：",parameterTypes[0].getSimpleName());
               if(parameterTypes.length != 1){
                   throw new RuntimeException("参数超限！");
               }
                //获取当前注解设置的线程
                DNThreadMode dnThreadMode = annotation.threadMode();
               //将信息封装到SubscribleMethod中
                SubscribleMethod subscribleMethod = new SubscribleMethod(method, dnThreadMode, parameterTypes[0]);
                //将subscribleMethod添加到集合中去
                list.add(subscribleMethod);
            }
            aClass = aClass.getSuperclass();
        }
        return list;
    }

    //注销
    public void unregister(Object subsriber){
        Class<?> aClass = subsriber.getClass();
        List<SubscribleMethod> subscribleMethods = cacheMap.get(subsriber);
        if(subscribleMethods != null){
            subscribleMethods.remove(subsriber);
        }
    }

    //
    public void post(final Object object){
        //拿到缓存中的所有的注册类集合，转化成Set集合（set集合可以自动去重）
        Set<Object> set = cacheMap.keySet();
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()){
            //拿到注册类
            final Object next = iterator.next();
            //获取注册类在map中绑定的SubscribleMethod集合
            List<SubscribleMethod> subscribleMethods = cacheMap.get(next);
            for (final SubscribleMethod s : subscribleMethods){
                //判断当前的方法是否应该接受事件
                if(s.getEventType().isAssignableFrom(object.getClass())){
                    //线程处理
                    switch (s.getThreadMode()){
                        //接受线程在主线程中
                        case MAIN:
                            //判断当前post方法所在线程是否是主线程
                            if(Looper.myLooper() == Looper.getMainLooper()){
                                invoke(s,next,object);
                            }else{
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        invoke(s,next,object);
                                    }
                                });
                            }
                            break;
                            //如果当前接收方法在子线程
                        case ASYNC:
                            if(Looper.myLooper() == Looper.getMainLooper()){
                                executorService.execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        invoke(s,next,object);
                                    }
                                });
                            }else{
                                invoke(s,next,object);
                            }
                            break;
                        case POSTING:

                            break;
                    }

                }
            }
        }
    }

    private void invoke(SubscribleMethod s, Object next, Object object) {
        Method method = s.getMethod();
        try {
            method.invoke(next,object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
