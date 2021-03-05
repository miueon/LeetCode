//Given a collection of intervals, find the minimum number of intervals you need
// to remove to make the rest of the intervals non-overlapping. 
//
// 
// 
//
// 
//
// Example 1: 
//
// 
//Input: [[1,2],[2,3],[3,4],[1,3]]
//Output: 1
//Explanation: [1,3] can be removed and the rest of intervals are non-overlappin
//g.
// 
//
// Example 2: 
//
// 
//Input: [[1,2],[1,2],[1,2]]
//Output: 2
//Explanation: You need to remove two [1,2] to make the rest of intervals non-ov
//erlapping.
// 
//
// Example 3: 
//
// 
//Input: [[1,2],[2,3]]
//Output: 0
//Explanation: You don't need to remove any of the intervals since they're alrea
//dy non-overlapping.
// 
//
// 
//
// Note: 
//
// 
// You may assume the interval's end point is always bigger than its start point
//. 
// Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap
// each other. 
// 
// Related Topics Greedy 
// 👍 1882 👎 51

package com.miueon.leetcode.editor.en

import java.util.*

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        fun intervalSchedule(intvs: Array<IntArray>): Int {
            if (intvs.size == 0) {
                return 0
            }
            Arrays.sort(intvs) { a, b ->
                a[1] - b[1]
            }
            var count = 1
            var x_end = intvs[0][1]
            for (interval in intvs) {
                val start = interval[0]
                if (start >= x_end) {
                    count +=1
                    x_end = interval[1]
                }
            }
            return count
        }
        return intervals.size - intervalSchedule(intervals)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 