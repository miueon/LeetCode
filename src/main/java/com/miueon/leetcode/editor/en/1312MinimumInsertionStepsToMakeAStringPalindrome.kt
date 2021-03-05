  //Given a string s. In one step you can insert any character at any index of the
// string. 
//
// Return the minimum number of steps to make s palindrome. 
//
// A Palindrome String is one that reads the same backward as well as forward. 
//
// 
// Example 1: 
//
// 
//Input: s = "zzazz"
//Output: 0
//Explanation: The string "zzazz" is already palindrome we don't need any insert
//ions.
// 
//
// Example 2: 
//
// 
//Input: s = "mbadm"
//Output: 2
//Explanation: String can be "mbdadbm" or "mdbabdm".
// 
//
// Example 3: 
//
// 
//Input: s = "leetcode"
//Output: 5
//Explanation: Inserting 5 characters the string becomes "leetcodocteel".
// 
//
// Example 4: 
//
// 
//Input: s = "g"
//Output: 0
// 
//
// Example 5: 
//
// 
//Input: s = "no"
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 500 
// All characters of s are lower case English letters. 
// 
// Related Topics Dynamic Programming 
// 👍 666 👎 12

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minInsertions(s: String): Int {
        val n = s.length
        val dp = Array(n){IntArray(n){0} }
        for (i in n - 2 downTo 0) {
            for (j in i + 1 until n) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1]
                } else {
                    dp[i][j] = minOf(dp[i+1][j], dp[i][j-1]) + 1
                }
            }
        }
        return dp[0][n-1]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 