  //Count the number of prime numbers less than a non-negative number, n. 
//
// 
// Example 1: 
//
// 
//Input: n = 10
//Output: 4
//Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
// 
//
// Example 2: 
//
// 
//Input: n = 0
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: n = 1
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics Hash Table Math 
// 👍 2768 👎 736

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun countPrimes(n: Int): Int {
        val isPrim = BooleanArray(n){true}
        var i = 2
        while (i * i < n) {
            if (isPrim[i]) {
                var j = i * i
                while (j < n) {
                    isPrim[j] = false
                    j +=i
                }
            }
            i++
        }
        var count = 0
        for (j in 2 until n) {
            if (isPrim[j]) {
                count++
            }
        }
        return count
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 