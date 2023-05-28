package com.example.kotlindemo04.fang

import java.io.File

class ApplyStudy {
}

fun main() {
// TODO 官方的：
    // 错误的用法
    val r2 : File = File("D:\\a.txt").apply {
        /*this.*/readLines()
        'A'
        true // 无法以最后一行作为返回值
    }.apply {
        setWritable(true)
    }.apply {
        setReadable(true)
    }.apply {
        // ...
    }

    // 正确用法
    File("D:\\a.txt").apply {
        readLines()
    }.apply {
        setWritable(true)
    }.apply {
        setReadable(true)
    }.apply {
        // ...
    }

    // TODO 我们自己写的
    "Derry".myApply {
        ""
        true
        9
        println(this)
    }.myApply {  }.myApply {  }.myApply {  }

    val r1s : String  = "Derry".myApply {

    }.myApply {

    }.myApply {

    }

    val r2s: Int = 123.myApply {

    }

    val r3: Boolean = true.myApply {

    }.myApply {

    }
}
// 只要是高阶函数，必须用inline修饰，为什么，因为内部会做lambda优化
// I.mApply  万能类型.mApply  所以 所有的类型 都可以 .mApply
// lambda: I.()  对I泛型进行了匿名函数扩展  好处 lambda{}实现处 持有this == I == 调用者本身 == "Derry"
// : I 为了链式调用
//  lambda() 调用执行
inline fun <T> T.myApply(mm:T.()->Unit) : T {
    mm()
    return this
}