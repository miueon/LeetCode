//Given an array of non-negative integers nums, you are initially positioned at
//the first index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Determine if you are able to reach the last index. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jum
//p length is 0, which makes it impossible to reach the last index.
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
// 👍 5797 👎 402

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun canJump(nums: IntArray): Boolean {
       val n = nums.size
        var farthest = 0
        for (i in 0 until n - 1) {
            farthest = maxOf(farthest, i + nums[i])
            if (farthest <= i) {
                return false
            }
        }
        return farthest >= n-1
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 