package chapter3.extend

fun main(args: Array<String>) {

    println("abc".multiply(16))
}

fun String.multiply(int: Int): String {
    val stringBuilder = StringBuilder()
    for (i in 0 until int) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()

}