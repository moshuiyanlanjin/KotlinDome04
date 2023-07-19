package com.example.kotlindemo04.fang

inline fun myRepeat(conut:Int,lambda:(Int)->Unit){
    for (item in 0 until conut){ lambda(item)}
}
inline fun  Int.myRepeat1(lambda: (Int) -> Unit){
    for (item in 0 until this){ lambda(item)}
}
fun main() {
    myRepeat(10){
        println(it)
    }
    20.myRepeat1{
        println(it)
    }
}
class repeatStudy {
}