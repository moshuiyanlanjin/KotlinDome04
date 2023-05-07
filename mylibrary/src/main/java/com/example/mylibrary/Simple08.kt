package com.example.mylibrary

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// TODO 提供委托（provideDelegate）

class StringDelegateUpdate(var str: String = "Default") : ReadWriteProperty<Owner2, String> {

    override fun getValue(thisRef: Owner2, property: KProperty<*>): String {
        println("ReadWriteProperty getValue执行啦")
        return str
    }

    override fun setValue(thisRef: Owner2, property: KProperty<*>, value: String) {
        println("ReadWriteProperty setValue执行啦")
        str = value
    }

}

class SmartDelegator{
    operator fun provideDelegate(
        owner: Owner2,
        property: KProperty<*>
    ): ReadWriteProperty<Owner2,String> {
        return if (property.name.contains("aaa")){
            StringDelegateUpdate("bbb")
        } else {
            StringDelegateUpdate("aaa")
        }
    }


}

class Owner2 {
   // var aaa: String by StringDelegateUpdate("111")
    var aaa: String by SmartDelegator()
    var bbb: String by SmartDelegator()
}

class Simple08 {

}

fun main() {
    val owner = Owner2()
    println(owner.aaa)
    println(owner.bbb)
}