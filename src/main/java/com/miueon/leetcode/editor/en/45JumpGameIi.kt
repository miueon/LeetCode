//Given an array of non-negative integers nums, you are initially positioned at
//the first index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Your goal is to reach the last index in the minimum number of jumps. 
//
// You can assume that you can always reach the last index. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 
//step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,3,0,1,4]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics Array Greedy 
// 👍 3697 👎 171

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun jump(nums: IntArray): Int {
//        val n = nums.size
//        val memo = IntArray(n) { n }
//        fun dp(nums: IntArray, p: Int): Int {
//            if (p >= n - 1) {
//                return 0
//            }
//            if (memo[p] != n) {
//                return memo[p]
//            }
//            var step = nums[p]
//            for (i in 1..step) {
//                val subProblem = dp(nums, p + i)
//                memo[p] = minOf(memo[p], subProblem + 1)
//            }
//            return memo[p]
//        }
//        return dp(nums, 0)
        val n = nums.size
        var end = 0
        var farthest = 0
        var jumps = 0
        for (i in 0 until n-1) {
            farthest = maxOf(nums[i]+i, farthest)
            if (end == i) {
                jumps++
                end = farthest
            }
        }
        return jumps
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  
 