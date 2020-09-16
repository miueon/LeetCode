  //Given an array of integers nums and an integer target, return indices of the t
//wo numbers such that they add up to target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
// 
//
// Example 3: 
//
// 
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// Only one valid answer exists. 
// 
// Related Topics Array Hash Table 
// 👍 16651 👎 602

  package com.miueon.leetcode.editor.en

  import java.lang.StringBuilder
  import kotlin.math.absoluteValue

  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val inverseMap = HashMap<Int, Int>()
        for (i in nums.withIndex()) {
            inverseMap[nums[i.index]] = i.index
        }

        for ((index, value) in nums.withIndex()) {
            val complement = target - value
            if (inverseMap.containsKey(complement)&& index != inverseMap[complement]) {
                return intArrayOf(index, inverseMap[complement]!!)
            }
        }
        throw IllegalArgumentException("no solution")
    }
}
  fun IntArray.toString()= with(StringBuilder()) {
      append('[')
      for (i in this@toString.withIndex()) {
          if (i.index >0) append(',')
          append(i.value)
      }
      append(']')
      toString()
  }
  fun main() {
      val solution = Solution()

      println(solution.twoSum(intArrayOf(2,7,11,15),9).toString())
  }
//leetcode submit region end(Prohibit modification and deletion)

  
 