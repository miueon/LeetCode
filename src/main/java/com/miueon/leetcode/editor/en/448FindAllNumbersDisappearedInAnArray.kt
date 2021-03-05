//Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elemen
//ts appear twice and others appear once. 
//
// Find all the elements of [1, n] inclusive that do not appear in this array. 
//
// Could you do it without extra space and in O(n) runtime? You may assume the r
//eturned list does not count as extra space. 
//
// Example:
// 
//Input:
//[4,3,2,7,8,2,3,1]
//
//Output:
//[5,6]
// 
// Related Topics Array 
// 👍 3907 👎 284

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val count = IntArray(nums.size + 1){ 0}
        nums.forEach { count[it]++ }
        val res = ArrayList<Int>()
        for (i in 1..nums.size) {
            if (count[i] == 0) {
                res.add(i)
            }
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 