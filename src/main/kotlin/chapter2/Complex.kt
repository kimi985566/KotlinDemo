package chapter2

/**
 * 基本运算符
 *
 * 任何类可以定义或者重载父类的基本运算符
 * 通过运算符对应的具名函数来定义
 * 对参数个数做要求，对参数和返回值类型不作要求
 * 不能像scale一样定义任何运算符
 *
 * */


class Complex(var real: Double, var imag: Double) {
    operator fun plus(other: Complex): Complex {
        return Complex(real + other.real, imag + other.imag)
    }

    operator fun plus(other: Int): Complex {
        return Complex(real + other, imag)
    }

    override fun toString(): String {
        return "$real+${imag}i"
    }
}

fun main(args: Array<String>) {
    var c1 = Complex(1.0, 232.4)
    var c2 = Complex(1.23, 213.0)
    println(c1 + c2)
    println(c1 + 2)
}

/**
 * 中缀表达式
 *
 * 只有一个参数，且用infix修饰的函数
 * eg infix fun on
 *
 * book on desk
 *
 *
 * */