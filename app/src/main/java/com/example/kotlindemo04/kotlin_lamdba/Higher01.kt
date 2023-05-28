package com.example.kotlindemo04.kotlin_lamdba

class Higher01 {

}

    fun main(){

        show01(1,{
            println(it)
            "$it"
        })

        show02(1,21,3,{it1,it2,it3 ->
            println(it1*it2*it3)

        })
    }

    fun show01(number:Int,lambda1: (Int)->String) :String = lambda1(number)

fun show02(number: Int,number1: Int,number3: Int,lambda1: (Int, Int, Int) -> Unit){
    lambda1(number,number1,number3)
}
