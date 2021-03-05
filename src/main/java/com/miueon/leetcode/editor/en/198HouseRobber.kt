//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed, the only constraint stopping you from r
//obbing each of them is that adjacent houses have security system connected and i
//t will automatically contact the police if two adjacent houses were broken into 
//on the same night. 
//
// Given a list of non-negative integers representing the amount of money of eac
//h house, determine the maximum amount of money you can rob tonight without alert
//ing the police. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 
//(money = 1).
//             Total amount you can rob = 2 + 9 + 1 = 12.
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics Dynamic Programming 
// 👍 6586 👎 186

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun rob(nums: IntArray): Int {
//        val memo = IntArray(nums.size) { -1 }
//        fun dp(nums: IntArray, start: Int): Int {
//            if (start >= nums.size) {
//                return 0
//            }
//            if (memo[start] != -1) {
//                return memo[start]
//            }
//
//            val res = maxOf(
//                dp(nums, start + 1),
//                nums[start] + dp(nums, start + 2)
//            )
//            memo[start] = res
//            return res
//        }
//        return dp(nums, 0)
        val n = nums.size
        var dp_i_1 = 0
        var dp_i_2 = 0
        var dp_i = 0
        for (i in n - 1 downTo 0) {
            dp_i = maxOf(dp_i_1, dp_i_2 + nums[i])
            dp_i_2 = dp_i_1
            dp_i_1 = dp_i
        }
        return dp_i
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 