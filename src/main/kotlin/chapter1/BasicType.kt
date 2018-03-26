package chapter1

//Boolean
val aBoolean: Boolean = true
val anotherBoolean: Boolean = false

//Int
val anInt: Int = 3
val anotherInt: Int = 0xff //this is 255 in oct
val moreInt: Int = 0b0000011//this is 3 in bin
val maxInt: Int = Int.MAX_VALUE
val minInt: Int = Int.MIN_VALUE

//Long
val aLong: Long = 12368172397127391
val anotherLong: Long = 123
val maxLong: Long = Long.MAX_VALUE
val minLong: Long = Long.MIN_VALUE

//Float
val aFloat: Float = 2.0F
val anotherFloat: Float = 1E3f
val maxFloat: Float = Float.MAX_VALUE
val minFloat: Float = -Float.MAX_VALUE

//Double
val aDouble: Double = 3.0
val anotherDouble: Double = 3.1415926
val maxDouble: Double = Double.MAX_VALUE
val minDouble: Double = -Double.MAX_VALUE

//Short
val aShort: Short = 127
val maxShort: Short = Short.MAX_VALUE
val minShort: Short = Short.MIN_VALUE

//Byte
val maxByte: Byte = Byte.MAX_VALUE
val minByte: Byte = Byte.MIN_VALUE

fun main(args: Array<String>) {
    //Int
    println("Int:")
    println(anotherInt)
    println(moreInt)

    println(maxInt)
    println(Math.pow(2.0, 31.0) - 1)
    println(minInt)
    println(-Math.pow(2.0, 31.0))

    //Long
    println("Long:")
    println(maxLong)
    println(Math.pow(2.0, 63.0) - 1)
    println(minLong)
    println(-Math.pow(2.0, 63.0))

    //Float
    println("Float:")
    println(aFloat)
    println(anotherFloat)
    println(maxFloat)
    println(minFloat)

    //Double
    println("Double:")
    println(maxDouble)
    println(minDouble)

    //Short
    println("Short:")
    println(maxShort)
    println(minShort)

    //Byte
    println("Byte:")
    println(maxByte)
    println(minByte)

    //NaN
    println(0.0f / 0.0f)
}