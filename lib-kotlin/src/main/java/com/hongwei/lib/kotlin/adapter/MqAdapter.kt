package com.hongwei.lib.kotlin.adapter

import java.util.*
import kotlin.collections.HashMap

/**
 * <pre>
 *     author  :  hongwei.jiang
 *     time    :  2022/01/21
 *     desc    :  消息体适配
 *     version :  1.0
 * </pre>
 */
class MqAdapter {

    companion object Factory {
        fun filter(strJson: String, link: Map<String, String>) {
        }

        /**
         * 规则适配器
         */
        fun filter(source: Map<*, *>, ruleTarget: Map<String, String>): AdapterMq {
            val adapterMq = AdapterMq()
            ruleTarget.forEach { (key, value) ->
                val obj = source[value]
                val initials = key.substring(0, 1).uppercase(Locale.getDefault())
                AdapterMq::class.java.getMethod(
                    "set${initials}${key.substring(1)}",
                    String::class.java
                ).invoke(adapterMq, obj.toString())
            }
            return adapterMq
        }
    }
}

data class AdapterMq(
    var userId: String? = null,
    var bizId: String? = null,
    var stage: String? = null
)

fun main() {
    val source = HashMap<String, String>()
    source["name"] = "123456"
    source["age"] = "30"

    val ruleTarget = mutableMapOf(
        "userId" to "name",
        "bizId" to "name",
        "stage" to "age",
    )

    val adapter = MqAdapter.filter(source, ruleTarget)

    println(adapter.toString())
    //AdapterMq(userId=123456, bizId=123456, stage=30)
}
