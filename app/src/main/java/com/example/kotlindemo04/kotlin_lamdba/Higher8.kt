package com.example.kotlindemo04.kotlin_lamdba

class Higher8 {
}

// TODO 模拟安卓点击事件
class AndroidClickListener<T> {

    // 定义集合1 元素类型为 Lambda 输入泛型? 输出无
    private val actions = arrayListOf< (T ?) -> Unit >() // 每一个元素 都是事件  (T ?) -> Unit

    // 定义集合2 元素类型为 泛型?
    private val values = arrayListOf<T ?>() // 每一个元素 都是 事件需要的数据

    // (T)   it
    // T.()  this

    // 定义addListener 参数1 是集合2的元素，  参数2 是集合1的元素， 方法内保存两个元素
    fun addListener(value: T?, action: (T ?) -> Unit) {
        actions += action // add 添加用户自定义的事件 到 集合
        values += value   // add 添加用户自定义的数据 到 集合
    }

    // 定义 模拟点击事件 点击 touchListeners，先判断集合1 有没有事件，在执行集合1里面所有元素
    fun touchListeners() {
        if (actions.isEmpty()) {
            println("你还没有添加任何事件呀")
            return
        }

        actions.forEachIndexed { index : Int, action : (T ?) -> Unit ->
            action.invoke(values[index]) // 执行所有元素 == lambda规则 == 用户自定义事件体
        }
    }
}

fun main() {
    // 模拟安卓点击事件
    val func = AndroidClickListener<String>()
    func.touchListeners() // 在没有添加任何事件的时候，触发点击事件看看，相当于点击button

    // 匿名函数作为事件
    func.addListener("Derry1") {
        println("事件被触发了 执行了 值是:$it")
    }

    func.addListener("Derry2") {
        println("事件被触发了 执行了 值是:$it")
    }

    func.addListener("Derry3") {
        println("事件被触发了 执行了 值是:$it")
    }

    // 触发事件
    func.touchListeners()

    println()

    // 具名函数作为事件
    func.addListener("Derry4", ::show1)

    // 具名函数事件随意传递
    val result : (Any ?) -> Unit = ::show1
    func.addListener("Derry5", result)

    val result2 : (Any ?) -> Unit = {
        println("result2 事件被触发了 执行了 值是:$it")
    }
    func.addListener("Derry6", result2)

    // 触发事件
    func.touchListeners()

    // Lambda 不支持泛型 ，用Any代替，  Lambda不支持 默认参数

    val v1 = ::a // 把a函数 实打实的函数，变成函数引用 ::
}

// 定义具名函数作为事件
// action: (T ?) -> Unit
fun <T> show1(value : T ?) : Unit {
    println("show1 事件被触发了 执行了 值是:$value")
}

fun a() {}