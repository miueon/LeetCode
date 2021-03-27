  //Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
//
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are
// being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics Array Two Pointers Dynamic Programming Stack 
// 👍 10225 👎 157

  package com.miueon.leetcode.editor.en

  import java.util.*
  import kotlin.collections.ArrayList

  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun trap(height: IntArray): Int {
//        if (height.isEmpty()) {
//            return 0
//        }
//        val n = height.size
//        var res = 0
//        val lmx = ArrayList<Int>(Collections.nCopies(n, 0))
//        val rmx = IntArray(n){0}
//        lmx[0] = height[0]
//        rmx[n-1] = height[n-1]
//        for (i in 1 until n) {
//            lmx[i] = maxOf(height[i], lmx[i-1])
//        }
//        for (i in n - 2 downTo 0) {
//            rmx[i] = maxOf(height[i], rmx[i+1])
//        }
//        for (i in 1 until n - 1) {
//
//            res += minOf(lmx[i], rmx[i]) - height[i]
//        }
//        return res
        if (height.isEmpty()) {
            return 0
        }
        val n = height.size
        var left = 0
        var right = n-1
        var res = 0
        var l_max = height[0]
        var r_max = height[n-1]
        while (left <= right) {
            l_max = maxOf(l_max, height[left])
            r_max = maxOf(r_max, height[right])
            if (l_max < r_max) {
                res += l_max - height[left]
                left++
            } else {
                res += r_max - height[right]
                right--
            }
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 