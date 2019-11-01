package java_new_feature.java8


/**
 *@Author: Logan Chen
 *@date: 2019/10/26 11:53
 *@Description:
 */

fun main() {

    val dish = Dish(500, "cola", "reg")
    val dish1 = Dish(320, "ice", "reg")
    val dish2 = Dish(1200, "meat", "meat")
    val dish3 = Dish(200, "water", "other")

    var menu = listOf<Dish>(dish, dish1, dish2, dish3)  //listOf是只读的，不能增删改查

    // var menu: List<Dish> = mutableListOf(dish, dish1, dish2, dish3)  //mutableListOf ：listOf的扩展

    //kotlin的流处理
    val lowCaloricDishesName: List<String> = menu.filter { d -> d.calories < 400 }
        .sortedBy { t -> t.calories }
        .map { it.name }
        .toList()

    lowCaloricDishesName.forEach(::println)
    lowCaloricDishesName.forEach { println(it) }   //代码块


}

data class Dish(val calories: Int, val name: String, val type: String)

data class Trader(val name: String, val city: String)

data class Transaction(val trader: Trader, val year: Int, val value: Int)

enum class CaloricLevel{DIET,NORMAL,FAT}