package chapter3.delegates

import kotlin.reflect.KProperty


/**
 * 代理方法
 *
 * 定义方法：val/var <property name>:<Type> by <expression>
 * 代理者需要实现相应的setValue/getValue方法
 *
 *
 * */


class Delegates {
    val hello by lazy {
        "HelloWorld"
    }

    val hello2 by X()

    var hello3 by X()
}

class X {
    private var value: String? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("getValue: $thisRef -> ${property.name}")
        return value ?: ""
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("setValue, $thisRef -> ${property.name} = $value")
        this.value = value
    }
}

fun main(args: Array<String>) {
    val delegates = Delegates()
    println(delegates.hello)
    println(delegates.hello2)
    println(delegates.hello3)
    delegates.hello3 = "value of hello3"
    println(delegates.hello3)
}