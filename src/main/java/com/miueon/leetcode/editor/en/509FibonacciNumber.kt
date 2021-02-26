//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibon
//acci sequence, such that each number is the sum of the two preceding ones, start
//ing from 0 and 1. That is, 
//
// 
//F(0) = 0, F(1) = 1
//F(n) = F(n - 1) + F(n - 2), for n > 1.
// 
//
// Given n, calculate F(n). 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 1
//Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 2
//Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// Example 3: 
//
// 
//Input: n = 4
//Output: 3
//Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 30 
// 
// Related Topics Array 
// 👍 1087 👎 218

package com.miueon.leetcode.editor.en

import java.util.*
import kotlin.collections.ArrayList

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun fib(n: Int): Int {
//        if (n < 1) {
//            return 0
//        }
//        val memo = ArrayList<Int>(Collections.nCopies(n + 1, 0))
//       return helper(memo, n)
        if (n < 1) {
            return 0
        }
        if (n == 2 || n == 1) {
            return 1
        }
        var prev = 1
        var cur = 1
        for (i in 3..n) {
            val sum = prev + cur
            prev = cur
            cur = sum
        }
        return cur
    }

//    fun helper(memo: ArrayList<Int>, n: Int):Int {
//        if (n == 1 || n == 2) {
//            return 1
//        }
//        if (memo[n] != 0) {
//            return memo[n]
//        }
//        memo[n] = helper(memo, n-1) + helper(memo, n-2)
//        return memo[n]
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 