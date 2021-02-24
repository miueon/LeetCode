  //
//Given a list of daily temperatures T, return a list such that, for each day in
// the input, tells you how many days you would have to wait until a warmer temper
//ature. If there is no future day for which this is possible, put 0 instead.
// 
//For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 7
//3], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
// 
//
// Note:
//The length of temperatures will be in the range [1, 30000].
//Each temperature will be an integer in the range [30, 100].
// Related Topics Hash Table Stack 
// 👍 3854 👎 118

  package com.miueon.leetcode.editor.en

  import java.util.*
  import kotlin.collections.ArrayList

  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun dailyTemperatures(T: IntArray): IntArray {
        val res = ArrayList<Int>(Collections.nCopies(T.size, 0))
        val s = Stack<Int>()
        for (i in T.size - 1 downTo 0) {
            while (s.isNotEmpty() && T[s.peek()] <= T[i]) {
                s.pop()
            }

            res[i] = when (s.empty()) {
                true -> 0
                false -> s.peek() - i
            }

            s.push(i)
        }

        return res.toIntArray()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 