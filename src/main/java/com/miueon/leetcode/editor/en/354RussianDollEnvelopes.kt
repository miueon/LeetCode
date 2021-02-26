//You have a number of envelopes with widths and heights given as a pair of inte
//gers (w, h). One envelope can fit into another if and only if both the width and
// height of one envelope is greater than the width and height of the other envelo
//pe. 
//
// What is the maximum number of envelopes can you Russian doll? (put one inside
// other) 
//
// Note: 
//Rotation is not allowed. 
//
// Example: 
//
// 
// 
//Input: [[5,4],[6,4],[6,7],[2,3]]
//Output: 3 
//Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] 
//=> [5,4] => [6,7]).
// 
// 
// fucked Topics Binary Search Dynamic Programming
// 👍 1599 👎 50

package com.miueon.leetcode.editor.en

import java.util.*

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        val n = envelopes.size
        Arrays.sort(envelopes) { a: IntArray, b: IntArray ->
            when (a[0] == b[0]) {
                true -> b[1] - a[1]
                else -> a[0] - b[0]
            }
        }
        val height = IntArray(n) { 0 }
        for (i in 0 until n) {
            height[i] = envelopes[i][1]
        }
        return lengthOfLIS(height)
    }

    fun lengthOfLIS(nums: IntArray): Int {
        var piles = 0
        val n = nums.size
        val top = IntArray(n){0}
        for (i in 0 until n) {
            val poker = nums[i]
            var left = 0
            var right = piles
            while (left < right) {
                val mid = (left + right) /2
                if (top[mid] >= poker) {
                    right = mid
                } else {
                    left = mid+1
                }
            }
            if (left == piles) {
                piles++
            }
            top[left] = poker
        }
        return piles
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 