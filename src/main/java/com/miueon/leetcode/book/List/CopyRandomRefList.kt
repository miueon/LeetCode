package com.miueon.leetcode.book.List

class Node(val value:Int = 0){
    var next:Node? = null
    var rand:Node? = null
}

fun copyListWithRand1(head: Node?) :Node?{
    val oldNewMap:MutableMap<Node, Node> = HashMap()
    var copyNode:Node
    var cur = head
    while (cur != null) {
        copyNode = Node(cur.value)
        oldNewMap[cur] = copyNode
        cur = cur.next
    }
    cur = head
    while (cur != null) {
        oldNewMap[cur]?.next = oldNewMap[cur.next]
        oldNewMap[cur]?.rand = oldNewMap[cur.rand]
        cur = cur.next
    }
    cur?.let { return oldNewMap[cur] } ?: return null
}

fun copyListWithRand2(head: Node?): Node? {
    var cur  = head
    var res:Node? = null
    var copyNode:Node?
    while (cur != null) {
        copyNode = Node(cur.value)
        copyNode.next = cur.next
        cur.next = copyNode
        cur = copyNode.next
    }

    cur = head
    while (cur != null) {
        cur.next?.rand = cur.rand
        cur = cur.next?.next
    }

    cur = head
    copyNode = cur?.next
    res = copyNode
    while (cur != null) {
        cur.next = cur.next?.next
        copyNode?.next = copyNode?.next?.next

        cur = cur.next
        copyNode = copyNode?.next
    }
    return res
}