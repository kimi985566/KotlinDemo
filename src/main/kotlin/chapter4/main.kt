package chapter4

import java.io.File

fun main(args: Array<String>) {
    val map = HashMap<Char, Int>()
    File("build.gradle").readText().toCharArray().filterNot(Char::isWhitespace)
            .groupBy { it }.map { it.key to it.value.count() }.forEach(::println)
}