package com.miueon.leetcode.book.other

import java.lang.RuntimeException

class Node<V>(var value: V) {
    var last: Node<V>? = null
    var next: Node<V>? = null
}

class NodeDoubleLinkedList<V>{
    private var head: Node<V>? = null // if cache full, remove head first
    private var tail: Node<V>? = null // the newest node,

    fun addNode(newNode: Node<V>?) {
        newNode ?: return
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail!!.next = newNode
            newNode.last = tail
            tail = newNode
        }
    }

    fun moveNodeToTail(node: Node<V>) {
        if (tail == node) {
            return
        }

        if (head == node) {
            head = node.next
            head!!.last = null
        } else {
            node.last!!.last = node.next
            node.next!!.last = node.last
        }
        node.last = tail
        node.next = null
        tail!!.next = node
        tail = node
    }

    fun removeHead(): Node<V>? {
        head ?: return null
        val res = head
        if (head == tail) {
            head = null
            tail = null
        } else {
            head = res!!.next
            res.next = null
            head!!.last = null
        }
        return res
    }
}

class MyCache<K, V>(val capacity: Int){
    private val keyNodeMap:MutableMap<K, Node<V>> = HashMap()
    private val nodeKeyMap:MutableMap<Node<V>, K> = HashMap()
    private val nodeList: NodeDoubleLinkedList<V> = NodeDoubleLinkedList()
    init {
        if (capacity < 1) {
            throw RuntimeException("Should be more than 0.")
        }
    }

    operator fun get(key: K): V? {
        if (keyNodeMap.containsKey(key)) {
            val res = keyNodeMap[key]!!
            nodeList.moveNodeToTail(res)
            return res.value
        }
        return null
    }

    operator fun set(key: K, value: V) {
        if (keyNodeMap.containsKey(key)) {
            val node = keyNodeMap[key]!!
            node.value = value
            nodeList.moveNodeToTail(node)
        } else {
            val newNode = Node(value)
            keyNodeMap[key] = newNode
            nodeKeyMap[newNode] = key
            nodeList.addNode(newNode)

            if (keyNodeMap.size == capacity + 1) {
                removeMostUnusedCache()
            }
        }
    }
    fun contains(key: K): Boolean {
        return keyNodeMap.contains(key)
    }

    private fun removeMostUnusedCache() {
        val removeNode = nodeList.removeHead()
        val removeKey = nodeKeyMap[removeNode]
        nodeKeyMap.remove(removeNode)
        keyNodeMap.remove(removeKey)
    }
}

fun main() {
    val cache = MyCache<String, Int>(3)
    cache["A"] = 1
    cache["B"] = 2
    cache["C"] = 3
    cache["A"]
    cache["S"] = 100
    print(cache.contains("B"))
}
