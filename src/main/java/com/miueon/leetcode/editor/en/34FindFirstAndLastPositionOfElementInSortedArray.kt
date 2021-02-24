  //Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// Follow up: Could you write an algorithm with O(log n) runtime complexity? 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums is a non-decreasing array. 
// -109 <= target <= 109 
// 
// Related Topics Array Binary Search 
// 👍 5001 👎 192

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        return intArrayOf(leftbound(nums,target), rightbound(nums, target))
    }
    fun leftbound(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size-1
        var mid = 0
        while (left <= right) {
            mid = left + (right -left)/2
            if (nums[mid] == target) {
                right = mid-1
            } else if (nums[mid] > target) {
                right = mid -1
            } else if (nums[mid] < target) {
                left = mid + 1
            }
        }
        if (left == nums.size || nums[left] != target) {
            return -1
        }
        return left
    }

    fun rightbound(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size -1
        var mid = 0
        while (left <= right) {
            mid = left + (right - left) /2
            if (nums[mid] == target) {
                left = mid +1
            } else if (nums[mid] > target) {
                right = mid -1
            } else if (nums[mid] < target) {
                left = mid + 1
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1
        }
        return right
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 