package chapter3

/**
 * 伴生对象与静态类
 *
 * 每个类可以对应一个伴生对象
 * 伴生对象的成员全局独一份
 * 伴生对象的成员类似Java的静态成员
 *
 * 静态成员考虑用包级函数、变量替代
 * JVMField和JVMStatic的使用
 *
 * */

fun main(args: Array<String>) {
    val latitude = Latitude.ofDouble(3.0)
    val latitude2 = Latitude.ofLatitude(latitude)

    println(Latitude.TAG)
}

class Latitude private constructor(val value: Double) {
    companion object {
        @JvmStatic
        fun ofDouble(double: Double): Latitude {
            return Latitude(double)
        }

        fun ofLatitude(latitude: Latitude): Latitude {
            return Latitude(latitude.value)
        }

        @JvmField
        val TAG: String = "Latitude"
    }
}