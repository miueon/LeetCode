//Given a string s representing an expression, implement a basic calculator to e
//valuate it. 
//
// 
// Example 1: 
//
// 
//Input: s = "1 + 1"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: s = " 2-1 + 2 "
//Output: 3
// 
//
// Example 3: 
//
// 
//Input: s = "(1+(4+5+2)-3)+(6+8)"
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 105 
// s consists of digits, '+', '-', '(', ')', and ' '. 
// s represents a valid expression. 
// 
// Related Topics Math Stack 
// 👍 2051 👎 163

package com.miueon.leetcode.editor.en

import java.util.*
import kotlin.collections.ArrayList

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun calculate(s: String): Int {
        fun helper(s: LinkedList<Char>): Int {
            val stack = Stack<Int>()
            var sign = '+'
            var num = 0

            while (s.isNotEmpty()) {
                val c = s.removeFirst()
                if (c.isDigit()) {
                    num = 10 * num + (c - '0')
                }
                if (c == '(') {
                    num = helper(s)
                }
                if (!c.isDigit() && c != ' ' || s.isEmpty()) {
                    when (sign) {
                        '+' -> stack.push(num)
                        '-' -> stack.push(-num)
                        '*' -> stack.push(stack.pop() * num)
                        '/' -> stack.push(stack.pop() / num)
                    }
                    num = 0
                    sign = c
                }
                if (c == ')') {
                    break
                }
            }
            return stack.sum()
        }
        return helper(LinkedList(s.toList()))
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 