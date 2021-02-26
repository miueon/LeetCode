  //Given an array nums of n integers and an integer target, are there elements a,
// b, c, and d in nums such that a + b + c + d = target? Find all unique quadruple
//ts in the array which gives the sum of target. 
//
// Notice that the solution set must not contain duplicate quadruplets. 
//
// 
// Example 1: 
// Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// Example 2: 
// Input: nums = [], target = 0
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics Array Hash Table Two Pointers 
// 👍 2986 👎 399

  package com.miueon.leetcode.editor.en

  import java.util.*
  import kotlin.collections.ArrayList

  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        Arrays.sort(nums)
        val n = nums.size
        val res = ArrayList<ArrayList<Int>>()
        var i = 0
        while (i < n) {
            val triples = threeSumTarget(nums, i+1, target - nums[i])
            for (triple in triples) {
                triple.add(nums[i])
                res.add(triple)
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++
            }
        }
        return res
    }
    fun threeSumTarget(nums: IntArray, start: Int, target: Int): ArrayList<ArrayList<Int>> {
        Arrays.sort(nums)
        val n = nums.size
        val res = ArrayList<ArrayList<Int>>()
        var i = start
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

  
 