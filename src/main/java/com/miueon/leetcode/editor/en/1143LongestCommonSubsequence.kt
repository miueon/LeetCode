//Given two strings text1 and text2, return the length of their longest common s
//ubsequence. 
//
// A subsequence of a string is a new string generated from the original string 
//with some characters(can be none) deleted without changing the relative order of
// the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is
// not). A common subsequence of two strings is a subsequence that is common to bo
//th strings. 
//
// 
//
// If there is no common subsequence, return 0. 
//
// 
// Example 1: 
//
// 
//Input: text1 = "abcde", text2 = "ace" 
//Output: 3  
//Explanation: The longest common subsequence is "ace" and its length is 3.
// 
//
// Example 2: 
//
// 
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
// 
//
// Example 3: 
//
// 
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// The input strings consist of lowercase English characters only. 
// 
// Related Topics Dynamic Programming 
// 👍 2593 👎 31

package com.miueon.leetcode.editor.en

import java.util.*

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val m = text1.length
        val n = text2.length
        val memo = Array(m){IntArray(n){0} }
        for (row in memo) {
            Arrays.fill(row, -1)
        }
        fun dp(s1: String, i: Int, s2: String, j: Int): Int {
            if (i == s1.length || j == s2.length) {
                return 0
            }
            if (memo[i][j] != -1) {
                return memo[i][j]
            }
            if (s1[i] == s2[j]) {
                memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1)
            } else {
                memo[i][j] = Math.max(
                    dp(s1, i + 1, s2, j),
                    dp(s1, i, s2, j+1)
                )
            }
            return memo[i][j]
        }
        return dp(text1, 0, text2, 0)

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 