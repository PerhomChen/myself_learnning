package kotlin.basic

import java.io.File

/**
 *@Author: Logan Chen
 *@date: 2019/10/24 16:00
 *@Description:
 */


//应用程序的入口
fun main() {
    println("Hello world!")

    //定义只读局部变量使用关键字 val 定义。只能为其赋值一次。
    val a: Int = 1  // 立即赋值
    val b = 2   // 自动推断出 `Int` 类型
    val c: Int  // 如果没有初始值类型不能省略
    c = 3       // 明确赋值

    //可重新赋值的变量使用 var 关键字
    var x = 5 // 自动推断出 `Int` 类型
    x += 1

    /*字符串模板*/
    var aa = 1
    // 模板中的简单名称：
    val s1 = "a is $aa"

    aa = 2
    // 模板中的任意表达式：
    val s2 = "${s1.replace("is", "was")}, but now is $aa"

    //for循环
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }

    println("-----------------------")

    //while循环
    val itemss = listOf("apple", "banana", "kiwifruit")
    var index = 0
    while (index < itemss.size) {
        println("item at $index is ${items[index]}")
        index++
    }

    println("-----------------------")


    //使用区间l;类似于java中的可变长度数组参数
    val g = 10
    val h = 9
    if (g in 1..h + 1) {
        println("fits in range")
    }

    println("-----------------------")


    //检测某个数字是否在指定区间外
    val list = listOf("a", "b", "c")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }

    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }

    println("-----------------------")


    //区间迭代
    for (x in 1..5) {
        print("$x ")
    }
    println()
    //数列迭代
    for (x in 1..10 step 2) {
        print("$x ")
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print("$x ")
    }

    println()
    println("-----------------------")

    //使用 in 运算符来判断集合内是否包含某实例
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    //使用 lambda 表达式来过滤（filter）与映射（map）集合;java8中的stream APi
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }

    println("-----------------------")

    //延迟属性;只在第一次调用get会执行传递给lazy（）的lambda表达式，后续调用get（）只是返回记录的结果。
    val p: String by lazy {
        println("first output")
        "Hello"
    }


    println(p)
    println("-----------------------")
    println(p)

    println("-----------------------")

    //使用扩展函数
    "Convert this to camelcase".spaceToCamelCase()

    println("-----------------------")

    //if 非空，else的缩写
    val files = File("Test").listFiles()
    println(files?.size ?: "empty")

    //if null 执行一个语句
    val values = mapOf<String, String>("aa" to "i am aa", "bb" to "i am bb")
    val email = values["aa"] ?: throw IllegalStateException("aa is missing!")

    //在可能为null集合中的使用
    val emails = mapOf<String, String>("aa" to "i am aa", "bb" to "i am bb")
    //val mainEmail = emails.firstOrNull() ?: ""


    //if not null 执行代码
    values?.let {
        println("values is not null")
    }


}

// 参数名 ：参数类型 ；: Int 返回值
fun sum(a: Int, b: Int): Int {
    return a + b
}

//将表达式作为函数体、返回值类型自动推断的函数

fun sum1(a: Int, b: Int) = a + b


//函数返回无意义的值：
fun printSum(a: Int, b: Int): Unit {
    println("kotlin.basic.sum of $a and $b is ${a + b}")
}

//Unit 返回类型可以省略：
fun printSum1(a: Int, b: Int) {
    println("kotlin.basic.sum of $a and $b is ${a + b}")
}

//条件表达式
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

//if作为表达式传递给函数作为函数体。
fun maxOfNew(a: Int, b: Int) = if (a > b) a else b

//某个变量的值可以为 null 的时候，必须在声明处的类型后添加 ? 来标识该引用可为空。
fun parseInt(str: String): Int? {
    return str.toInt()
}

//使用可返回null的函数
fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // 直接使用 `x * y` 会导致编译错误，因为它们可能为 null
    if (x != null && y != null) {
        // 在空检测后，x 与 y 会自动转换为非空值（non-nullable）
        println(x * y)
    } else {
        println("'$arg1' or '$arg2' is not a number")
    }
}

//类型检测与自动类型转换
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` 在该条件分支内自动转换成 `String`
        return obj.length
    }

    return null
}


//when表达式，类似于java中的switch
fun describe(obj: Any): String =
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a string"
        else -> "Unknown"
    }

//扩展函数
fun String.spaceToCamelCase() {
    println("use extend method !")
}

//创建单例
object Resource {
    val name = "Name"
}


//try-catch
fun test() {
    val result = try {

    } catch (e: ArithmeticException) {
        throw IllegalStateException(e)
    }

    // 使用 result
}

fun theAnswer() = 42

//等价于
fun theAnswer1(): Int {
    return 42
}

//创建DTO
data class Customer(val name: String, val email: String)