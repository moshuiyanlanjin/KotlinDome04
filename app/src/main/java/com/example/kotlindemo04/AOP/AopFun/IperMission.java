package com.example.kotlindemo04.AOP.AopFun;

public interface IperMission {

    //同意授权
    void onPermissionGranted();

    //拒绝授权且不在提示
    void onPermissionDenied(int requestCode);

    //取消权限
    void onPermissionCanceled(int requestCode);
}
