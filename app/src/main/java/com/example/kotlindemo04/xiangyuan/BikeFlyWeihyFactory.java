package com.example.kotlindemo04.xiangyuan;

import java.util.HashSet;
import java.util.Set;

public class BikeFlyWeihyFactory {

    private static BikeFlyWeihyFactory instance = new BikeFlyWeihyFactory();
    private Set<BikeFlyWeihty> pole = new HashSet<>();

    public static BikeFlyWeihyFactory getInstance(){
        return instance;
    }

    private BikeFlyWeihyFactory(){
        for (int i = 0; i < 2; i++) {
            pole.add(new MyBikeFlyWeihy(i + ""));
        }
    }

    public BikeFlyWeihty getBike(){
        for (BikeFlyWeihty bikeFlyWeihty : pole){
            if (bikeFlyWeihty.state == 0){
                return bikeFlyWeihty;
            }
        }
        return null;
    }
}
