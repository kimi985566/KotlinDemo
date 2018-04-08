package chapter4.currying

import java.io.OutputStream
import java.nio.charset.Charset


/**
 *
 * currying
 *
 * 简单的说就是多元函数变换成一元函数调用链
 *
 *
 * 偏函数
 *
 * 传入部分函数得到的新函数
 *
 *
 * Kotlin中双冒号操作符表示把一个方法当做一个参数，传递到另一个方法中进行使用，
 * 通俗的来讲就是引用一个方法。
 *
 * 为了防止作用域混淆 ， :: 调用的函数如果是类的成员函数或者是扩展函数，必须使用限定符,
 * 比如this
 * */

fun log(tag: String, target: OutputStream, message: Any?) {
    target.write("[$tag] $message\n".toByteArray())
}

//fun log(tag: String)
//    = fun(target: OutputStream)
//    = fun(message: Any?)
//    = target.write("[$tag] $message\n".toByteArray())

fun main(args: Array<String>) {
    log("benny", System.out, "HelloWorld")
//    log("benny")(System.out)("HelloWorld Again.")
    ::log.curried()("benny")(System.out)("HelloWorld Again.")

    val consoleLogWithTag = (::log.curried())("benny")(System.out)
    consoleLogWithTag("HelloAgain Again.")
    consoleLogWithTag("HelloAgain Again.")
    consoleLogWithTag("HelloAgain Again.")
    consoleLogWithTag("HelloAgain Again.")

    val bytes = "我是中国人".toByteArray(charset("GBK"))
    val stringFromGBK = makeStringFromGbkBytes(bytes)
}

fun <P1, P2, P3, R> Function3<P1, P2, P3, R>.curried()
        = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = this(p1, p2, p3)

val makeString = fun(byteArray: ByteArray, charset: Charset): String {
    return String(byteArray, charset)
    /**
     * Converts the data from the specified array of bytes to characters using the specified
     * character set and returns the conversion result as a string.
     */
}

val makeStringFromGbkBytes = makeString.partial2(charset("GBK"))


fun <P1, P2, R> Function2<P1, P2, R>.partial2(p2: P2) = fun(p1: P1) = this(p1, p2)
fun <P1, P2, R> Function2<P1, P2, R>.partial1(p1: P1) = fun(p2: P2) = this(p1, p2)