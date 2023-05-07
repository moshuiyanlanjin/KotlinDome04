package com.example.kotlindemo04

import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.derry.asdelegate.R
import com.example.kotlindemo04.ui.BaseActivity
import com.example.kotlindemo04.vm.MainViewModel
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

operator fun TextView.provideDelegate(any: Any?,property:KProperty<*>) =
    object : ReadWriteProperty<Any?,String?>{
        override fun getValue(thisRef: Any?, property: KProperty<*>): String? = text as String?

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
            text = value
        }

    }

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView = findViewById<TextView>(R.id.tv)

        var messsage:String? by textView

        textView.text = "修改布局"

        println("message:$messsage")

        messsage = "数据发送改变"

        println("textView${textView.text}")

        val mainViewModel:MainViewModel by viewMoldels()
        println(mainViewModel.value)
        mainViewModel.value = "AA"
        println(mainViewModel.value)
    }

    private fun MainActivity.viewMoldels() : ReadOnlyProperty<MainActivity?,MainViewModel> =
        object :ReadOnlyProperty<MainActivity?,MainViewModel>{
            override fun getValue(thisRef: MainActivity?, property: KProperty<*>): MainViewModel {
                return ViewModelProvider(this@MainActivity).get(MainViewModel::class.java)
            }

        }
}
