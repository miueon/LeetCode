  //Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table Two Pointers String Sliding Window 
// 👍 13219 👎 687

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val window = HashMap<Char, Int>()

        var left = 0
        var right = 0
        var res = 0
        while (right < s.length) {
            val c = s[right]
            right++

            window[c] = window.getOrDefault(c, 0)+1
            while (window[c]!! > 1) {
                val d = s[left]
                left++
                window[d] = window.getOrDefault(d, 0) - 1
            }
            res = Math.max(right -left, res)
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 