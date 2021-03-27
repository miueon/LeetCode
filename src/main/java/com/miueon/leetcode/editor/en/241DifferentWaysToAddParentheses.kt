//Given a string of numbers and operators, return all possible results from comp
//uting all the different possible ways to group numbers and operators. The valid 
//operators are +, - and *. 
//
// Example 1: 
//
// 
//Input: "2-1-1"
//Output: [0, 2]
//Explanation: 
//((2-1)-1) = 0 
//(2-(1-1)) = 2 
//
// Example 2: 
//
// 
//Input: "2*3-4*5"
//Output: [-34, -14, -10, -10, 10]
//Explanation: 
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// Related Topics Divide and Conquer 
// 👍 2081 👎 110

package com.miueon.leetcode.editor.en

import java.util.*
import kotlin.collections.HashMap

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    val memo = HashMap<String, List<Int>>()
    fun diffWaysToCompute(input: String): List<Int> {
        if (memo.containsKey(input)) {
            return memo[input]!!
        }
        val res = LinkedList<Int>()
        for (i in 0 until input.length) {
            val c = input[i]
            if (c == '-' || c == '+' || c == '*') {
                val left = diffWaysToCompute(input.substring(0, i))
                val right = diffWaysToCompute(input.substring(i+1))
                for (a in left) {
                    for (b in right) {
                        if (c == '+') {
                            res.add(a + b)
                        } else if (c == '-') {
                            res.add(a - b)
                        } else {
                            res.add(a * b)
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(input.toInt())
        }
        memo[input] = res
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 