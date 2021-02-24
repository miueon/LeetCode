  //Given a string s and a non-empty string p, find all the start indices of p's a
//nagrams in s. 
//
// Strings consists of lowercase English letters only and the length of both str
//ings s and p will not be larger than 20,100. 
//
// The order of output does not matter. 
//
// Example 1:
// 
//Input:
//s: "cbaebabacd" p: "abc"
//
//Output:
//[0, 6]
//
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
// 
//
// Example 2:
// 
//Input:
//s: "abab" p: "ab"
//
//Output:
//[0, 1, 2]
//
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
// Related Topics Hash Table 
// 👍 3916 👎 198

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        val need = HashMap<Char,Int>()
        val window = HashMap<Char, Int>()
        p.forEach { need[it] = need.getOrDefault(it, 0)+1 }
        var left = 0
        var right = 0
        var valid = 0
        val res = ArrayList<Int>()
        while (right < s.length) {
            val c = s[right]
            right++
            if (need.containsKey(c)) {
                window[c] = window.getOrDefault(c, 0)+1
                if (window[c] == need[c]) {
                    valid++
                }
            }

            while (right - left >= p.length) {
                if (valid == need.size) {
                    res.add(left)
                }
                val d = s[left]
                left++
                if (need.containsKey(d)) {
                    if (window[d] == need[d]) {
                        valid--
                    }
                    window[d] = window.getOrDefault(d, 0)-1
                }
            }
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 