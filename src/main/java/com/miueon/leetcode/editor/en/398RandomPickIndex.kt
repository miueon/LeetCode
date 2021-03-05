//Given an array of integers with possible duplicates, randomly output the index
// of a given target number. You can assume that the given target number must exis
//t in the array. 
//
// Note: 
//The array size can be very large. Solution that uses too much extra space will
// not pass the judge. 
//
// Example: 
//
// 
//int[] nums = new int[] {1,2,3,3,3};
//Solution solution = new Solution(nums);
//
//// pick(3) should return either index 2, 3, or 4 randomly. Each index should h
//ave equal probability of returning.
//solution.pick(3);
//
//// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
//solution.pick(1);
// 
// Related Topics Reservoir Sampling 
// 👍 619 👎 805

package com.miueon.leetcode.editor.en

import java.util.*

//leetcode submit region begin(Prohibit modification and deletion)
class Solution(nums: IntArray) {
    val nums = nums
    fun pick(target: Int): Int {
        val r = Random()
        var res = 0
        var ix = 0
        nums.forEachIndexed{
            index, i ->
            if (i == target) {
                if (r.nextInt(++ix) == 0) {
                    res = index
                }
            }
        }
        return res
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(nums)
 * var param_1 = obj.pick(target)
 */
//leetcode submit region end(Prohibit modification and deletion)

  
 