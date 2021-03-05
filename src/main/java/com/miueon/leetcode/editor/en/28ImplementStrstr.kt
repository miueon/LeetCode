//Implement strStr().
//
// Return the index of the first occurrence of needle in haystack, or -1 if need
//le is not part of haystack. 
//
// Clarification: 
//
// What should we return when needle is an empty string? This is a great questio
//n to ask during an interview. 
//
// For the purpose of this problem, we will return 0 when needle is an empty str
//ing. This is consistent to C's strstr() and Java's indexOf(). 
//
// 
// Example 1: 
// Input: haystack = "hello", needle = "ll"
//Output: 2
// Example 2: 
// Input: haystack = "aaaaa", needle = "bba"
//Output: -1
// Example 3: 
// Input: haystack = "", needle = ""
//Output: 0
// 
// 
// Constraints: 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack and needle consist of only lower-case English characters. 
// 
// Related Topics Two Pointers String 
// 👍 2189 👎 2270

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        val dp = Array(needle.length) { IntArray(256) { 0 } }
        val N = haystack.length
        val M = needle.length
        if (M == 0) {
            return 0
        }
        dp[0][needle[0].toInt()] = 1
        var X = 0
        for (i in 1 until M) {
            for (c in 0 until 256) {
                dp[i][c] = dp[X][c]
            }
            dp[i][needle[i].toInt()] = i+1
            X = dp[X][needle[i].toInt()]
        }

        var j = 0
        for (i in 0 until N) {
            j = dp[j][haystack[i].toInt()]
            if (j == M) {
                return i- M + 1
            }
        }
        return -1
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 