//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics Array Two Pointers 
// 👍 9571 👎 985

package com.miueon.leetcode.editor.en

import java.util.*
import kotlin.collections.ArrayList

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        return threeSumTarget(nums, 0)
    }

    fun threeSumTarget(nums: IntArray, target: Int): List<List<Int>> {
        Arrays.sort(nums)
        val n = nums.size
        val res = ArrayList<ArrayList<Int>>()
        var i = 0
        while (i < n) {
            val tuples = twoSumTarget(nums, i + 1, target - nums[i])
            for (tuple in tuples) {
                tuple.add(nums[i])
                res.add(tuple)
            }

            while (i < n - 1 && nums[i] == nums[i + 1]) i++
            i++
        }
        return res
    }

    fun twoSumTarget(nums: IntArray, start: Int, target: Int): ArrayList<ArrayList<Int>> {
        var lo = start
        var hi = nums.size -1
        val res= ArrayList<ArrayList<Int>>()
        while (lo < hi) {
            val sum = nums[lo] + nums[hi]
            val left = nums[lo]
            val right = nums[hi]
            if (sum < target) {
                while (lo < hi && nums[lo] == left) {
                    lo++
                }
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) {
                    hi--
                }
            } else {
                res.add(arrayOf(left, right).toMutableList() as ArrayList<Int>)
                while (lo < hi && nums[lo] == left) {
                    lo++
                }
                while (lo < hi && nums[hi] == right) {
                    hi--
                }
            }
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 