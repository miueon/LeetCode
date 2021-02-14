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
// 👍 4420 👎 409

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
        // using fast , slow ptr to find the center of a linkedlist
        var fast = head
        var slow = head
        while (fast != null && fast?.next != null) {
            fast = fast?.next?.next
            slow = slow?.next
        }
        // now slow ptr is point to the center
        if (fast != null) {
            // if fast isnt point to null, this indicates that the size of list is odd and
                //slow ptr need one step forward
            slow = slow?.next
        }
        // reverse the right part of the list
        var q = reverse(slow)
        var p = head
        // now p, q can start compare
        while (q != null) {
            if (q.`val` != p?.`val`) {
                return false
            }
            q = q.next
            p = p.next
        }
        // if you want to restore the structure of this list,
        // p.next = reverse(q) where p is the last node of left part, q is the head of
        // reversed right part
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

  
 