//You have a set of integers s, which originally contains all the numbers from 1
// to n. Unfortunately, due to some error, one of the numbers in s got duplicated 
//to another number in the set, which results in repetition of one number and loss
// of another number. 
//
// You are given an integer array nums representing the data status of this set 
//after the error. 
//
// Find the number that occurs twice and the number that is missing and return t
//hem in the form of an array. 
//
// 
// Example 1: 
// Input: nums = [1,2,2,4]
//Output: [2,3]
// Example 2: 
// Input: nums = [1,1]
//Output: [1,2]
// 
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 104 
// 1 <= nums[i] <= 104 
// 
// Related Topics Hash Table Math 
// 👍 1082 👎 419

package com.miueon.leetcode.editor.en

import kotlin.math.abs

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        val n = nums.size
        var dup = -1
        for (i in 0 until n) {
            val index = Math.abs(nums[i]) -1
            if (nums[index] < 0) {
                dup =index +1
            } else {
                nums[index] *= -1
            }
        }

        var missing = -1
        for (i in 0 until n) {
            if (nums[i] > 0) {
                missing = i+1
            }
        }
        return intArrayOf(dup, missing)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 