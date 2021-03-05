//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics String Backtracking 
// 👍 7226 👎 313

package com.miueon.leetcode.editor.en

import java.util.*
import kotlin.collections.ArrayList

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun generateParenthesis(n: Int): List<String> {
        if (n == 0) {
            return listOf()
        }
        val res = ArrayList<String>()

        fun Stack<Char>.toStr(): String = with(StringBuilder()) {
            for (i in this@toStr) {
                append(i)
            }
            toString()
        }

        val track = Stack<Char>()
        fun backtrack(left: Int, right: Int) {
            if (right < left) {
                return
            }
            if (left < 0 || right < 0) {
                return
            }
            if (left == 0 && right == 0) {
                res.add(track.toStr())
                return
            }

            track.push('(')
            backtrack(left - 1, right)
            track.pop()

            track.push(')')
            backtrack(left, right -1)
            track.pop()
        }
        backtrack(n, n)
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 