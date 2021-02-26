//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [0]
//Output: 0
// 
//
// Example 4: 
//
// 
//Input: nums = [-1]
//Output: -1
// 
//
// Example 5: 
//
// 
//Input: nums = [-100000]
//Output: -100000
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//Follow up: If you have figured out the O(n) solution, try coding another solut
//ion using the divide and conquer approach, which is more subtle. Related Topics 
//Array Divide and Conquer Dynamic Programming 
// 👍 10954 👎 523

package com.miueon.leetcode.editor.en

import kotlin.math.max

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) {
            return 0
        }
        var dp_0 = nums[0]
        var dp_1 = 0
        var res = dp_0
        for (i in 1 until n) {
            dp_1 = Math.max(nums[i], nums[i] + dp_0)
            dp_0 = dp_1
            res = Math.max(res, dp_1)
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 