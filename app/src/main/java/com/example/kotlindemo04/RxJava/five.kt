package com.example.kotlindemo04.RxJava

class five {
}

fun main() {
    create {
        "Derry"
    }.map {
        length
    }.map {
        "内容的长度是:$this"
    }.map {
        "【$this】"
    }.consumer { // 不需要返回，直接消费，就不需要 R，所以是 Unit
        println("消费:$this")
    }
}

fun <R> create(mm:()->R):R = mm()
fun <T,R> T.map(mm:T.()->R) = mm(this)
fun <T> T.consumer(mm: T.() -> Unit) = mm(this)