  //Given a string s which represents an expression, evaluate this expression and 
//return its value. 
//
// The integer division should truncate toward zero. 
//
// 
// Example 1: 
// Input: s = "3+2*2"
//Output: 7
// Example 2: 
// Input: s = " 3/2 "
//Output: 1
// Example 3: 
// Input: s = " 3+5 / 2 "
//Output: 5
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 105 
// s consists of integers and operators ('+', '-', '*', '/') separated by some n
//umber of spaces. 
// s represents a valid expression. 
// All the integers in the expression are non-negative integers in the range [0,
// 231 - 1]. 
// The answer is guaranteed to fit in a 32-bit integer. 
// 
// Related Topics String Stack 
// 👍 2190 👎 344

  package com.miueon.leetcode.editor.en

  import java.util.*

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

  
 