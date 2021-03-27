  //Given an array of integers nums and an integer k, return the total number of c
//ontinuous subarrays whose sum equals to k. 
//
// 
// Example 1: 
// Input: nums = [1,1,1], k = 2
//Output: 2
// Example 2: 
// Input: nums = [1,2,3], k = 3
//Output: 2
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -1000 <= nums[i] <= 1000 
// -107 <= k <= 107 
// 
// Related Topics Array Hash Table 
// 👍 6725 👎 233

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val n = nums.size
        val preSum = HashMap<Int, Int>()
        preSum[0] =1
        var ans = 0
        var sum0_i = 0
        for (i in 0 until n) {
            sum0_i += nums[i]
            val sum0_j = sum0_i-k
            if (preSum.containsKey(sum0_j)) {
                ans += preSum[sum0_j]!!
            }
            preSum[sum0_i] = preSum.getOrDefault(sum0_i, 0) + 1
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 