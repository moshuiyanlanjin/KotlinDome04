package com.example.kotlindemo04.kotlin_lamdba

class Hoigher02 {
}

fun main() {
    // （int，int）->String这个应该是返回值类型声明吧
    // 考试：函数返回一个函数
    val fun4 = fun(n1aaa: Int, n2aaa: Int)  // fun4函数本身

            : (Int, Int) -> String // fun4函数的函数 以返回值返回了这个函数

            = { n1, n2 -> "两个数相加:${n1 + n2}  n1aaa:$n1aaa" } // fun4函数的函数 以返回值返回了这个函数 的 实现

    println(fun4(100, 100)(1000, 1000))

    val k01: (String) -> (String) -> (Boolean) -> (Int) -> (String) -> Int =
        { it: String ->
            { it: String ->
                { it: Boolean ->
                    { it: Int ->
                        { it: String ->
                            999
                        }
                    }
                }
            }
        }
    println(k01("aaa")("bbb")(true)(888)("Derry"))
}