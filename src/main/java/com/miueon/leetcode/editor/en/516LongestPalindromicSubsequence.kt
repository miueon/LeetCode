//Given a string s, find the longest palindromic subsequence's length in s.
//
// A subsequence is a sequence that can be derived from another sequence by dele
//ting some or no elements without changing the order of the remaining elements. 
//
// 
// Example 1: 
//
// 
//Input: s = "bbbab"
//Output: 4
//Explanation: One possible longest palindromic subsequence is "bbbb".
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: 2
//Explanation: One possible longest palindromic subsequence is "bb".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists only of lowercase English letters. 
// 
// Related Topics Dynamic Programming 
// 👍 2851 👎 214

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestPalindromeSubseq(s: String): Int {
        val n = s.length
        val dp = Array(n) { IntArray(n) { 0 } }
        for (i in 0 until n) {
            dp[i][i] = 1
        }
        for (i in n - 1 downTo 0) {
            for (j in i + 1 until n) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2
                } else {
                    dp[i][j] = maxOf(dp[i + 1][j], dp[i][j - 1])
                }
            }
        }
        return dp[0][n - 1]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 