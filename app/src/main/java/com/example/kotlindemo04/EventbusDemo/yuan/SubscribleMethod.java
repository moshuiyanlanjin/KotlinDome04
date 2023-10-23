package com.example.kotlindemo04.EventbusDemo.yuan;

import java.lang.reflect.Method;

/**
 * 注册类中的注册方法信息
 */
public class SubscribleMethod {
    //注册的方法
    private Method method;
    //线程的类型
    private DNThreadMode threadMode;
    //参数的类型
    private Class<?> eventType;

    public SubscribleMethod(Method method, DNThreadMode threadMode, Class<?> eventType) {
        this.method = method;
        this.threadMode = threadMode;
        this.eventType = eventType;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public DNThreadMode getThreadMode() {
        return threadMode;
    }

    public void setThreadMode(DNThreadMode threadMode) {
        this.threadMode = threadMode;
    }

    public Class<?> getEventType() {
        return eventType;
    }

    public void setEventType(Class<?> eventType) {
        this.eventType = eventType;
    }
}
