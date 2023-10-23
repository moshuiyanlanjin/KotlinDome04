package com.example.kotlindemo04.xiangyuan;

abstract class BikeFlyWeihty {
    //内部状态
    protected Integer state = 0;

    //外部链接
    abstract void ride(String username);

    abstract void back();

    public Integer getState(){
        return state;
    }
}
