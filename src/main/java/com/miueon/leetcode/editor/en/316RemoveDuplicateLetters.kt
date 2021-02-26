  //Given a string s, remove duplicate letters so that every letter appears once a
//nd only once. You must make sure your result is the smallest in lexicographical 
//order among all possible results. 
//
// Note: This question is the same as 1081: https://leetcode.com/problems/smalle
//st-subsequence-of-distinct-characters/ 
//
// 
// Example 1: 
//
// 
//Input: s = "bcabc"
//Output: "abc"
// 
//
// Example 2: 
//
// 
//Input: s = "cbacdcbc"
//Output: "acdb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of lowercase English letters. 
// 
// Related Topics String Stack Greedy 
// 👍 2234 👎 168

  package com.miueon.leetcode.editor.en

  import java.lang.StringBuilder
  import java.util.*

  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun removeDuplicateLetters(s: String): String {
        val stk = Stack<Char>()

        val count = IntArray(256){0}
        for (element in s) {
            count[element.toInt()]++
        }
        val inStack = BooleanArray(256){false}
        for (c in s) {
            count[c.toInt()]--
            if (inStack[c.toInt()]) continue

            while (stk.isNotEmpty() && stk.peek() > c) {
                if (count[stk.peek().toInt()] == 0) {
                    break
                }
                inStack[stk.pop().toInt()] = false
            }
            stk.push(c)
            inStack[c.toInt()] = true
        }


        return with(StringBuilder()) {
            while (stk.isNotEmpty()) {
                this.append(stk.pop())
            }
            this.reverse()
        }.toString()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 