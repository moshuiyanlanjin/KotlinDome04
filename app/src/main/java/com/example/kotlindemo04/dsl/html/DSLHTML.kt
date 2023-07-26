package com.example.kotlindemo04.dsl.html

import java.io.File

// 面向对象思维 设计 类的关系（依赖倒置原则） 面向抽象 而 不面向细节 ,  面向高层 不 面向具体
private interface Element{
    /**
     * builder:拼接所有的元素
     * indent html所有文本的缩进
     */
    fun run(builder:StringBuilder,indent:String)
}
// 从最简单的开始  <html> <head> 拼接这样的细节 是最简单
private class TextElement(val text:String):Element{// 文本Element，独立的字符串
    override fun run(builder: StringBuilder, indent: String) {
        builder.append("$indent$text\n")//缩进后显示文本内容换行
    }
}

// 复杂的逻辑 <html> <head> 拼接 这种具体详情
private open  class Tag(val tagName:String):Element{
    val elements = arrayListOf<Element>()//集合，每一个元素都是Element
    val attributes = hashMapOf<String,String>()//Map
    override fun run(builder: StringBuilder, indent: String) {
       builder.append("$indent<$tagName${rendrAttributes()}>\n")

        for (element in elements){
            element.run(builder, indent+"   ")
        }
        builder.append("$indent</$tagName>\n")
    }

    private fun rendrAttributes():String?{
        val builder = StringBuilder()
        for (key in attributes.keys){
            builder.append(" $key=\"${attributes[key]}\"")
        }
        return builder.toString()
    }

    override fun toString(): String {
        val builder = StringBuilder()
        run(builder,"")
        return builder.toString()
    }
}
// 解决 +"AAAA"  -"BBBB"  运算符重载的 扩展一层类， Tag的子类 拥有最丰富的功能
private open class TagClass(tagName: String):Tag(tagName = tagName){
    operator fun String.unaryPlus(){// 运算符重载+
        elements+=TextElement(this)//this == 使用kotlin进修班HTML编码
    }

    operator fun String.unaryMinus(){// 运算符重载-
        elements+=TextElement(this)// this == "此格式可用作 HTML 的替代标记"
    }
}

private class Title:Head("title")
private class H1:Body("h1")
private class P:Body("p")
private class A:Body("a"){
    var href:String
        get() = attributes["href"]!!
        set(value) {
            attributes["href"] = value
        }
}
private class B:Body("b")
private class UL:Body("ul"){
    fun li(lambda: LI.() -> Unit) {
        val li = LI()
        li.lambda()
        elements += li
    }
}
private class LI:Body("li")


private open class Head(classNamee:String):TagClass(classNamee){
    fun title(lambda:Title.()->Unit){
        val title = Title()
        title.lambda()
        elements += title
    }
}

private open class Body(classNamee: String):TagClass(classNamee){
    fun h1(lambda: H1.() -> Unit){
        val h1 = H1()
        h1.lambda()
        elements += h1
    }
    fun p(lambda: P.() -> Unit){
        val p = P()
        p.lambda()
        elements += p
    }
    fun a(href:String,lambda: A.() -> Unit){
        val a = A()
        a.href = href
        a.lambda()
        elements += a
    }

    fun b(lambda: B.() -> Unit){
        val b = B()
        b.lambda()
        elements += b
    }

    fun ul(lambda: UL.() -> Unit){
        val ul = UL()
        ul.lambda()
        elements += ul
    }
}

private class HTML:TagClass("html"){
    fun head(head:Head.()->Unit){
        val headobj = Head("head")
        headobj.head()
        elements += headobj
    }

    fun body(lambda:Body.()->Unit){
        val body = Body("body")
        body.lambda()
        elements += body
    }
}

private fun html(html:HTML.()->Unit):HTML{
    val htmlobj = HTML()
    htmlobj.html()
    return htmlobj

}

fun main() {

    // Domain Special Language 领域特定语言  比较成功的DSL语言有：JSON，Gradle，anko 等
    // 而今天我们要手写自己的，领域特定语言（专门生成解析 HTML 生成 HTML文本，语言规则 HTML的规则）
    // 根据下面的代码，运行后，会生成一个网页，相当于 我们自己定义语言规则

    val names = listOf("Derry1", "Derry2", "Derry3") // 集合

    val result =
        html {
            +"使用 Kotlin 进行 HTML 编码"

            // this == 第一个中转站 HTML类 {head，body。。。}
            head {
                // this == 第二个中转站 Head类 {title。。。}
                title { +"使用 Kotlin 进行 HTML 编码" }
            }
            body {
                // this == 第三个中转站 Body类 {h1，p，a。。。}
                h1 {
                    // this == h1中转站 { 未知 }
                }
                // h2 h3 h4 h5 h1000 h99999

                p { -"此格式可用作 HTML 的替代标记" }

                // 具有属性和文本内容的元素
                a(href = "http://bbs.xiangxueketang.cn/pins/recommended") { -"享学论坛" }

                // 混合内容
                p {
                    -"Derry老师来了"
                    b { -"Derry是谁" }
                    -"文本。有关更多信息，请参阅"
                    a(href = "http://www.xiangxueketang.cn/") { -"湖南享学" }
                    -"Derry的项目"
                }
                p { -"一些文字" }

                // 从命令行参数生成的内容
                p {
                    -"命令行参数是："
                    ul {
                        // this == UL中转站 { li 子标签  }
                        for (name in names)
                            li { -name } // this == LI中转站
                    }
                }
            }
        }
    println(result.toString())

    val file = File("DerryHtml.html")
    file.writeText(result.toString())

    // 老师能讲一下lamada中转站原理么？
    /*
        head { // 持有this == 中转站{aaa bbb ccc}
            aaa {}

            bbb {}

            ccc {}
        }

     */
}

class DSLHTML {
}