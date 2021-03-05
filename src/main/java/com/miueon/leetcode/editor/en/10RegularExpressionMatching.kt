//Given an input string (s) and a pattern (p), implement regular expression matc
//hing with support for '.' and '*' where: 
//
// 
// '.' Matches any single character. 
// '*' Matches zero or more of the preceding element. 
// 
//
// The matching should cover the entire input string (not partial). 
//
// 
// Example 1: 
//
// 
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input: s = "aa", p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// Example 4: 
//
// 
//Input: s = "aab", p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, i
//t matches "aab".
// 
//
// Example 5: 
//
// 
//Input: s = "mississippi", p = "mis*is*p*."
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '.', and '*'. 
// It is guaranteed for each appearance of the character '*', there will be a pr
//evious valid character to match. 
// 
// Related Topics String Dynamic Programming Backtracking 
// 👍 5418 👎 829

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun isMatch(s: String, p: String): Boolean {
       val memo = HashMap<String, Boolean>()
        fun dp(i: Int, j: Int): Boolean {
            val key = "$i,$j"
            if (memo.containsKey(key)) {
                return memo[key]!!
            }
            if (j == p.length) {
                return i==s.length
            }
            val first = (i < s.length) && when (p[j]) {
                s[i],'.' -> true
                else -> false
            }
            val ans  = if ((j <= p.length - 2) && (p[j + 1] == '*')) {
                dp(i, j + 2) || first && dp(i + 1, j)
            } else {
                first && dp(i+1, j+1)
            }
            memo[key] = ans
            return ans
        }
        return dp(0, 0)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 