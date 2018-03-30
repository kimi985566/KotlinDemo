package chapter2

//val： 值类型，不可重复赋值,运行时常量，不像Java会变成编译期常量
//如果kotlin需要实现编译期常量就需要在val前加上const就可以实现了
const val FINAL_HELLO_WORD: String = "Hello world";
//var:变量
var hello: String = "Hello"
//类型推到
val HELLO_CHINA = "HelloChina"

/**
 *
 * 函数：以特定功能组织起来的代码块
 * - fun[函数名]([列表参数]):[返回值类型]{[函数体]}
 * - fun[函数名]([参数列表])=[表达式]
 *
 * 功能要单一
 * 命名要做到顾名思义
 * 参数不要太多
 *
 * */
fun main(args: Array<String>) {
    println(hello)
    println(HELLO_CHINA)
    val a = 1
    val b = 2
    println(sum(a, b))
    printHello
}

//普通函数
//fun sum(arg1: Int, arg2: Int) = arg1 + arg2

/**
 *
 * Lambda表达式
 * 匿名函数
 *
 * 写法：{[参数列表]->[函数体，最后一行是表达式]}
 *
 * 用()调用
 * 相当于使用invoke
 *
 * 函数调用时最后一个Lambda可以移出去
 * 函数参数只有一个Lambda,小括号可以省略
 * Lambda只有一个参数时可默认为it
 * 入参、返回值与形参一致的函数可以用函数引用的方式做为实参传入
 * */
// (Int, Int) -> Int
val sum = { arg1: Int, arg2: Int ->
    println("$arg1 + $arg2 = ${arg1 + arg2}")
    arg1 + arg2
}

val printHello = { print("hello") }