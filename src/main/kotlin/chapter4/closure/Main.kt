package chapter4.closure

/**
 *
 * 闭包
 *
 * 函数的运行环境
 * 持有函数的运行状态
 * 函数内部可以定义函数
 * 函数内部也可以定义类
 *
 *
 * */

fun makeFun(): () -> Unit {
    var count = 0
    return fun() {
        println(++count)
    }
}

fun fibonacci(): Iterable<Long> {
    var first = 0L
    var second = 1L
    return Iterable {
        object : LongIterator() {
            override fun nextLong(): Long {
                val result = second
                second += first
                first = second - first
                return result
            }

            override fun hasNext() = true

        }
    }
}

fun main(args: Array<String>) {
    for(i in fibonacci()){
        if(i>100) break
        println(i)
    }
}