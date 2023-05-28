package com.example.kotlindemo04.kotlin_lamdba

import android.widget.Toast

class Higher05 {
}

fun main() {
    11.abc()
    "zhuli".myRunOk {
        println("myRunOk的it：$it")
        println("myRunOk的this：$this")
        true
    }
    "zhuli".myRunOk2 {
        println("myRunOk2的this：$this")
    }

    "zhuli".zhuli {
        println("zhuli的run测试")
    }

    "zhuli".zhuli2 {
        println("zhuli2的it：$it")
    }
    "zhuli".zhuli3 {
        println("zhuli3的it：$it")
        println("zhuli3的this：$this")
    }
    "zhuli".zhuli4 {
        println("zhuli4的it：$it")
        println("zhuli4的this：$this")
    }
    "zhuli".zhuli5 {
        println("zhuli5的it：$it")
    }
    "zhuli".run1 {
        println("run1的this：$this")
    }
    "zhuli".run2 {
        println("run2的it：$it")
    }
    "aaa".run3{t1:String,t2:String,t3:String,t4:String,t5:String,t6:String->
        println(this)
        println(t1)
        println(t2)
        println(t3)
        println(t4)
        println(t5)
    }
    "zhuli".showIntLen()
}

// public static
// 给泛型增加 具名abc扩展函数 【我对T扩展，T本身就等于==this】
fun <T> T.abc() {
    // this == T本身 == 调用者本身 ==  "Derry"
    println("abc我是:$this")
}
// 给泛型增加 匿名扩展函数  【我对T扩展，T本身就等于==this】
// 我对T扩展，T本身就等于==this
fun <T> T.myRunOk(mm:T.(Float)->Boolean){
    // this == T本身 == 调用者本身 ==  "zhuli"
    mm(321.4f)
}

fun <T> T.myRunOk2(mm:T.()->Unit){
    mm()
}

fun <T> T.zhuli(mm:()->Unit){
    mm()
}

fun <T> T.zhuli2(mm:(Double)->Unit){
    mm(45441.1)
}

fun <T> T.zhuli3(mm:String.(Double)->Unit){
    "李元霸".mm(111.1)
}

fun <T> T.zhuli4(mm:T.(Double)->Unit){
    // this == T本身 == this 123/A

    // this.mm(152.52) // 这个才是他的真身
    mm(152.52)
}

fun <T> T.zhuli5(mm: (T) -> Unit){
    // this == T本身 == this 调用者
    mm(this)
}

// T.()的this,  和  (T)的 it有什么区别?
// T.() { 持有this == T本身 }
// (T) { 持有it == T本身 }
// (Double) { 持有it == Double本身 }

// 公式：我对xxx扩展， lambda实现{ 持有 xxx本身 }

fun <T> T.run1(mm:T.()->Unit) = this.mm()
fun <T> T.run2(mm:(T)->Unit) = mm(this)

// T.()    this == T本身 ----> lambda { 持有this }
// (T)     it == T本身 ----> lambda { 持有it }

// T.(Float)括号里的float怎么理解呢  ----> lambda { 持有this == T    持有it == Float}
// T.(T) 怎么理解呢  ----> lambda { 持有this == T    持有it == T}

fun <T> T.run3(mm:T.(T,T,T,T,T,T)->Unit) = this.mm(this,this,this,this,this,this)
// T.run3 函数本身 会持有this == T

// public static void showIntLen(Kotlin编译期生成 this$String) { ... }
fun String.showIntLen(){
    // this == String == 调用者本身
    println("你的内容是:$this 你的长度是:${this.length}")
}

fun <T> T.toast() = Toast.makeText(null, this.toString(), Toast.LENGTH_LONG).show()

// run1和mm的区别是什么？   mm就是lambda   run1是泛型的函数扩展而已

// T.() 会给我们的 mm的lambda   就会产生  lambda实现体里面持有this == T本身 == 123.T 所以this等于123
// (T)                                 lambda实现体里面持有it == T本身 == 123.T 所以this等于123