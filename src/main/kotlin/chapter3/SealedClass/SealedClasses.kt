package chapter3.SealedClass

/**
 *
 * 密封类
 *
 * 子类可数（枚举是实例可数）
 *
 * 子类只需要与密封类在同一个文件中即可
 *
 *
 * */


sealed class PlayerCmd {
    class Play(val url: String, val position: Long = 0) : PlayerCmd()

    class seek(val position: Long) : PlayerCmd()

    object Pause : PlayerCmd()

    object Resume : PlayerCmd()

    object Stop : PlayerCmd()
}

enum class PlayerState {
    IDLE, PAUSE, STOP, PLAYING
}