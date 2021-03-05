//Given two strings s1, s2, find the lowest ASCII sum of deleted characters to m
//ake two strings equal. 
//
// Example 1: 
// 
//Input: s1 = "sea", s2 = "eat"
//Output: 231
//Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the 
//sum.
//Deleting "t" from "eat" adds 116 to the sum.
//At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum pos
//sible to achieve this.
// 
// 
//
// Example 2: 
// 
//Input: s1 = "delete", s2 = "leet"
//Output: 403
//Explanation: Deleting "dee" from "delete" to turn the string into "let",
//adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to
// the sum.
//At the end, both strings are equal to "let", and the answer is 100+101+101+101
// = 403.
//If instead we turned both strings into "lee" or "eet", we would get answers of
// 433 or 417, which are higher.
// 
// 
//
// Note:
// 0 < s1.length, s2.length <= 1000. 
// All elements of each string will have an ASCII value in [97, 122]. 
// Related Topics Dynamic Programming 
// 👍 1247 👎 54

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val memo = Array(s1.length) { IntArray(s2.length) { -1 } }
        fun dp(s1: String, i: Int, s2: String, j: Int): Int {
            var res = 0
            if (i == s1.length) {
                for (ix in j until s2.length) {
                    res += s2[ix].toInt()
                    return res
                }
            }
            if (j == s2.length) {
                for (ix in i until s1.length) {
                    res += s1[ix].toInt()
                    return res
                }
            }
            if (memo[i][j] != -1) {
                return memo[i][j]
            }

            if (s1[i] == s2[j]) {
                memo[i][j] = dp(s1, i + 1, s2, j + 1)
            } else {
                memo[i][j] = minOf(
                    s1[i].toInt() + dp(s1, i + 1, s2, j),
                    s2[j].toInt() + dp(s1, i, s2, j + 1)
                )
            }
            return memo[i][j]
        }
        return dp(s1, 0, s2, 0)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 