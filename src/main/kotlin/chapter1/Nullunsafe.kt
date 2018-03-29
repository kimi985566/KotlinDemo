package chapter1

fun getName(): String? {
    return null
}

fun main(args: Array<String>) {
    val value: String? = "name"
    print(value!!.length)

//    val name: String = getName() ?: return
//    println(name.length)
}