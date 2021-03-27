  //There are n flights that are labeled from 1 to n. 
//
// You are given an array of flight bookings bookings, where bookings[i] = [firs
//ti, lasti, seatsi] represents a booking for flights firsti through lasti (inclus
//ive) with seatsi seats reserved for each flight in the range. 
//
// Return an array answer of length n, where answer[i] is the total number of se
//ats reserved for flight i. 
//
// 
// Example 1: 
//
// 
//Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//Output: [10,55,45,25,25]
//Explanation:
//Flight labels:        1   2   3   4   5
//Booking 1 reserved:  10  10
//Booking 2 reserved:      20  20
//Booking 3 reserved:      25  25  25  25
//Total seats:         10  55  45  25  25
//Hence, answer = [10,55,45,25,25]
// 
//
// Example 2: 
//
// 
//Input: bookings = [[1,2,10],[2,2,15]], n = 2
//Output: [10,25]
//Explanation:
//Flight labels:        1   2
//Booking 1 reserved:  10  10
//Booking 2 reserved:      15
//Total seats:         10  25
//Hence, answer = [10,25]
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2 * 104 
// 1 <= bookings.length <= 2 * 104 
// bookings[i].length == 3 
// 1 <= firsti <= lasti <= n 
// 1 <= seatsi <= 104 
// 
// Related Topics Array Math 
// 👍 642 👎 121

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
        class Difference(nums:IntArray){
            private val diff:IntArray
            init {
                assert(nums.isNotEmpty())
                diff = IntArray(nums.size)
                diff[0] = nums[0]
                for (i in 1 until nums.size) {
                    diff[i] = nums[i] - nums[i-1]
                }
            }

            fun increment(i: Int, j: Int, value: Int) {
                diff[i] += value
                if (j + 1 < diff.size) {
                    diff[j+1] -= value
                }
            }
            fun result(): IntArray {
                val res = IntArray(diff.size)
                res[0] = diff[0]
                for (i in 1 until diff.size) {
                    res[i] = res[i-1] + diff[i]
                }
                return res
            }
        }
        val nums = IntArray(n){0}
        val df = Difference(nums)
        for (booking in bookings) {
            val i = booking[0] -1
            val j = booking[1] - 1
            val value = booking[2]
            df.increment(i, j, value)
        }
        return df.result()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 