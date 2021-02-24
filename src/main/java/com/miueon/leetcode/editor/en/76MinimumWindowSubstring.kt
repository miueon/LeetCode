  //Given two strings s and t, return the minimum window in s which will contain a
//ll the characters in t. If there is no such window in s that covers all characte
//rs in t, return the empty string "". 
//
// Note that If there is such a window, it is guaranteed that there will always 
//be only one unique minimum window in s. 
//
// 
// Example 1: 
// Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
// Example 2: 
// Input: s = "a", t = "a"
//Output: "a"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 105 
// s and t consist of English letters. 
// 
//
// 
//Follow up: Could you find an algorithm that runs in O(n) time? Related Topics 
//Hash Table Two Pointers String Sliding Window 
// 👍 6064 👎 411

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minWindow(s: String, t: String): String {
        val need = HashMap<Char, Int>()
        val window = HashMap<Char, Int>()
        t.forEach { need[it] = need.getOrDefault(it, 0)+1 }

        var left =0
        var right = 0
        var valid = 0
        var start = 0
        var len = Int.MAX_VALUE
        while (right < s.length) {
            val c = s[right]
            right++
            if (need.containsKey(c)) {
                window[c] = window.getOrDefault(c, 0) + 1
                if (window[c] == need[c]) {
                    valid++
                }
            }

            while (valid == need.size) {
                if (right - left < len) {
                    start = left
                    len = right -left
                }

                val d = s[left]
                left++
                if (need.containsKey(d)) {
                    if (window[d] == need[d]) {
                        valid--
                    }
                    window[d] = window.getOrDefault(d, 0) -1
                }
            }
        }
        return if (len == Int.MAX_VALUE) {
            ""
        } else {
            s.substring(start, start+len )
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  
 