//You are given a list of non-negative integers, a1, a2, ..., an, and a target,
//S. Now you have 2 symbols + and -. For each integer, you should choose one from 
//+ and - as its new symbol. 
//
// Find out how many ways to assign symbols to make sum of integers equal to tar
//get S. 
//
// Example 1: 
//
// 
//Input: nums is [1, 1, 1, 1, 1], S is 3. 
//Output: 5
//Explanation: 
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//There are 5 ways to assign symbols to make the sum of nums be target 3.
// 
//
// 
// Constraints: 
//
// 
// The length of the given array is positive and will not exceed 20. 
// The sum of elements in the given array will not exceed 1000. 
// Your output answer is guaranteed to be fitted in a 32-bit integer. 
// 
// Related Topics Dynamic Programming Depth-first Search 
// 👍 3735 👎 150

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findTargetSumWays(nums: IntArray, S: Int): Int {
//        if (nums.size == 0) {
//            return 0
//        }
//        return dp(nums, 0, S)
        var sum = 0
        for (n in nums) {
            sum += n
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0
        }
        return subsets(nums, (sum + S) / 2)
    }

    val memo = HashMap<String, Int>()

    fun dp(nums: IntArray, i: Int, rest: Int): Int {
        if (i == nums.size) {
            if (rest == 0) {
                return 1
            }
            return 0
        }
        val key = "$i,$rest"
        if (memo.containsKey(key)) {
            return memo[key]!!
        }

        val result = dp(nums, i + 1, rest - nums[i]) +
                dp(nums, i + 1, rest + nums[i])
        memo[key] = result
        return result
    }

    fun subsets(nums: IntArray, sum: Int): Int {
//        val n = nums.size
//        val dp = Array(n + 1) { IntArray(sum + 1) { 0 } }
//        for (i in 0..n) {
//            dp[i][0] = 1
//        }
//        for (i in 1..n) {
//            for (j in 0..sum) {
//                if (j >= nums[i - 1]) {
//                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]]
//                } else {
//                    dp[i][j] = dp[i - 1][j]
//                }
//            }
//        }
//        return dp[n][sum]
        val n = nums.size
        val dp = IntArray(sum+1){0}
        dp[0] = 1
        for (i in 1..n) {
            for (j in sum downTo 0) {
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j] + dp[j - nums[i - 1]]
                } else {
                    dp[j] = dp[j]
                }
            }
        }
        return dp[sum]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 