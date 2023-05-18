package com.example.kotlindemo04.kotlin_lamdba

class lambda1 {
}
fun main() : Unit {
    // Lambda会慢慢的难度升级

    // Kotlin Unit == Java void

    // TODO 下面全部都是函数声明， 既然是函数声明，就不能调用
    // 函数的声明 用lambda去描述函数的声明
    val method1 : () -> Unit

    val method2 : (Int, Int) -> Unit

    val method3: (String, Double) -> Any

    var method4 : (Int, Double, Long, String) -> Boolean

    var method5 : (Int, Int) -> Int

    // 函数的声明 + 函数的实现

    // : (参数)->返回  方式一 () 基本上属于声明 todo 上面已经讲过了 就是函数的声明

    // = {参数->方式}  方式二 () 基本上属于声明实现结合
    val method01 : () -> Unit = { println("我是method01函数") }
    method01() // 调用函数  () == 操作符重载 invoke操作符
    method01.invoke() // 调用函数

    val method02 = { "我是method02函数" }
    println(method02())

    val method03 = {str: String -> println("你传递进来的值是:$str")}
    method03("Derry")

    val method04 = {number1: Int, number2:Int -> number1.toString() + number2.toString()}
    println(method04(1, 2))

    val method05 = {number1: Int, number2:Int -> number1 + number2}
    println(method05(1, 2))

    val method06 : (Int) -> String // 先声明
    method06 = fun(value: Int) : String = value.toString() // 后实现
    println(method06(88))

    // 用 先声明 后实现 来 自动推断
    val method07 : (Int) -> String // 先声明
    method07 = fun(value) = value.toString() // 后实现
    println(method07(99))

    // 声明 + 实现 一气呵成
    val method08: (Int) -> String /*左边的是声明*/         /*右边是实现*/ = {value-> "$value aaa" }
    println(method08(77))

    val method09 : (String, String) -> Unit  = {aStr, bStr -> println("aStr:$aStr, bStr:$bStr") }
    method09.invoke("AA", "BB")

    val method10 : (String) -> Unit = { /*it ->*/ // 如果你只有一个参数的话，如果你不写，默认就有it，他会自动给你增加it
        println("你传递进来的值是:$it")
    }
    method10("李元霸")

    val method11 : (Int) -> Unit = {
        when(it) {
            1 -> println("你传递进来的是一") // Unit
            in 20..60 -> println("你传递的是 20 到 60 之内的数字") // Unit
            else -> println("都不满足") // Unit
        }
    }
    method11(60)

    val method11s : (Int) -> String = {
        when(it) {
            1 -> "你传递进来的是一" // String
            in 20..60 -> "你传递的是 20 到 60 之内的数字" // String
            else -> "都不满足" // String
        }
    }
    println(method11s(60))

    // _ 拒收，可以提高一点点性能
    val method13 : (Int, Int) -> Unit = {_, number2->
        println("你传递的第二个参数是：$number2")
    }
    method13.invoke(100, 200) // 用户对 不用修改
  //  method13(100,200)

    // (Any) -> Any
    val method14 : (Any) -> Any = {str: Any -> str}
    println(method14(true))
    println(method14(57.654f))

    // === 引用对象的比较    ==值的比较
    val method15 /*: (Char) -> Unit*/ =
        {sex : Char -> println(if (sex == '男') "你是男生" else if (sex == '女') "你是女生" else "未知") }
    method15.invoke('男')

    // (Int) -> Unit
    var method16 : (Int) -> Unit = {number: Int -> println("你的值是:$number")} // 被覆盖后，就失效了
    // 覆盖method16, 虽然你覆盖了，类型还是 (Int) -> Unit
    method16 = { println("覆盖的也能拿到值:$it") }
    method16(999)

    val method16ss : (String ? /*= ""*/, String) -> Unit = {str /*= "default"*/, str2->
        println("str:$str, str2:$str2")
    }
    method16ss("李元霸", "李连杰")
    method16ss(null, "李连杰")

    val method16sss = {str: String /*= "default"*/, str2: String ->
        println("str:$str, str2:$str2")
    }
    method16sss("李元霸", "李连杰")
    method16sss(/*null*/ "", "李连杰")

    // 需求：你传入什么，我就打印什么 并且输出
    // (Any) -> Any
    val method17 = {str: Any ->
        println("你传递了:$str")
        str // lambda最后一行作为返回值
    }
    println(method17(34534))
    println(method17('C'))
    println(method17("DDDD"))

    // 给String增加 匿名扩展函数
    // String.()  给String类，增加一个匿名函数 == 效果： 我们的 lambda体会持有String本身 == this
    val method19 : String.() -> Unit = {
        // this == String本身 == 调用者本身 == "DDD"
        println("你是$this")
    }
    "DDD".method19()

    val method20 : Int.(Int) -> String = { "两数相加的结果是:${this + it}" }
    println(1.method20(100))
    println(method20(1, 100))

    val method21 : Double.(Double, Double) -> Unit = {d1, d2 -> println("三数相加:${this + d1 + d2}")}
    method21.invoke(55.5, 66.6, 77.7)
    55.5.method21(66.6, 77.7)

    val method22 : Char.(String) -> Unit
            = { println(if (this == '男') "先生你好" else if (this == '女') "女生你好" else it)}
    '男'.method22("未知人类")
    'A'.method22("未知人类")

    fun Char.method23(default: String) {
        println(if (this == '男') "先生你好" else if (this == '女') "女生你好" else default) }
    '男'.method23("未知人类")
    'A'.method23("未知人类")

    // TODO 我们前面一直在玩输入，   现在我们开始玩输出（返回类型）
    fun t01() { println(1) } // 默认Unit，除非我们指定类型
    fun t02() {4646.5f} // 默认Unit
    fun t03() {true} // 默认Unit
    fun t04() : String {return "Derry"} // 指定String
    fun t05() : Int { return 99} // 指定Int，注意：在函数体里面 return xxx，是无法类型推到的， 还需要 :类型定义

    fun s01() /*: () -> Unit*/ = {} // () -> Unit    函数返回一个函数
    fun s02() /*: () -> Unit*/ = { println("OK") } // () -> Unit    函数返回一个函数
    s02()()

    // s03和s04都有入参的时候要怎么调用
    // run { 执行你的函数 的 返回值给 run函数的R  }
    fun s03() : Char = run { 'A' } // Char  run返回 {}里面的函数返回类型
    fun s04() : () -> Boolean = { true } // () -> Boolean 函数返回一个函数
    println(s03())
    println(s04()())

    // 意思 s01的括号是 函数返回 （）->unit      s03 是run 返回是run的返回值?  答： OK的

    // k01返回的是什么类型? 答：  函数返回一个函数   (Int) -> Unit
    fun k01() = {n1: Int -> println("你输入的类型是int?${if (n1 is Int) "你是Int类型 $n1" else "你不是Int类型"}")}
    k01()(89)

    // k02返回的是什么类型? 答：(Int, Int) -> Char
    fun k02() : (Int, Int) -> Char  = { n1: Int, n2:Int -> println("两数相加:${n1+n2}")
        true
        'A'
    }// 划重点，想写多行直接敲回车，为什么要换行：为了编译器检查

    // TODO 第二节课直播讲的内容，继续Lambda （以上节课基础 为根基的）
    val methodX1 : (String) -> Int = fun(str) : Int {
        return str.length // 不是我们之前学习的Lambda体{}, 这个是方法体了，需要写return
    }
    // 一般开发不会用 fun关键字 + 声明处

    val methodX2 = {str: String -> str.length}
    val methodX2s : (String) -> Int = { it.length }
    // 哪种写法比较通用点? = {str : String -> str.length} 因为可以偷懒

    // Function1<String, Int>  等价于  (String) -> Int
    val methodX3 : Function1<String, Int> = {str: String -> str.length}
    println(methodX3("Derry"))

    val methodX4 : Function2<Boolean, String, Unit> = {isOK: Boolean, str: String -> println("isOK:$isOK")}
    methodX4(true, "DerryOK")

    // 一般是 Lambda + 函数 == 高阶函数

    // fun aa{} 与 var aa2={}有啥区别?
    fun aa() {}
    val aa2 = {}
    // aa就是一个函数，实打实的函数
    // aa2是接收一个匿名函数的变量而已，这个变量 可以执行这个匿名函数
    // 共同点：他们的现象是一样的，所以有同学就纠结了
    val aa3 = aa2 // 都属于函数引用的概念
    val aa4 = ::aa // ::的含义 就是把这个实打实的函数，变成 函数引用 所以可以赋值传递 给另外一个变量

    // 前面为什么用val方法不应该是fun吗？
    // 我们一直在写匿名函数，把匿名函数给 val method01 变量
    // KT函数是一等公民

    // 全栈语言： 服务器，iOS，Android，Windows，JS，Gradle Groovy  build.gradle.kts ...
    // native层

    // 函数中的函数，就是高阶函数，   函数如果有Lambda就属于高阶函数

    // KT中的 基本上都是表达式 包括 if  可以灵活返回
    // Java中，基本上都是 语句 包括 if  执行体 不可以返回

    var a = if (true) 111 else 222
}

// TODO 新增点

fun show(name: String = "default") {} // 同学们注意：实打实的函数 才支撑 默认参数的，Lambda是不支持的哦

// public static  Kotlin默认是公开的public
// 给String增加 具名的shows扩展函数
fun String.shows() {
    // this == String本身 == 调用者本身 == "DDD"
    println("你是$this")
}

/*
fun Glide.show() {
    // this == Glide本身
}*/

/*
fun OkHttp.showInfo() {
    // this == OkHttp本身
}*/

// public static Object toast(Any toast$this) {...}
fun Any.toast() {
    // Any == this
    println("你个货调用了我，你的值是:$this")
}

// 扩展函数公式：你对xxx扩展  this==xxx本身

val val1: () -> Unit       =                 {}
// 函数声明                 =                 函数实现{}

fun func1() : Unit                          {}
// fun 函数声明                               函数实现{}


fun info() /*: Unit*/ : Int {
    return 99
}
// 目前：return没有开放 类型自动推断，以后可能会开放，目前还需要 :类型 才行