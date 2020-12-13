  //Reverse a linked list from position m to n. Do it in one-pass. 
//
// Note: 1 ≤ m ≤ n ≤ length of list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL, m = 2, n = 4
//Output: 1->4->3->2->5->NULL
// 
// Related Topics Linked List 
// 👍 3036 👎 161
//
//  var cur = head
//  var prev:ListNode? = null
//  var count:Int = 1
//  var latest:ListNode? = null
//  var next:ListNode? = null
//  while (cur != null) {
//      if (count < m+1) {
//          count++
//          latest = prev
//          prev = cur
//          cur = cur.next
//      } else if (count > n) {
//          break
//      }
//      count++
//      next = cur?.next
//      cur?.next = prev
//      prev = cur
//      cur = next
//  }
//  return if (m > 1) {
//      latest?.next?.next = next
//      latest?.next = cur
//      head
//  } else if (cur != null) {
//      head?.next = next
//      cur
//  } else {
//      prev
//  }


  package com.miueon.leetcode.editor.en
  class ListNode(var `val`: Int) { var next: ListNode? = null }
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
    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        if (m == 1) {
            return reverseN(head, n)
        }
        head?.next = reverseBetween(head?.next, m-1, n-1)
        return head
    }

    var successor:ListNode? = null
    fun reverseN(head: ListNode?, n: Int): ListNode? {
        if (n == 1) {
            successor = head?.next
            return head
        }
        val result = reverseN(head?.next, n-1)
        head?.next?.next = head
        head?.next = successor
        return result
    }

}

//leetcode submit region end(Prohibit modification and deletion)

  
 