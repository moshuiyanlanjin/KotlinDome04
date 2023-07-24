package com.example.kotlindemo04.dsl

class Sub{
    fun action1(){}
    fun action2(){}
    fun action3(){}
    fun action(string: String){}
    fun category(string: String){}
}

class IntentFilter{
    inline fun intent_filter(lambda:Sub.()->Unit):Sub{
        val sub = Sub()
        sub.lambda()
        return sub
    }
}

class Component{
    inline fun activity(string: String,lambda:IntentFilter.()->Unit):IntentFilter{
        val intentFilter = IntentFilter()
        intentFilter.lambda()
        return intentFilter
    }
    inline fun service(string: String,lambda:IntentFilter.()->Unit):IntentFilter{
        val intentFilter = IntentFilter()
        intentFilter.lambda()
        return intentFilter
    }
    inline fun receiver(string: String,lambda:IntentFilter.()->Unit):IntentFilter{
        val intentFilter = IntentFilter()
        intentFilter.lambda()
        return intentFilter
    }
    inline fun provider(string: String,lambda:IntentFilter.()->Unit):IntentFilter{
        val intentFilter = IntentFilter()
        intentFilter.lambda()
        return intentFilter
    }
}

class Manifest{
    fun pkg(string: String){}
    fun permission(string: String){}
    inline fun application(lambda:Component.()->Unit):Component{
        val component = Component()
        component.lambda()
        return component
    }
}

inline fun manifest(lambda:Manifest.()->Unit):Manifest{
    val manifest = Manifest()
    manifest.lambda()
    return manifest
}

fun main() {
    // TODO 模拟AndroidManifest.xml的解析
    manifest { // { 持有this == 中转站1（pkg， permission，application） }

        // 因为this可以省略
        // TODO 这里面所有的代码，都是this点出来的，只是你看不到，隐式的， 所有必须 中转站.() 持有this     而不是 (中转站) 持有it

        pkg("com.derry.kt_base") // 包名
        permission("android.permission.INTERNET") // 权限

        // 四大组件
        application { // { 持有this == 中转站2（四大组件 Activity Service ...） }

            activity(".MainActivity") { // { 持有this == 中转站3（intent_filter） }
                intent_filter { // { 持有this == 中转站4（action category） }
                    action1()
                    action2()
                    action3()
                    action("android.intent.action.MAIN")
                    category("android.intent.category.LAUNCHER")
                }
            }

            service(".MyService") { // { 持有this == 中转站3（intent_filter） }
                intent_filter {

                }
            }

            receiver(".MyCustomReceiver") { // { 持有this == 中转站3（intent_filter） }
                intent_filter {

                }
            }

            provider(".MyCustomReceiver") { // { 持有this == 中转站3（intent_filter） }
                intent_filter {

                }
            }
        }
    }
}

class DSLSTUDY02 {
}