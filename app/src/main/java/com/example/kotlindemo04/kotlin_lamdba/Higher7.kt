package com.example.kotlindemo04.kotlin_lamdba

class Higher7 {
}
fun main() {
    // TODO 2 以前的做法(匿名函数体)，规则 输入为整形，输出为字符串
    showAction {
        "我的值是:$it"
    }

    // TODO 3 一般源码的做法(具名函数，可以随意传递)
    showAction(::lambdaImpl)

    // TODO 5 :: 把这个函数变成函数引用，就可以传递赋值给变量了    Function 到 (Int) 到 Int.()  最后把变量给高阶函数执行
    val r1 : Function1<Int, String> = ::lambdaImpl
    val r2 : (Int) -> String = r1 // it
    val r3 : Int.() -> String = r2 // Int.() 等价于 (Int)    Int.()  Int.属于来源，会自动把来源作为第一个参数   this

    // Int.() -> String  等价于  (Int) -> String    最终还是this  不要把 it 和 this 拿过来想

    // Int.(String) -> Unit 是两个输入参数的？  等价于  (Int, String) -> Unit

    showAction(r3)
}
// TODO 4 一般源码的做法(具名函数，可以随意传递) 【写一个函数，输入为整形，输出为字符串】
fun lambdaImpl(value: Int) : String = "我的值是:$value"

// TODO 1 写一个高阶函数，lambda 输入为整形，输出为字符串，然后打印lamdba
fun showAction(action: (Int) -> String) {
    println(action(88)) // 调用 打印Lambda
}