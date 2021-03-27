//Given an array of intervals where intervals[i] = [starti, endi], merge all ove
//rlapping intervals, and return an array of the non-overlapping intervals that co
//ver all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics Array Sort 
// 👍 6659 👎 362

package com.miueon.leetcode.editor.en

import java.util.*
import kotlin.collections.ArrayList

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) {
            return Array(0) { IntArray(0) }
        }
        Arrays.sort(intervals) { a, b -> a[0] - b[0] }
        val res = ArrayList<IntArray>()
        res.add(intervals[0])
        for (i in 1 until intervals.size) {
            val curr = intervals[i]
            val last = res.last()
            if (curr[0] <= last[1]) {
                last[1] = maxOf(last[1], curr[1])
            } else {
                res.add(curr)
            }
        }
        val resa = Array<IntArray?>(res.size){null}

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 