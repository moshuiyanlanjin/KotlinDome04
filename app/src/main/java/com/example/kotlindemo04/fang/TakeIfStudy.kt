package com.example.kotlindemo04.fang

inline fun <I> I.myTakeIf(lambda:(I)->Boolean) :I?= if(lambda(this)) this else null

/**
 * crossinline:这个lambda不要内联优化，否则是复制整个线程
 */
private inline fun myThread(start:Boolean = true,name:String? = null,crossinline runAction:() -> Unit){
    var thread = object :Thread(){
        override fun run() {
            super.run()
            runAction()
        }
    }
    if (start) thread.start()
    name?.let { thread.name = it }
}

fun main() {
    var i = "111".myTakeIf {
        println(it)
        false
    }
    println(i)
    myThread {
        println("当前的线程：${Thread.currentThread().name}")
    }
}
class TakeIfStudy {
}