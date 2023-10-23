package com.example.kotlindemo04.xiangyuan;

public class MyBikeFlyWeihy extends BikeFlyWeihty {

    //定义新的内部状态，车型号
    private String bikeId;

    MyBikeFlyWeihy(String bikeId){
        this.bikeId = bikeId;
    }

    @Override
    void ride(String username) {
        state = 1;
        System.out.println(username + "骑" + bikeId + "号自行车");
    }

    @Override
    void back() {
        state = 0;
    }
}
