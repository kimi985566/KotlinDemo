package chapter7

data class person(val name: String, val age: Int)

fun main(args: Array<String>) {
    val clazz = person::class.java
    val personDemo = person("Benny", 18)
    val clazz2 = personDemo.javaClass

    val personDemo2 = clazz2
            .getConstructor(String::class.java, Int::class.java)
            .newInstance("benny", 18)

    println(personDemo2)
}