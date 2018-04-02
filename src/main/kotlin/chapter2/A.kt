package chapter2

/**
 *
 * 函数与方法的区别：
 * 函数强调功能本身，不强调从属
 * 方法的称呼通常是从类的角度出发
 *
 *
 * 属性的初始化：
 * 初始化尽量在构造方法中完成
 * 无法在构造方法中初始化的，尝试降级为局部变量
 * var可以用lateinit，val可以用xx by lazy来延迟初始化
 *
 * */



class A {
    var b = 0
        get() {
            println("Some one tries to get B")
            return field
        }
        set(value) {
            println("Some one tries to set B")
            field = value
        }
}