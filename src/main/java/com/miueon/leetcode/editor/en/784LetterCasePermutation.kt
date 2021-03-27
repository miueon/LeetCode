//Given a string S, we can transform every letter individually to be lowercase o
//r uppercase to create another string. 
//
// Return a list of all possible strings we could create. You can return the out
//put in any order. 
//
// 
// Example 1: 
//
// 
//Input: S = "a1b2"
//Output: ["a1b2","a1B2","A1b2","A1B2"]
// 
//
// Example 2: 
//
// 
//Input: S = "3z4"
//Output: ["3z4","3Z4"]
// 
//
// Example 3: 
//
// 
//Input: S = "12345"
//Output: ["12345"]
// 
//
// Example 4: 
//
// 
//Input: S = "0"
//Output: ["0"]
// 
//
// 
// Constraints: 
//
// 
// S will be a string with length between 1 and 12. 
// S will consist only of letters or digits. 
// 
// Related Topics Backtracking Bit Manipulation 
// 👍 1980 👎 123

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun letterCasePermutation(S: String): List<String> {
        val res = HashSet<String>()
        fun backtrack(s: String, p: Int) {
            if (p == s.length) {
                res.add(s)
                return
            }

            if (s[p].isLetter()) {
                backtrack(
                    s.substring(0, p) + (s[p].toInt() xor ' '.toInt()).toChar() +
                            s.substring(p + 1), p + 1
                )

            }
            backtrack(s, p + 1)
        }

        backtrack(S, 0)
        return res.toList()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 