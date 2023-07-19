package com.example.kotlindemo04.dsl


class Helper(){}//中转站
inline fun layout(lambda:Helper.()->Unit){

}
inline fun Helper.text(lambda:()->Unit){

}
inline fun Helper.button(lambda:()->Unit){

}

fun main() {
    layout{
        button{

        }
        text{

        }
    }
}

class DSLStudy01 {
}