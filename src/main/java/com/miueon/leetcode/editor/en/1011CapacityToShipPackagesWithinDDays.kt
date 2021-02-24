/*
 * @lc app=leetcode id=1011 lang=kotlin
 *
 * [1011] Capacity To Ship Packages Within D Days
 */
// leetcode submit region begin(Prohibit modification and deletion)
// @lc code=start
class Solution {
    fun shipWithinDays(weights: IntArray, D: Int): Int {
        var left = getMax(weights)
        var right = getSum(weights) + 1
        var mid = 0
       while (left <= right) {
           mid = left + (right - left) / 2
           if (canFinish(weights, D, mid)) {
              right = mid - 1
           } else {
               left = mid + 1
           }
       }
       return left

   }

   fun getMax(w: IntArray): Int {
       var max = w[0]
       for (i in w) {
           max = Math.max(i, max)
       }
       return max
   }

    fun getSum(w: IntArray): Int {
        var sum = 0
        w.forEach { sum += it }
        return sum
    }

    fun canFinish(w: IntArray, D: Int, cap: Int): Boolean {
        //        var i = 0
        //        for (day in 0 until D) {
        //            var maxCap = cap
        //            maxCap -= w[i]
        //            while (maxCap >= 0) {
        //                i++
        //                if (i == w.size) {
        //                    return true
        //                }
        //                maxCap -= w[i]
        //            }
        //        }
        //        return false
        var i = 0
        for (day in 0 until D) {
            var maxCap = cap
            while (w[i].let {
                maxCap -= it
                maxCap
            } >= 0) {
                i++
                if (i == w.size) return true
            }
        }
        return false
    }
}
// @lc code=end
// leetcode submit region end(Prohibit modification and deletion)
