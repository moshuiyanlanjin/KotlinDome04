package com.example.kotlindemo04.xiangyuan;

public class FlyWeiHtyPattern {

    public static void main(String[] args) {
        BikeFlyWeihty bike1 = BikeFlyWeihyFactory.getInstance().getBike();
        bike1.ride("张三");
        bike1.back();

        BikeFlyWeihty bike2 = BikeFlyWeihyFactory.getInstance().getBike();
        bike2.ride("张二");
        bike2.back();

        BikeFlyWeihty bike3 = BikeFlyWeihyFactory.getInstance().getBike();
        bike3.ride("张一");
        bike1.back();
    }
}
