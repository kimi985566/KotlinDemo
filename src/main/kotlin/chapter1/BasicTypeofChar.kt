package chapter1

val aChar: Char = '0'
val bChar: Char = '中'
val cChar: Char = '\u000f'

/**
 *
 * \t 制表符
 * \b 光标后退一个字符
 * \n 回车
 * \r 光标回到行首
 * \' 单引号
 * \" 双引号
 * \\ 反斜杠
 * \$ 美元符号
 *
 *
 * Kotlin不可隐式转换
 * */

fun main(args: Array<String>) {
    println(aChar)
    println(bChar)
    println(cChar)
}