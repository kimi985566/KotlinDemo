package chapter3.dataclass

data class country(val id:Int,val name:String)

fun main(args: Array<String>) {
    val china=country(0,"中国")
    println(china)
}