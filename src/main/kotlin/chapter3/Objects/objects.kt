package chapter3.Objects


open class Driver

interface OnExternalDriverMountListener {
    fun onMount(driver: Driver)

    fun onUnMount(driver: Driver)
}

abstract class Player

/**
 *
 * object
 *
 * 只有一个实例的类
 * 不能自定义构造方法
 * 可以实现接口，继承父类
 * 本质上就是单例模式最基本的实现
 *
 * */

object MusicPlayer : Player(), OnExternalDriverMountListener {
    override fun onMount(driver: Driver) {

    }

    override fun onUnMount(driver: Driver) {
    }

    var state: Int = 0

    fun play(url: String) {

    }

    fun stop() {

    }
}