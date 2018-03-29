package chapter1

val string: String = "HelloWorld"
val fromChars: String = String(charArrayOf('H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd'))

fun main(args: Array<String>) {
    //==和equals等价
    //== 比较内容
    print(string == fromChars)
    //=== 比较对象
    print(string === fromChars)

    val arg1: Int = 0
    val arg2: Int = 1
    println("" + arg1 + " + " + arg2 + " = " + (arg1 + arg2))
    println("$arg1 + $arg2 = ${arg1 + arg2}")

    //Hello "Trump"
    val sayHello: String = "Hello \"Trump\""
    println(sayHello)
    //salary
    val salary: Int = 1000
    //$salary
    println("$salary")
    println("\$salary")

    val rawString: String = """
        \t
        \n
        $salary
\\\\\\$$$ salary
这里无法转义，如果要转义就直接空格
    """
    println(rawString)
    println(rawString.length)
}