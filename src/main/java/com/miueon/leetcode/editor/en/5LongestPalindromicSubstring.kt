  //Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters (lower-case and/or upper-case), 
//
// Related Topics String Dynamic Programming 
// 👍 9889 👎 658

  package com.miueon.leetcode.editor.en

  import java.lang.StringBuilder

  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestPalindrome(s: String): String {
        fun palindrome(s: String, l: Int, r: Int): String {
            var l = l
            var r = r
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                l--
                r++
            }
            return s.substring(l+1, r)
        }
        var res:String = ""
        for (i in 0 until s.length) {
            val s1 = palindrome(s, i, i)
            val s2 = palindrome(s, i, i+1)
            res = when (res.length > s1.length) {
                true-> res
                else -> s1
            }
            res = when (res.length > s2.length) {
                true -> res
                else -> s2
            }
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 