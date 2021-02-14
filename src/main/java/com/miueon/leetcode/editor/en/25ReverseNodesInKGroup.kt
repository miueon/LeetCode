  //Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list. 
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes, in the
// end, should remain as it is. 
//
// Follow up: 
//
// 
// Could you solve the problem in O(1) extra memory space? 
// You may not alter the values in the list's nodes, only nodes itself may be ch
//anged. 
// 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
// 
//
// Example 3: 
//
// 
//Input: head = [1,2,3,4,5], k = 1
//Output: [1,2,3,4,5]
// 
//
// Example 4: 
//
// 
//Input: head = [1], k = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range sz. 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics Linked List 
// 👍 3134 👎 388

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
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var a:ListNode? = head
        var b:ListNode? = head
        for (i in 1..k) {
            if (b == null) {
                return head
            }
            b = b.next // 这里的i, 对应变化的过程. 所以for结束后b为下一个group的head.
        }
        val last= reverseRange(a, b)
        head?.next = reverseKGroup(b, k)
        return last
    }
    fun reverseRange(start: ListNode?, end: ListNode?): ListNode? {
        var cur:ListNode? = start
        var prev:ListNode? = null
        var next:ListNode? = null
        while (cur != end) {
            next = cur?.next
            cur?.next = prev
            prev = cur
            cur = next
        }
        return prev
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  
 