//Given two strings word1 and word2, return the minimum number of operations req
//uired to convert word1 to word2. 
//
// You have the following three operations permitted on a word: 
//
// 
// Insert a character 
// Delete a character 
// Replace a character 
// 
//
// 
// Example 1: 
//
// 
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation: 
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
// 
//
// Example 2: 
//
// 
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation: 
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
// 
//
// 
// Constraints: 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 and word2 consist of lowercase English letters. 
// 
// Related Topics String Dynamic Programming 
// 👍 5217 👎 66

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minDistance(word1: String, word2: String): Int {
//        val memo = HashMap<String, Int>()
//        fun dp(i: Int, j: Int): Int {
//            if (i == -1) {
//                return j + 1
//            }
//            if (j == -1) {
//                return i + 1
//            }
//            val key = "$i,$j"
//            if (memo.containsKey(key)) {
//                return memo[key]!!
//            }
//           memo[key] = if (word1[i] == word2[j]) {
//               dp(i - 1, j - 1)
//            } else {
//                 minOf(dp(i, j - 1) + 1,
//                    dp(i - 1, j) + 1, dp(i - 1, j - 1) + 1)
//            }
//            return memo[key]!!
//        }
//        return dp(word1.length -1, word2.length-1)
        val m = word1.length
        val n = word2.length
        val dp = Array(m+1){IntArray(n+1){0} }
        for (i in 1..m) {
            dp[i][0] = i
        }
        for (j in 1..n) {
            dp[0][j] = j
        }
        for (i in 1..m) {
            for (j in 1..n) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = minOf(
                        dp[i-1][j] +1,
                        dp[i][j-1]+1,
                        dp[i-1][j-1]+1
                    )
                }
            }
        }
        return dp[m][n]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 