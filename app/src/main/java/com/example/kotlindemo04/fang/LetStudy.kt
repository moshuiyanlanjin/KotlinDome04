package com.example.kotlindemo04.fang

inline fun <T,R> T.mLet(lambda:T.()->R):R = lambda(this)

fun main() {
    var name = "zhuli".mLet {
        println(this)
        12
    }
    println(name)
}

class LetStudy {

}