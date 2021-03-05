//Given a non-empty array nums containing only positive integers, find if the ar
//ray can be partitioned into two subsets such that the sum of elements in both su
//bsets is equal. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics Dynamic Programming 
// 👍 4036 👎 89

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun canPartition(nums: IntArray): Boolean {
//        var sum = 0
//        nums.forEach { sum += it }
//        if (sum % 2 != 0) {
//            return false
//        }
//        val n = nums.size
//        sum /= 2
//        val dp = Array(n + 1) { BooleanArray(sum + 1) { false } }
//        for (i in 0..n) {
//            dp[i][0] = true
//        }
//
//        for (i in 1..n) {
//            for (j in 1..sum) {
//                if (j - nums[i - 1] < 0) {
//                    dp[i][j] = dp[i - 1][j]
//                } else {
//                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]
//                }
//            }
//        }
//        return dp[n][sum]
        var sum = 0
        val n = nums.size
        nums.forEach { sum += it }
        if (sum % 2 != 0) {
            return false
        }
        sum /= 2
        val dp = BooleanArray(sum+1){false}
        dp[0] = true
        for (i in 0 until n) {
            for (j in sum downTo 0) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j-nums[i]]
                }
            }
        }
        return dp[sum]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 