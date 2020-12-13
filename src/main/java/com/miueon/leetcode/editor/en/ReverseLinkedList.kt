  //Reverse a singly linked list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
// 
//
// Follow up: 
//
// A linked list can be reversed either iteratively or recursively. Could you im
//plement both? 
// Related Topics Linked List 
// 👍 5716 👎 109

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
///**
// * Example:
// * var li = ListNode(5)
// * var v = li.`val`
// * Definition for singly-linked list.
// * class ListNode(var `val`: Int) {
// *     var next: ListNode? = null
// * }
// */
//class Solution {
//    fun reverseList_recurve(head: ListNode?): ListNode? {
//        if (head == null || head.next == null) {
//            return head
//        }
//        val newHead = reverseList(head.next)
//        head.next.next = head
//        head.next = null
//        return newHead
//    }
//    fun reverseList(head: ListNode?): ListNode? {
//        var prev:ListNode? = null
//        var curr:ListNode? = head
//        var nxt:ListNode? = null
//        while (curr != null) {
//            nxt = curr.next
//            curr.next = prev
//            prev = curr
//            curr = nxt
//        }
//        return prev
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

  
 