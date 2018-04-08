package chapter4.builtins

/**
 *
 * 常见的高阶函数
 *
 * map/flatmap
 * fold/reduce
 * filter/takewhile
 * let/apply/with/use
 *
 * */
data class person(val name: String, val age: Int) {
    fun work() {
        println("$name is working!!!")
    }
}

fun main(args: Array<String>) {

//    findPerson()?.let { (name, age) ->
//        print(name)
//        print(age)
//    }

    findPerson()?.apply {
        work()
        print(age)
    }


////    val list = listOf(1, 2, 3, 4, 5, 6, 7)
////
////    //map做映射
////    val newList = list.map {
////        it * 2 + 3
////    }
////
////    val newList2 = list.map(Int::toDouble)
////
////    newList.forEach(::println)
////    newList2.forEach(::println)
//
//    val list = listOf(
//            1..10,
//            2..5,
//            30..100
//    )
//
//    val flatList = list.flatMap { it }
//
//    //val flatList=list.flatMap { it.map { "No. $it" } }
//
////    val flatList = list.flatMap { intRange ->
////        intRange.map { intElement ->
////            "No. $intElement"
////        }
////    }
//
//    flatList.forEach(::println)
//
//    println(flatList.reduce { acc, i -> acc + i })
//
//    //(0..6).map(::factorial).forEach(::println)
//
//    /* println((0..6).map(::factorial).fold(5) { acc, i ->
//         acc + i
//     })*/
//
//    println((0..6).map(::factorial).fold(StringBuilder()) { acc, i ->
//        acc.append(i).append(",")
//    })
//
//    println((0..6).map(::factorial).filter { i: Int -> i % 2 == 1 })

}

fun findPerson(): person? {
    return null
}

//fun factorial(n: Int): Int {
//    if (n == 0) return 0
//    return (1..n).reduce { acc, i -> acc * i }
//}