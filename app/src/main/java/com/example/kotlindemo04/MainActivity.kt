package com.example.kotlindemo04

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.kotlindemo04.ui.BaseActivity


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("zlc","111")

    }
}
