  //Given an array nums which consists of non-negative integers and an integer m, 
//you can split the array into m non-empty continuous subarrays. 
//
// Write an algorithm to minimize the largest sum among these m subarrays. 
//
// 
// Example 1: 
//
// 
//Input: nums = [7,2,5,10,8], m = 2
//Output: 18
//Explanation:
//There are four ways to split nums into two subarrays.
//The best way is to split it into [7,2,5] and [10,8],
//where the largest sum among the two subarrays is only 18.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4,5], m = 2
//Output: 9
// 
//
// Example 3: 
//
// 
//Input: nums = [1,4,4], m = 3
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 106 
// 1 <= m <= min(50, nums.length) 
// 
// Related Topics Binary Search Dynamic Programming 
// 👍 2412 👎 93

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun splitArray(nums: IntArray, m: Int): Int {
        var left = getMax(nums)
        var right = getSum(nums)
        var max = 0
        var n = 1
        while (left <= right) {
            max = left + (right - left) /2
            n = split(nums, max)
            if (n == m) {
                right = max-1
            } else if (n < m) {
                right = max-1
            } else if (n > m) {
                left = max + 1
            }
        }
        return left
    }

    fun split(nums: IntArray, max: Int): Int {
        var count = 1
        var sum = 0
        for (i in 0 until nums.size) {
            if (sum + nums[i] > max) {
                count++
                sum = nums[i]
            } else {
                sum += nums[i]
            }
        }
        return count
    }

    fun getSum(nums: IntArray) = nums.reduce { acc, i -> acc+i }
    fun getMax(nums: IntArray): Int {
        var max = nums[0]
        nums.forEach { max = Math.max(max, it) }
        return max
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 