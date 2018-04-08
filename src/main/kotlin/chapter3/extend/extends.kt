package chapter3.extend


/**
 * 扩展方法
 *
 * 为现有类添加属性、方法
 * Java调用扩展成员类似调用静态方法
 *
 * */

fun main(args: Array<String>) {

    println("abc" * 16)
}

//fun String.multiply(int: Int): String {
//    val stringBuilder = StringBuilder()
//    for (i in 0 until int) {
//        stringBuilder.append(this)
//    }
//    return stringBuilder.toString()
//
//}

operator fun String.times(int: Int): String {
    val stringBuilder = StringBuilder()
    for (i in 0 until int) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}