package chapter3


/**
 *
 * 枚举
 *
 * 实例可数的数，注意枚举也是一个类
 * 可以修改构造，添加成员
 * 可以提升代码质量，也有一定的性能开销
 *
 * */

enum class LogLevel(val id: Int) {
    VERBOSE(0), DEBUG(1), ASSERT(2), INFO(3), WARN(4), ERROR(5);

    fun getTag(): String {
        return "$id,$name"
    }

    override fun toString(): String {
        return "$name,$ordinal"
    }
}

fun main(args: Array<String>) {
    LogLevel.values().map(::println)
    println(LogLevel.valueOf("ERROR"))
}