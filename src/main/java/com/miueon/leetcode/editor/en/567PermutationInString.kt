  //Given two strings s1 and s2, write a function to return true if s2 contains th
//e permutation of s1. In other words, one of the first string's permutations is t
//he substring of the second string. 
//
// 
//
// Example 1: 
//
// 
//Input: s1 = "ab" s2 = "eidbaooo"
//Output: True
//Explanation: s2 contains one permutation of s1 ("ba").
// 
//
// Example 2: 
//
// 
//Input:s1= "ab" s2 = "eidboaoo"
//Output: False
// 
//
// 
// Constraints: 
//
// 
// The input strings only contain lower case letters. 
// The length of both given strings is in range [1, 10,000]. 
// 
// Related Topics Two Pointers Sliding Window 
// 👍 2195 👎 77

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val need = HashMap<Char, Int>()
        val window = HashMap<Char, Int>()

        s1.forEach { need[it] = need.getOrDefault(it, 0)+1 }

        var left = 0
        var right = 0
        var valid = 0
        while (right < s2.length) {
            val c = s2[right]
            right++
            if (need.containsKey(c)) {
                window[c] = window.getOrDefault(c, 0)+1
                if (window[c] == need[c]) {
                    valid++
                }
            }

            while (right - left >= s1.length) {
                if (valid == need.size) {
                    return true
                }
                val d = s2[left]
                left++
                if (need.containsKey(d)) {
                    if (window[d] == need[d]) {
                        valid--
                    }
                    window[d] = window.getOrDefault(d, 0) - 1
                }
            }
        }
        return false
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 