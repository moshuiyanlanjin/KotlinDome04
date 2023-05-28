package com.example.kotlindemo04.RxJava.three

class RxjavaKt {
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
    }.consumer {
        println("消费:$this")
    }
}
class Helper<T>(var item:T){
    fun<R> map(mm:T.()->R) = Helper(item)
    fun consumer(mm:T.()->Unit) = mm(item)
}

fun <R> create(mm:()->R) = Helper(mm())