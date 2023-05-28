package com.example.kotlindemo04.RxJava.two

class RxjavaKt {
}

fun main() {
    create { // 没有输入，意味着，没有it 没有this
        "Derry"
        64654
        6546.65
        'A'
        6466.5f // 最后一行作为输出  输出给下一个环节 map
    }.map {
        123
    }.map {
        true
    }.map {
        65466.6
    }.consumer {
        println("消费:$this") // 没有输出，为什么，因为直接消费就完成了
    }

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

    create {
        "DDD"
    }.map {  // 隐式的this，可以省略，   但是 it不可以做到
        length
    }
}

class Helper<T>(var item:T){

    fun <R> map(mm:T.()->R):Helper<R>{
        return Helper(mm(item))
    }

    fun consumer(mm:T.()->Unit){
        mm(item)
    }
}

fun <R> create(mm:()->R):Helper<R>{
    var r = mm()
    return Helper(r)
}