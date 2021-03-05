//
//Given two words word1 and word2, find the minimum number of steps required to 
//make word1 and word2 the same, where in each step you can delete one character i
//n either string.
// 
//
// Example 1: 
// 
//Input: "sea", "eat"
//Output: 2
//Explanation: You need one step to make "sea" to "ea" and another step to make 
//"eat" to "ea".
// 
// 
//
// Note: 
// 
// The length of given words won't exceed 500. 
// Characters in given words can only be lower-case letters. 
// 
// Related Topics String 
// 👍 1400 👎 34

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length
        val lcs = longestCommonSubsquence(word1, word2)
        return m - lcs + n - lcs
    }

    fun longestCommonSubsquence(s1: String, s2: String): Int {
        val m = s1.length
        val n = s2.length
        val dp = Array(m+1) { IntArray(n+1) { 0 } }
        for (i in 1..m) {
            for (j in 1..n) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                } else {
                    dp[i][j] = maxOf(dp[i][j - 1], dp[i - 1][j])
                }
            }
        }
        return dp[m][n]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 