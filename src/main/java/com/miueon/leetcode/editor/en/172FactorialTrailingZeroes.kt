  //Given an integer n, return the number of trailing zeroes in n!. 
//
// Follow up: Could you write a solution that works in logarithmic time complexi
//ty? 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: 0
//Explanation: 3! = 6, no trailing zero.
// 
//
// Example 2: 
//
// 
//Input: n = 5
//Output: 1
//Explanation: 5! = 120, one trailing zero.
// 
//
// Example 3: 
//
// 
//Input: n = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 104 
// 
// Related Topics Math 
// 👍 1203 👎 1356

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun trailingZeroes(n: Int): Int {
        var res = 0
        var d= n
        while (d / 5 > 0) {
            res+= d/5
            d /= 5
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 