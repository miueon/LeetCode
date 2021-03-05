//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed. All houses at this place are arranged i
//n a circle. That means the first house is the neighbor of the last one. Meanwhil
//e, adjacent houses have a security system connected, and it will automatically c
//ontact the police if two adjacent houses were broken into on the same night. 
//
// Given a list of non-negative integers nums representing the amount of money o
//f each house, return the maximum amount of money you can rob tonight without ale
//rting the police. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,2]
//Output: 3
//Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 
//2), because they are adjacent houses.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
// 
//
// Example 3: 
//
// 
//Input: nums = [0]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics Dynamic Programming 
// 👍 2648 👎 62

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) {
            return nums[0]
        }
        fun robRange(nums: IntArray, start: Int, end: Int): Int {
            var dp_i_1 = 0
            var dp_i_2 = 0
            var dp_i = 0
            for (i in end downTo start) {
                dp_i = maxOf(dp_i_1, nums[i] + dp_i_2)
                dp_i_2 = dp_i_1
                dp_i_1 = dp_i
            }
            return dp_i
        }
        return maxOf(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1))
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 