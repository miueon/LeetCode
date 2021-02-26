  //Given an array nums, write a function to move all 0's to the end of it while m
//aintaining the relative order of the non-zero elements. 
//
// Example: 
//
// 
//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0] 
//
// Note: 
//
// 
// You must do this in-place without making a copy of the array. 
// Minimize the total number of operations. 
// Related Topics Array Two Pointers 
// 👍 5098 👎 158

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        val p = removeElement(nums, 0)
        for (i in p until nums.size){
            nums[i] = 0
        }
    }
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var fast = 0
        var slow = 0
        while (fast < nums.size) {
            if (nums[fast] != `val`) {
                nums[slow] = nums[fast]
                slow++
            }
            fast++
        }
        return slow
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 