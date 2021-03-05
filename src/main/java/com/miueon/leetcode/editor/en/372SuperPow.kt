  //Your task is to calculate ab mod 1337 where a is a positive integer and b is a
//n extremely large positive integer given in the form of an array. 
//
// 
// Example 1: 
// Input: a = 2, b = [3]
//Output: 8
// Example 2: 
// Input: a = 2, b = [1,0]
//Output: 1024
// Example 3: 
// Input: a = 1, b = [4,3,3,8,5,2]
//Output: 1
// Example 4: 
// Input: a = 2147483647, b = [2,0,0]
//Output: 1198
// 
// 
// Constraints: 
//
// 
// 1 <= a <= 231 - 1 
// 1 <= b.length <= 2000 
// 0 <= b[i] <= 9 
// b doesn't contain leading zeros. 
// 
// Related Topics Math 
// 👍 291 👎 864

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    val base = 1337
    fun myPow(a: Int,k:Int): Int {
//        var aa = a % base
//        var res = 1
//        for (i in 0 until k) {
//            res *=aa
//            res %=base
//        }
//        return res
        if (k == 0) {
            return 1
        }
        val aa = a % base
        if (k % 2 == 1) {
            return aa * myPow(a, k -1) % base
        } else {
            val sub = myPow(a, k/2)
            return (sub * sub) % base
        }
    }
    fun superPow(a: Int, b: IntArray): Int {


        if (b.isEmpty()) {
            return 1
        }
        val last = b.last()
        val part1 = myPow(a,last)
        val part2 = myPow(superPow(a, b.dropLast(1).toIntArray()), 10)
        return (part1 * part2) %base
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 