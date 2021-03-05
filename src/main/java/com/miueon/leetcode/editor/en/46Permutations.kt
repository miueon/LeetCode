  //Given an array nums of distinct integers, return all the possible permutations
//. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
// Related Topics Backtracking 
// 👍 5497 👎 127

  package com.miueon.leetcode.editor.en

  import java.util.*

  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val res = LinkedList<LinkedList<Int>>()
        fun backtrack(nums: IntArray, track: LinkedList<Int>) {
            if (track.size == nums.size) {
                res.add(LinkedList(track))
                return
            }

            for (i in 0 until nums.size) {
                if (track.contains(nums[i])) {
                    continue
                }
                track.addLast(nums[i])
                backtrack(nums, track)
                track.removeLast()
            }
        }
        backtrack(nums, LinkedList())
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 