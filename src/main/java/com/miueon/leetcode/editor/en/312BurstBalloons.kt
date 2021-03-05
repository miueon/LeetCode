//You are given n balloons, indexed from 0 to n - 1. Each balloon is painted wit
//h a number on it represented by an array nums. You are asked to burst all the ba
//lloons. 
//
// If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1
//] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if 
//there is a balloon with a 1 painted on it. 
//
// Return the maximum coins you can collect by bursting the balloons wisely. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,1,5,8]
//Output: 167
//Explanation:
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 
//
// Example 2: 
//
// 
//Input: nums = [1,5]
//Output: 10
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 500 
// 0 <= nums[i] <= 100 
// 
// Related Topics Divide and Conquer Dynamic Programming 
// 👍 3389 👎 99

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxCoins(nums: IntArray): Int {
        val n = nums.size
        val points = IntArray(n + 2) { 0 }
        points[0] = 1
        points[n + 1] = 1
        nums.forEachIndexed { index, i -> points[index + 1] = i }
        val dp = Array(n + 2) { IntArray(n + 2) { 0 } }
        for (i in n downTo 0) {
            for (j in i + 1 until n + 2) {
                for (k in i + 1 until j) {
                    dp[i][j] = maxOf(
                        dp[i][j],
                        dp[i][k] + dp[k][j] + points[i] * points[j] * points[k]
                    )
                }
            }
        }
        return dp[0][n+1]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 