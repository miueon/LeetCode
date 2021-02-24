  //
//Given a circular array (the next element of the last element is the first elem
//ent of the array), print the Next Greater Number for every element. The Next Gre
//ater Number of a number x is the first greater number to its traversing-order ne
//xt in the array, which means you could search circularly to find its next greate
//r number. If it doesn't exist, output -1 for this number.
// 
//
// Example 1: 
// 
//Input: [1,2,1]
//Output: [2,-1,2]
//Explanation: The first 1's next greater number is 2; The number 2 can't find n
//ext greater number; The second 1's next greater number needs to search circularl
//y, which is also 2.
// 
// 
//
// Note:
//The length of given array won't exceed 10000.
// Related Topics Stack 
// 👍 2190 👎 88

  package com.miueon.leetcode.editor.en

  import java.util.*
  import kotlin.collections.ArrayList

  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val n = nums.size
        val res = IntArray(n)
        val s = Stack<Int>()
        for (i in 2 * n - 1 downTo 0) {
            while (!s.empty() && s.peek() <= nums[i % n]) {
                s.pop()
            }
            res[i % n] = if (s.empty()) {
                -1
            } else s.peek()
            s.push(nums[i % n])
        }

        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 