package com.miueon.leetcode.book.List

import com.miueon.leetcode.book.util.ListNode

/**
 *
 * title: ReverSeList
 *
 * Author: Miueon
 *
 * Date: 2020-12-07 1:42 p.m.
 *
 * Version 1.0
 */
private typealias node<T> = ListNode<T>
class ReverseList<T> {
    fun reverseList(head: node<T>?):node<T> {
        var prev:node<T>? = null
        var cur:node<T>? = head
        var nxt:node<T>? = null
        while (cur != null) {
            nxt = cur.next
            cur.next = prev
            prev = cur
            cur = nxt
        }
        return prev!!
    }

    fun reverseListRecursiveWay(head: node<T>?): node<T>? {
        if (head?.next == null) {
            return head
        }
        val reversedHead = reverseListRecursiveWay(head.next)
        val cur = head
        cur.next?.next = cur
        cur.next = null
        return reversedHead
    }
}

fun main() {
    var testData = ListNode.from(1, 2, 3, 4, 5, 6)
    println(testData)
   testData =  ReverseList<Int>().reverseListRecursiveWay(testData)
    println(testData)
}
