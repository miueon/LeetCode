//You are given coins of different denominations and a total amount of money amo
//unt. Write a function to compute the fewest number of coins that you need to mak
//e up that amount. If that amount of money cannot be made up by any combination o
//f the coins, return -1. 
//
// You may assume that you have an infinite number of each kind of coin. 
//
// 
// Example 1: 
//
// 
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
// 
//
// Example 2: 
//
// 
//Input: coins = [2], amount = 3
//Output: -1
// 
//
// Example 3: 
//
// 
//Input: coins = [1], amount = 0
//Output: 0
// 
//
// Example 4: 
//
// 
//Input: coins = [1], amount = 1
//Output: 1
// 
//
// Example 5: 
//
// 
//Input: coins = [1], amount = 2
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics Dynamic Programming 
// 👍 6104 👎 183

package com.miueon.leetcode.editor.en

import java.util.*
import kotlin.collections.ArrayList

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
//        val memo = HashMap<Int, Int>()
//       fun dp(n: Int): Int {
//            if (memo.containsKey(n)) {
//                return memo[n]!!
//            }
//            if (n == 0) {
//                return 0
//            }
//            if (n < 0) {
//                return -1
//            }
//            var res = Int.MAX_VALUE
//            for (coin in coins) {
//                val subproblem = dp(n - coin)
//                if (subproblem == -1) {
//                    continue
//                }
//                res = minOf(res, 1+subproblem)
//            }
//           memo[n] = when (res != Int.MAX_VALUE) {
//               true -> res
//               else -> -1
//           }
//           return memo[n]!!
//        }
//        return dp(amount)
        val dp = ArrayList<Int>(Collections.nCopies(amount +1, amount+1))
        // base case
        dp[0] = 0
        // 枚举
        for (i in 0 until dp.size) {
            for (coin in coins) {
                if (i - coin < 0) {
                    continue
                }
                dp[i] = minOf(dp[i], 1 + dp[i-coin])
            }
        }
        return when (dp[amount] == amount + 1) {
            true -> -1
            else -> dp[amount]
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 