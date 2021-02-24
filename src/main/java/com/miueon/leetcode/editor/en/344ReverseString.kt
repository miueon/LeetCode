  //Write a function that reverses a string. The input string is given as an array
// of characters char[]. 
//
// Do not allocate extra space for another array, you must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// You may assume all the characters consist of printable ascii characters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
// 
//
// 
// Example 2: 
//
// 
//Input: ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
// 
// 
// 
// Related Topics Two Pointers String 
// 👍 2103 👎 753

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun reverseString(s: CharArray): Unit {
        var left = 0
        var right = s.size -1
        var temp:Char
        while (left < right) {
//            s[left] =( s[left].toInt() xor s[right].toInt()).toChar()
//            s[right] = (s[left].toInt() xor s[right].toInt()).toChar()
//            s[left] = (s[left].toInt() xor s[right].toInt()).toChar()
            temp = s[left]
            s[left] = s[right]
            s[right] = temp
            left++
            right--
        }
        return
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 