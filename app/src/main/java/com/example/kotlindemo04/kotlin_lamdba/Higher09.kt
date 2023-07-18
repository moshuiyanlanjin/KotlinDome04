package com.example.kotlindemo04.kotlin_lamdba
//studty01返回的是函数
fun studty01()/*:(String,Int)->Unit*/ = {name:String,age:Int->
    true
    name
    age
    "我的姓名是$name,年龄是$age"
}

fun studty02()/*:((Int,Int)->String,String)->Unit*/ = {lambd:(Int,Int)->String,str:String->
    false
    "张三"
    println("当前的值${lambd(110,200)},$str")
}

fun stydty03() /*:(String,Int,(String)->String,(Int)->Unit)->Unit*/= {str:String,age:Int,lambda1:(String)->String,lambda2:(Int)->Unit->
    lambda1(str)
    lambda2(age)
}

fun <T1,T2,R1,R2> studty04()/*:(T1,T2,(T1)->R1,(T2)->R2)->T1*/ = {str:T1,age:T2,lambda:(T1)->R1,lambda1:(T2)->R2 ->
//    str
//    age
    println("第一个lambda:${lambda(str)}${if(lambda(str) is Int)"你变换后是Int值：${lambda(str)}" else "你变换后不是INT值"}")
    println("第二个lamdba:${lambda1(age)}")
}

fun studty05():(String,Int,(Int)->String)->Boolean = fun(str:String,num:Int,lambda:(Int)->String):Boolean{
    str
    return false//fun{},此{}是函数体，不是lambda体 fun{}是函数本身，不会随着最后一行的类型变化而变化，必须明确指定类型，否则默认返回unit
}
fun main() {
        println(studty01()("李四",22))
        println(studty02()({a,b->
            "当前的值：${a+b}"
        },"王五"))
    println(stydty03()("张三",21,{
                               "名字：$it"
    },{
        println("年龄：$it")
    }))
    studty04<String,Int,Int,String>()(
        "王五",99,{
            "Ok$it".length
        }
    ){
        "第二个值：$it"
    }
}

class Higher09 {

}