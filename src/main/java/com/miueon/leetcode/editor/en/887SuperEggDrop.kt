//You are given K eggs, and you have access to a building with N floors from 1 t
//o N. 
//
// Each egg is identical in function, and if an egg breaks, you cannot drop it a
//gain. 
//
// You know that there exists a floor F with 0 <= F <= N such that any egg dropp
//ed at a floor higher than F will break, and any egg dropped at or below floor F 
//will not break. 
//
// Each move, you may take an egg (if you have an unbroken one) and drop it from
// any floor X (with 1 <= X <= N). 
//
// Your goal is to know with certainty what the value of F is. 
//
// What is the minimum number of moves that you need to know with certainty what
// F is, regardless of the initial value of F? 
//
// 
//
// 
// 
//
// 
// Example 1: 
//
// 
//Input: K = 1, N = 2
//Output: 2
//Explanation: 
//Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
//Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty th
//at F = 1.
//If it didn't break, then we know with certainty F = 2.
//Hence, we needed 2 moves in the worst case to know what F is with certainty.
// 
//
// 
// Example 2: 
//
// 
//Input: K = 2, N = 6
//Output: 3
// 
//
// 
// Example 3: 
//
// 
//Input: K = 3, N = 14
//Output: 4
// 
//
// 
//
// Note: 
//
// 
// 1 <= K <= 100 
// 1 <= N <= 10000 
// 
// 
// 
// 
// Related Topics Math Binary Search Dynamic Programming 
// 👍 1256 👎 97

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun superEggDrop(K: Int, N: Int): Int {
//        val memo = HashMap<String, Int>()
//        fun dp(K: Int, N: Int): Int {
//            if (K == 1) {
//                return N
//            }
//            if (N == 0) {
//                return 0
//            }
//            val key = "$K,$N"
//            if (memo.containsKey(key)) {
//                return memo[key]!!
//            }
//            var res = Int.MAX_VALUE
////            for (i in 1..N) {
////                res = minOf(
////                    res,
////                    maxOf(
////                        dp(K, N - i),
////                        dp(K - 1, i - 1)
////                    ) + 1
////                )
////            }
//            var lo = 1
//            var hi = N
//            while (lo <= hi) {
//                val mid = (lo + hi)/ 2
//                val broken = dp(K-1, mid-1)
//                val un_broken = dp(K, N-mid)
//                res = if (broken > un_broken) {
//                    hi = mid - 1
//                    minOf(res, broken + 1)
//                } else {
//                    lo = mid +1
//                    minOf(res, un_broken+1)
//                }
//            }
//            memo[key] = res
//            return res
//        }
//        return dp(K, N)
        val dp = Array(K + 1) { IntArray(N + 1) { 0 } }
        var m = 0
        while (dp[K][m] < N) {
            m++
            for (k in 1..K) {
                dp[k][m] = dp[k][m-1] + dp[k-1][m-1]+1
            }
        }
        return m
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 