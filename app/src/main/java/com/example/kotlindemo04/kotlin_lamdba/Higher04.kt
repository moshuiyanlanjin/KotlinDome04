package com.example.kotlindemo04.kotlin_lamdba

class Higher04 {
}

fun main() {

    loginEngine("111","222"){
        if(it){
            println("成功")
        }else{
            println("失败")
        }
    }
}

fun loginEngine(userName:String,userPwe:String,responseResult:(Boolean)->Unit){
    //...可以制定无数规则
    if(userName == "111" && userPwe == "222"){
        responseResult(true)
    }else{
        responseResult(false)
    }
}