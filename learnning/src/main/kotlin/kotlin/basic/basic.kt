package kotlin.basic

/**
 *@Author: Logan Chen
 *@date: 2019/11/8 18:13
 *@Description:
 */
fun main() {
    fun printDouble(d: Double) {
        print(d)
    }

    val i = 1
    val d = 1.1
    val f = 1.1f

    printDouble(d)
    //printDouble(i)    kotlin中没有隐式转换，Double参数只能对Double值进行调用。当需要数值转换为不同类型的时候，需要进行显示转换。

    //2、字面常量
    val creditCardNumber = 123_456_789_012_345_6L  //long类型
    val hexBytes = 0xFF_EC_dE_5E  //
}