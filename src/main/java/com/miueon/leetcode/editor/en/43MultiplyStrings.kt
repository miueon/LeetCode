//Given two non-negative integers num1 and num2 represented as strings, return t
//he product of num1 and num2, also represented as a string. 
//
// Note: You must not use any built-in BigInteger library or convert the inputs 
//to integer directly. 
//
// 
// Example 1: 
// Input: num1 = "2", num2 = "3"
//Output: "6"
// Example 2: 
// Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
// 
// Constraints: 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 and num2 consist of digits only. 
// Both num1 and num2 do not contain any leading zero, except the number 0 itsel
//f. 
// 
// Related Topics Math String 
// 👍 2309 👎 961

package com.miueon.leetcode.editor.en

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun multiply(num1: String, num2: String): String {
        val m = num1.length
        val n = num2.length
        val res = ArrayList<Int>(Collections.nCopies(n + m, 0))
        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                val mul = (num1[i] - '0') * (num2[j] - '0')
                val p1 = i + j
                val p2 = i + j + 1
                val sum = mul + res[p2]
                res[p2] = sum % 10
                res[p1] += sum / 10
            }
        }
        var i = 0
        while (i < res.size && res[i] == 0) {
            i++
        }
        val str = with(StringBuilder()) {
            for (ix in i until res.size) {
                this.append('0' + res[ix])
            }
            this.toString()
        }
        return if (str.isNotEmpty()) {
            str
        } else "0"

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 