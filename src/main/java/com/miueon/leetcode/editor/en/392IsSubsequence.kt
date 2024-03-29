//Given two strings s and t, check if s is a subsequence of t.
//
// A subsequence of a string is a new string that is formed from the original st
//ring by deleting some (can be none) of the characters without disturbing the rel
//ative positions of the remaining characters. (i.e., "ace" is a subsequence of "a
//bcde" while "aec" is not). 
//
// 
// Example 1: 
// Input: s = "abc", t = "ahbgdc"
//Output: true
// Example 2: 
// Input: s = "axc", t = "ahbgdc"
//Output: false
// 
// 
// Constraints: 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 104 
// s and t consist only of lowercase English letters. 
// 
//
// 
//Follow up: If there are lots of incoming s, say s1, s2, ..., sk where k >= 109
//, and you want to check one by one to see if t has its subsequence. In this scen
//ario, how would you change your code? Related Topics Binary Search Dynamic Progr
//amming Greedy 
// 👍 2261 👎 229

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        val m = s.length
        val n = t.length
        val index = Array<ArrayList<Int>?>(256) {null}
        for (i in 0 until n) {
            val c = t[i]
            if (index[c.toInt()] == null) {
                index[c.toInt()] = ArrayList()
            }
            index[c.toInt()]!!.add(i)
        }
        var j = 0
        for (i in 0 until m) {
            val c= s[i]
            if (index[c.toInt()] == null) {
                return false
            }
            val pos = left_bound(index[c.toInt()]!!, j)
            if (pos == index[c.toInt()]!!.size) {
                return false
            }
            j = index[c.toInt()]!![pos] +1
        }
        return true
    }

    fun left_bound(list: ArrayList<Int>, j: Int): Int {
        var lo = 0
        var hi = list.size
        var mid:Int
        while (lo < hi) {
            mid = (hi + lo) /2
            if (list[mid] < j) {
               lo = mid +1
            } else if (list[mid] > j) {
                hi = mid
            } else {
                hi = mid
            }
        }
        return lo
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 