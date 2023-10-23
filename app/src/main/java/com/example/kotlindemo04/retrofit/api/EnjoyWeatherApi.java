package com.example.kotlindemo04.retrofit.api;


import com.lf.javademo.retrofit.retrofit.annotation.Field;
import com.lf.javademo.retrofit.retrofit.annotation.GET;
import com.lf.javademo.retrofit.retrofit.annotation.POST;
import com.lf.javademo.retrofit.retrofit.annotation.Query;

import okhttp3.Call;


public interface EnjoyWeatherApi {

    @POST("/v3/weather/weatherInfo")
    Call postWeather(@Field("city") String city, @Field("key") String key);


    @GET("/v3/weather/weatherInfo")
    Call getWeather(@Query("city") String city, @Query("key") String key);
}
