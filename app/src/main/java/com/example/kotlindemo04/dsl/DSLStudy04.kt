package com.example.kotlindemo04.dsl

fun <T> T.button1(action: () -> Unit) : Unit { }
fun <T> T.text1(action: () -> Unit) : Unit { }

// 他给 （任何类型，所有的类型），都增加 button  text 的 扩展函数

// fun layout(action: Any?.() -> Unit) : Unit { }
// fun layout(action: Double.() -> Unit) : Unit { }
fun layout1(action: Int.() -> Unit) : Unit { } // Unit （button  text）

// 扩展函数传递的特性

fun main() {
    val r :Unit = layout1 {
        // this == Int == Int 都增加 button  text 的 扩展函数

        // 下面的代码，为什么可以点出来， Unit也能点
        button {  }.text1 {  }.button1 {  }
        text {  }.button1 {  }.text {  }

    }.button1 {  }.text1 {  }.button {  }

    // Unit也能点
    r.button {  }
    r.text {  }
}
class DSLStudy04 {
}