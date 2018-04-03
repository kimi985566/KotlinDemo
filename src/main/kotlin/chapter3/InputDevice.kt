package chapter3

/**
 * 接口
 *
 * 直观理解就是一种约定
 * 不能有状态
 * 必须由类对其进行实现后使用
 *
 * 抽象类
 *
 * 是实现了部分协议的半成品
 * 可以有状态，可以有方法实现
 * 必须由子类继承后使用
 *
 *
 * 两者的共同点
 *
 * 比较抽象，不能直接实例化
 * 有需要子类（实现类）实现的方法
 * 父类（借口）变量可以接受子类（实现类）的实例赋值
 *
 * 不同点
 *
 * 抽象类有状态，接口无状态
 * 抽象类有实现的方法，接口只能有无状态的默认实现
 * 抽象类只能单继承，接口可以多继承
 * 抽象类反映本质，接口体现能力
 * */

interface InputDevice {
    fun input(event: Any)
}

interface USBInputDevice : InputDevice

interface BLEInputDevice : InputDevice

abstract class USBMouse(val name: String) : USBInputDevice {
    override fun input(event: Any) {
    }

    override fun toString(): String {
        return name
    }
}

class logiUSBMouse : USBMouse("罗技鼠标") {

}

class Computer {
    fun addUSBInputDevice(inputDevice: USBInputDevice) {
        //Plugin USB input device
        println("add usb input device: $inputDevice")
    }

    fun addBLEInputDevice(inputDevice: BLEInputDevice) {
        //plugin BLE input device
        println("add BLE input device: $inputDevice")
    }

    fun addInputDevice(inputDevice: InputDevice) {
        when (inputDevice) {
            is USBInputDevice -> {
                addUSBInputDevice(inputDevice)
            }
            is BLEInputDevice -> {
                addBLEInputDevice(inputDevice)
            }
            else -> {
                throw IllegalArgumentException("输入设备不支持")
            }
        }
    }
}

fun main(args: Array<String>) {
    val computer = Computer()
    val mouse = logiUSBMouse()
    computer.addInputDevice(mouse)
}