//Given the array orders, which represents the orders that customers have done i
//n a restaurant. More specifically orders[i]=[customerNamei,tableNumberi,foodItem
//i] where customerNamei is the name of the customer, tableNumberi is the table cu
//stomer sit at, and foodItemi is the item customer orders. 
//
// Return the restaurant's “display table”. The “display table” is a table whose
// row entries denote how many of each food item each table ordered. The first col
//umn is the table number and the remaining columns correspond to each food item i
//n alphabetical order. The first row should be a header whose first column is “Ta
//ble”, followed by the names of the food items. Note that the customer names are 
//not part of the table. Additionally, the rows should be sorted in numerically in
//creasing order. 
//
// 
// Example 1: 
//
// 
//Input: orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["Davi
//d","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3
//","Ceviche"]]
//Output: [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","
//2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]] 
//Explanation:
//The displaying table looks like:
//Table,Beef Burrito,Ceviche,Fried Chicken,Water
//3    ,0           ,2      ,1            ,0
//5    ,0           ,1      ,0            ,1
//10   ,1           ,0      ,0            ,0
//For the table 3: David orders "Ceviche" and "Fried Chicken", and Rous orders "
//Ceviche".
//For the table 5: Carla orders "Water" and "Ceviche".
//For the table 10: Corina orders "Beef Burrito". 
// 
//
// Example 2: 
//
// 
//Input: orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"
//],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1
//","Canadian Waffles"]]
//Output: [["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0",
//"3"]] 
//Explanation: 
//For the table 1: Adam and Brianna order "Canadian Waffles".
//For the table 12: James, Ratesh and Amadeus order "Fried Chicken".
// 
//
// Example 3: 
//
// 
//Input: orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Me
//lissa","2","Soda"]]
//Output: [["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= orders.length <= 5 * 10^4 
// orders[i].length == 3 
// 1 <= customerNamei.length, foodItemi.length <= 20 
// customerNamei and foodItemi consist of lowercase and uppercase English letter
//s and the space character. 
// tableNumberi is a valid integer between 1 and 500. 
// 
// Related Topics Hash Table 
// 👍 79 👎 192

package com.miueon.leetcode.editor.en

import java.util.Comparator.comparingInt
import java.util.function.Function
import java.util.function.ToIntFunction
import java.util.stream.Collectors.*
import java.util.stream.Stream
import kotlin.streams.toList


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    fun displayTable(orders: List<List<String>>): List<List<String>> {
//        val food = orders.stream()
//                .map { item -> item[2] }
//                .distinct()
//                .sorted()
//                .toList()
//        return Stream.concat(
//                Stream.of(Stream.concat(Stream.of("Table"), food.stream()).toList()),
//                orders.stream().collect()
//        ).toList()
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

val data: MutableList<List<String>> = ArrayList()
fun main() {

    data.add(listOf("David", "3", "Ceviche"))
    data.add(listOf("Corina", "10", "Beef Burrito"))
    data.add(listOf("David", "3", "Fried Chicken"))
    data.add(listOf("Carla", "5", "Water"))
    data.add(listOf("Carla", "5", "Ceviche"))
    data.add(listOf("Rous", "3", "Ceviche"))
    val food = data.stream()
            .map { item -> item[2] }
            .distinct()
            .sorted()
            .toList()
    //println(food)

    /*
    * return Stream.concat(
                Stream.of(Stream.concat(Stream.of("Table"), food.stream()).collect(toList())),
                orders.stream()
                        .collect(groupingBy(order -> order.get(1),
                                groupingBy(order -> order.get(2),
                                        collectingAndThen(counting(), Long::intValue))))
                        .entrySet().stream()
                        .sorted(comparingInt(e -> Integer.parseInt(e.getKey())))
                        .map(e -> Stream.concat(Stream.of(e.getKey()),
                                food.stream()
                                        .map(item -> e.getValue().getOrDefault(item, 0))
                                        .map(Object::toString))
                                .collect(toList())))
                .collect(toList());
    * */
    val testList1 = Stream.concat(
                            Stream.of("Table"),
                            food.stream()
                    ).toList()
    //println(testList1)

//    val test = Stream.concat(
//            Stream.of(
//                    Stream.concat(
//                            Stream.of("Table"),
//                            food.stream()
//                    ).toList()
//            ),
//
//    )
}




