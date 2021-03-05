//Let f(x) be the number of zeroes at the end of x!. (Recall that x! = 1 * 2 * 3
// * ... * x, and by convention, 0! = 1.) 
//
// For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) = 
//2 because 11! = 39916800 has 2 zeroes at the end. Given K, find how many non-neg
//ative integers x have the property that f(x) = K. 
//
// 
//Example 1:
//Input: K = 0
//Output: 5
//Explanation: 0!, 1!, 2!, 3!, and 4! end with K = 0 zeroes.
//
//Example 2:
//Input: K = 5
//Output: 0
//Explanation: There is no x such that x! ends in K = 5 zeroes.
// 
//
// Note: 
//
// 
// K will be an integer in the range [0, 10^9]. 
// 
// Related Topics Binary Search 
// 👍 211 👎 61

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun preimageSizeFZF(K: Int): Int {
        fun trailingZeroes(n: Long): Long {
            var res: Long = 0
            var d = n
            while (d / 5 > 0) {
                res += d / 5
                d /= 5
            }
            return res
        }

        fun left_bound(): Long {
            var lo: Long = 0
            var hi = Long.MAX_VALUE
            while (lo < hi) {
                val mid = lo + (hi - lo) / 2
                val tmp = trailingZeroes(mid)
                if (tmp < K) {
                    lo = mid + 1
                } else if (tmp > K) {
                    hi = mid
                } else {
                    hi = mid
                }
            }
            return lo
        }
        fun right_bound(): Long {
            var lo:Long = 0
            var hi = Long.MAX_VALUE
            while (lo < hi) {
                val mid = lo + (hi - lo)/2
                val tmp = trailingZeroes(mid)
                when {
                    tmp < K -> lo = mid+1
                    tmp > K -> hi = mid
                    else -> lo = mid +1
                }
            }
            return lo-1
        }
        return (right_bound() - left_bound() + 1).toInt()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 