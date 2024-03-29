  //Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: s = "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: s = "{[]}"
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of parentheses only '()[]{}'. 
// 
// Related Topics String Stack 
// 👍 6951 👎 287

  package com.miueon.leetcode.editor.en

  import java.util.*

  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun isValid(s: String): Boolean {
        val left = Stack<Char>()
        fun leftOf(c: Char) = when (c) {
            '}' -> '{'
            ')' -> '('
            else -> '['
        }
        for (c in s) {
            if (c == '(' || c == '{' || c == '[') {
                left.push(c)
            } else {
                if (!left.empty() && leftOf(c) == left.peek()) {
                    left.pop()
                } else {
                    return false
                }
            }
        }
        return left.isEmpty()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 