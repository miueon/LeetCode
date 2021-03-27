//Given N axis-aligned rectangles where N > 0, determine if they all together fo
//rm an exact cover of a rectangular region. 
//
// Each rectangle is represented as a bottom-left point and a top-right point. F
//or example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-lef
//t point is (1, 1) and top-right point is (2, 2)). 
//
// 
//
// Example 1: 
//
// 
//rectangles = [
//  [1,1,3,3],
//  [3,1,4,2],
//  [3,2,4,4],
//  [1,3,2,4],
//  [2,3,3,4]
//]
//
//Return true. All 5 rectangles together form an exact cover of a rectangular re
//gion.
// 
//
// 
//
// 
//
// 
//
// Example 2: 
//
// 
//rectangles = [
//  [1,1,2,3],
//  [1,3,2,4],
//  [3,1,4,2],
//  [3,2,4,4]
//]
//
//Return false. Because there is a gap between the two rectangular regions.
// 
//
// 
//
// 
//
// 
//
// Example 3: 
//
// 
//rectangles = [
//  [1,1,3,3],
//  [3,1,4,2],
//  [1,3,2,4],
//  [3,2,4,4]
//]
//
//Return false. Because there is a gap in the top center.
// 
//
// 
//
// 
//
// 
//
// Example 4: 
//
// 
//rectangles = [
//  [1,1,3,3],
//  [3,1,4,2],
//  [1,3,2,4],
//  [2,2,4,4]
//]
//
//Return false. Because two of the rectangles overlap with each other.
// 
//
// Related Topics Line Sweep 
// 👍 449 👎 85

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun isRectangleCover(rectangles: Array<IntArray>): Boolean {
        var X1 = Int.MAX_VALUE
        var Y1 = Int.MAX_VALUE
        var X2 = Int.MIN_VALUE
        var Y2 = Int.MIN_VALUE

        val points = HashSet<Pair<Int,Int>>()
        var actual_area = 0
        for (ints in rectangles) {
            val x1 = ints[0]
            val y1 = ints[1]
            val x2 = ints[2]
            val y2 = ints[3]
            X1 = minOf(X1, ints[0])
            Y1 = minOf(Y1, ints[1])
            X2 = maxOf(X2, ints[2])
            Y2 = maxOf(Y2, ints[3])
            actual_area += (x2 - x1) * (y2 - y1)
            for (pair in listOf(x1 to y1, x1 to y2, x2 to y1, x2 to y2)) {
                if (points.contains(pair)) {
                    points.remove(pair)
                } else {
                    points.add(pair)
                }
            }
        }
        val expect_area = (X2 - X1) * (Y2 - Y1)
        if (expect_area != actual_area) {
            return false
        }
        if (points.size != 4) {
            return false
        }
        if (!points.contains(X1 to Y1)) {
            return false
        }
        if (!points.contains(X1 to Y2)) {
            return false
        }
        if (!points.contains(X2 to Y1)) {
            return false
        }
        if (!points.contains(X2 to Y2)) {
            return false
        }
        return true
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 