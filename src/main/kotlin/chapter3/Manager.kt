package chapter3


interface Driver {
    fun drive()
}

interface Writer {
    fun write()
}

class Manager : Driver, Writer {
    override fun drive() {

    }

    override fun write() {

    }

}

class SeniorManager(val driver: Driver, val writer: Writer) : Driver by driver, Writer by writer

class CarDriver : Driver {
    override fun drive() {
        println("I'm driving.")
    }
}

class PPTWriter : Writer {
    override fun write() {
        println("I'm writing.")
    }

}

fun main(args: Array<String>) {
    val driver = CarDriver()
    val writer = PPTWriter()
    val seniorManager = SeniorManager(driver, writer)
    seniorManager.drive()
    seniorManager.write()
}