package com.hongwei.lib.kotlin.adapter.mq

/**
 * <pre>
 *     author  :  hongwei.jiang
 *     time    :  2022/01/21
 *     desc    :  Phoenix
 *     version :  1.0
 * </pre>
 */
data class JiaBoPrintMq(
    val gdsNum: String,
    val gdsName: String,
    val gdsScal: String,
    val batchNum: String,
    val baleTime: String,
    val depotAddress: String,
    val warehouser: String,
)

data class MeiSungPrintMq(
    val gdsNum: String,
    val gdsName: String,
    val baleTime: String,
    val depotAddress: String,
    val marker: String,
    val operator: String
)

data class User(val name: String, val age: Int)

/**
 * 用户--消费者
 */
data class Consumer(val userId: String, val stage: Int)