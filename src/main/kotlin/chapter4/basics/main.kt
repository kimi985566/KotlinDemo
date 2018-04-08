package chapter4.basics

/**
 *
 * 高阶函数的基本概念
 *
 * 传入或者返回函数的函数
 * 函数引用 ::println
 * 带有receiver的引用 pdfPrinter::println
 *
 * */


fun main(args: Array<String>) {
    args.forEach(::println)

    val helloWorld = Hello::world

    args.filter(String::isNotEmpty)

    val pdfPrinter = PdfPrinter()
    args.forEach(pdfPrinter::println)
}

class PdfPrinter{
    fun println(any: Any){
        kotlin.io.println(any)
    }
}

class Hello{
    fun world(){
        println("Hello World.")
    }
}