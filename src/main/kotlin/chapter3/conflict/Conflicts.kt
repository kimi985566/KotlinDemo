package chapter3.conflict


/**
 *
 * 继承（实现）语法要点
 *
 * 父类需要Open才可以被继承
 * 父类方法，属性需要Open才可以被复写
 * 接口、接口方法、抽象类默认为Open
 * 复写父类（接口）成员都是需要override关键字的
 * class D:A(),B,C
 * 注意继承类时实际上调用父类构造方法
 * 类只能单继承，接口可以多实现
 *
 *
 * 接口代理
 *
 * class manager(val driver:Driver):Driver by driver
 * 接口方法实现交给代理类实现
 *
 * 接口方法冲突
 *
 * 接口方法可以有默认实现
 * 签名一致且返回值相同的冲突
 * 子类必须复写冲突方法
 * super<[父类（接口）名]>.[方法名]([参数列表])
 *
 * */


abstract class A {
    open fun x(): Int = 5
}

interface B {
    fun x(): Int = 1
}

interface C {
    fun x(): Int = 0
}

class D(var y: Int = 0) : A(), B, C {

    override fun x(): Int {
        println("call x(): Int in D")
        if (y > 0) {
            return y
        } else if (y < -200) {
            return super<C>.x()
        } else if (y < -100) {
            return super<B>.x()
        } else {
            return super<A>.x()
        }
    }
}

fun main(args: Array<String>) {
    println(D(3).x())
    println(D(-10).x())
    println(D(-110).x())
    println(D(-10000).x())
}