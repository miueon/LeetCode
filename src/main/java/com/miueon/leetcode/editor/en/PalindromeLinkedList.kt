//Given a singly linked list, determine if it is a palindrome.
//
// Example 1: 
//
// 
//Input: 1->2
//Output: false 
//
// Example 2: 
//
// 
//Input: 1->2->2->1
//Output: true 
//
// Follow up: 
//Could you do it in O(n) time and O(1) space? 
// Related Topics Linked List Two Pointers 
// 👍 4198 👎 401

package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    //    var left:ListNode? = null
    fun isPalindrome(head: ListNode?): Boolean {
//        left = head
//        return traverse(head)
        var fast = head
        var slow = head
        while (fast != null && fast?.next != null) {
            fast = fast?.next?.next
            slow = slow?.next
        }
        if (fast != null) {
            slow = slow?.next
        }
        var q = reverse(slow)
        var p = head
        while (q != null) {
            if (q.`val` != p?.`val`) {
                return false
            }
            q = q.next
            p = p.next
        }
        return true
    }

    fun reverse(head: ListNode?): ListNode? {
        var cur = head
        var prev:ListNode? = null
        var next:ListNode? = null
        while (cur != null) {
            next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }
        return prev
    }


}
//leetcode submit region end(Prohibit modification and deletion)


//  fun traverse(head: ListNode?): Boolean {
//      if (head == null) {
//          return true
//      }
//      var res = traverse(head.next)
//      res = res and (left?.`val`  == head.`val`)
//      left = left?.next
//      return res
//  }