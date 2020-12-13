package com.miueon.leetcode.book.util

import java.lang.StringBuilder

class ListNode<T>(var next: ListNode<T>?, val value: T?) {
    companion object {
        fun <T> from(vararg data: T): ListNode<T>? {
            var head: ListNode<T>? = null
            val listArray = data.map { ListNode(null, it) }
            listArray.reduce { acc, listNode ->
                {
                    acc.next = listNode
                    listNode
                }()
            }
            return listArray[0]
        }
    }

    override fun toString(): String {
        return with(StringBuilder()) {
            var cur:ListNode<T>? = this@ListNode
            while (cur != null) {
                this.append(cur.value)
                if (cur.next != null) {
                    this.append(" -> ")
                }
                cur = cur.next
            }
            this.toString()
        }
    }
}