package com.example.kotlindemo04.RxJava.frou

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

class Helper<T>(var item:T)
fun <T,R> Helper<T>.map(mm:T.()->R) = Helper(mm(item))
fun <T> Helper<T>.consumer(mm: T.() -> Unit) = mm(item)
fun <R> create(mm:()->R) = Helper(mm())