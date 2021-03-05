//You are given an array prices where prices[i] is the price of a given stock on
// the ith day. 
//
// You want to maximize your profit by choosing a single day to buy one stock an
//d choosing a different day in the future to sell that stock. 
//
// Return the maximum profit you can achieve from this transaction. If you canno
//t achieve any profit, return 0. 
//
// 
// Example 1: 
//
// 
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must
// buy before you sell.
// 
//
// Example 2: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics Array Dynamic Programming 
// 👍 7725 👎 347

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxProfit(prices: IntArray): Int {
        val n: Int = prices.size
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        var dp_i_0 = 0
        var dp_i_1 = Int.MIN_VALUE
        for (i in 0 until n) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i])
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i])
        }
        return dp_i_0
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 