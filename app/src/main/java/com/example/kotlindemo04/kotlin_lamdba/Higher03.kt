package com.example.kotlindemo04.kotlin_lamdba

class Higher03 {
}

fun main() {
    loginEngine("111","222")
}

private fun loginEngine(userName: String,userPwd: String){
    loginCheck(userName,userPwd){userName,userPwd->
        if(userName == "111"&&userPwd == "222"){
            println("成功")
        }else{
            println("失败")
        }

    }
}

private fun loginCheck(userName:String,userPwd:String,checkResult:(String,String)->Unit){
    if(userName.isEmpty() || userPwd.isEmpty()){
        println("参数为空")
        return
    }
        //...可以设置多个条件
    checkResult(userName,userPwd)
}