package chapter2

fun main(args: Array<String>) {
    while (true) {
        try {
            println("请输入算是例子：例如3 + 4")
            val input = readLine() ?: break
            val splits = input.split(" ")
            if (splits.size < 3) {
                throw IllegalArgumentException("参数个数不对")
            }
            val arg1 = splits[0].toDouble()
            val opt = splits[1]
            val arg2 = splits[2].toDouble()
            println("$arg1 $opt $arg2 = ${Operate(opt)(arg1, arg2)}")
        } catch (e: NumberFormatException) {
            println("您确定输入的是数字吗？")
        } catch (e: IllegalArgumentException) {
            println("您确定输入的是三个参数吗？或者您确定您的输入是用空格分隔的吗？")
        } catch (e: Exception) {
            println("亲爱的用户，您的人品太差了，程序遇到了未知的异常，${e.message}")
        }

        println("再来一发?[Y]")
        val cmd = readLine()
        if (cmd == null || cmd.toLowerCase() != "y") {
            break
        }
    }
    println("感谢您使用我们的计算器。")
}

class Operate(op: String) {
    /**
     * 主构造器的参数不仅可以用init块中，还可以用于对类属性的初始化
     * */
    val OpFun: (left: Double, Right: Double) -> Double

    init {
        OpFun = when (op) {
            "+" -> { l, r -> l + r }
            "-" -> { l, r -> l - r }
            "*" -> { l, r -> l * r }
            "/" -> { l, r -> l / r }
            "%" -> { l, r -> l % r }
            else -> {
                throw UnsupportedClassVersionError(op)
            }
        }
    }

    operator fun invoke(left: Double, right: Double): Double {
        return OpFun(left, right)
    }
}