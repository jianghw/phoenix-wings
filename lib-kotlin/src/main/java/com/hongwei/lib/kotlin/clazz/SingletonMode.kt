package com.hongwei.lib.kotlin.clazz

/**
 * <pre>
 *     author  :  hongwei.jiang
 *     time    :  2022/01/06
 *     desc    :  单例模式，Singleton mode
 *     version :  1.0
 * </pre>
 */
class SingletonMode private constructor() {

    companion object {
        private var instance: SingletonMode? = null
            get() {
                if (field == null) {
                    field = SingletonMode()
                }
                return field
            }

        @Synchronized
        fun get(): SingletonMode {
            return instance!!
        }
    }
}

fun main() {
    val singleton = SingletonMode.get()
    val r = Runnable { println(singleton.toString()) }
    for (i in 1..10) {
        Thread(r).start()
    }
}