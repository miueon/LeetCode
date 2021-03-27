  //Given a list of intervals, remove all intervals that are covered by another in
//terval in the list. 
//
// Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
// 
//
// After doing so, return the number of remaining intervals. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,4],[3,6],[2,8]]
//Output: 2
//Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[2,3]]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: intervals = [[0,10],[5,12]]
//Output: 2
// 
//
// Example 4: 
//
// 
//Input: intervals = [[3,10],[4,10],[5,11]]
//Output: 2
// 
//
// Example 5: 
//
// 
//Input: intervals = [[1,2],[1,4],[3,4]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 1000 
// intervals[i].length == 2 
// 0 <= intervals[i][0] < intervals[i][1] <= 10^5 
// All the intervals are unique. 
// Related Topics Greedy Sort Line Sweep 
// 👍 615 👎 25

  package com.miueon.leetcode.editor.en

  import java.util.*

  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        Arrays.sort(intervals) {a, b ->
            if (a[0] == b[0]) {
                return@sort b[1] - a[1]
            }
            return@sort a[0] - b[0]
        }
        var left = intervals[0][0]
        var right = intervals[0][1]
        var res = 0
        for (i in 1 until intervals.size) {
            val intv = intervals[i]
            if (left <= intv[0] && right >= intv[1]) {
                res += 1
            }
            if (right >= intv[0] && right <= intv[1]) {
                right = intv[1]
            }
            if (right < intv[0]) {
                left = intv[0]
                right = intv[1]
            }
        }
        return intervals.size -res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 