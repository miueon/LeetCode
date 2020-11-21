package com.miueon.leetcode.book.other

// the key to be deleted is by the strategy of which key call the least times get/set

// the basic structure is : calledTime1Bucket <-> calledTime2Bucket <-> called3TimeBucket
// each calledTimeBucket contains a doubleLinkedList that contains node

class LFUCache(
        c:Int
) {
    class Node(
            var key:Int,
            var value:Int,
            // times stored in Node is more easily to implement
            var times:Int,
            var up:Node? = null,
            var down:Node? = null
    )
    class NodeList(node: Node) {
        // node inside
        var head:Node? = node
        var tail:Node? = node

        var last:NodeList? = null
        var next:NodeList? = null

        fun addNodeFromHead(newHead: Node) {
            newHead.down = head
            head!!.up = newHead
            head = newHead
        }

        fun isEmpty(): Boolean {
            return head == null
        }

        fun deleteNode(node: Node) {
            if (head == tail) {
                head = null
                tail = null
            } else {
                if (node == head) {
                    head = node.down
                    head!!.up  = null
                } else if (node == tail) {
                    tail = node.up
                    tail!!.down = null
                } else {
                    node.up!!.down = node.down
                    node.down!!.up = node.up
                }
            }
            node.up = null
            node.down = null
        }
    }
/*******                        *********/
    private val capacity:Int = c
    var size:Int = 0

    // a cache for node
    private val records: MutableMap<Int, Node> = HashMap()

    // get the bucket of giving node
    private val heads:MutableMap<Node, NodeList> = HashMap()

    private var headList:NodeList? = null // the leftest bucket

    fun modifyHeadList(removeNodeList: NodeList):Boolean {
        if (removeNodeList.isEmpty()) {
            if (headList == removeNodeList) {
                // the NodeList want to removed is empty & is the leftest
                headList = removeNodeList.next
                headList?.last = null
            } else {
                removeNodeList.last!!.next = removeNodeList.next
                removeNodeList.next?.last = removeNodeList.last
            }
            return true
        }
        return false // the bucket is not empty, do nothing
    }
    // function:
    // the parameter node called time is added, then
    // remove it from it oldNodeList, add it to the +1 bucket
    private fun move(node: Node, oldNodeList: NodeList) {
        oldNodeList.deleteNode(node)
        val preList = when (modifyHeadList(oldNodeList)) {
            true -> oldNodeList.last // oldNodeList is deleted, so preList is bind to the last one
            false -> oldNodeList
        }
        // nextList is represent where the node go to
        val nextList = oldNodeList.next // shouldn't use preList
        // this because the oldNodeList maybe equal to head, then preList would be null
        when (nextList) {
            null -> {
                val newList = NodeList(node)
                preList?.let {
                    it.next = newList
                }
                newList.last = preList
                headList ?: {
                    headList = newList
                }()
                heads[node] = newList
            }
            else -> {
                if (nextList.head?.times == node.times) {
                    nextList.addNodeFromHead(node)
                    heads[node] = nextList
                } else {
                    val newList = NodeList(node)
                    preList?.let {
                        it.next = newList
                    }
                    newList.last = preList
                    newList.next = nextList
                    nextList.last = newList

                    if (headList == nextList) {
                        headList = newList
                    }

                    heads[node] = newList
                }
            }
        }
    }

    operator fun set(key: Int, value: Int) {
        if (records.containsKey(key)) {
            val node = records[key]!!
            node.value = value
            node.times++
            val thisNodeList = heads[node]!!
            move(node, thisNodeList)
        } else {
            if (size == capacity) {  // maintain the size first
                val node = headList!!.tail!!
                node.value = value
                modifyHeadList(headList!!)
                records.remove(node.key)
                heads.remove(node)
                size--
            }
            val node = Node(key, value, 1)
            if (headList == null) {  // let the headList be the NodeList that can contain the new node
                headList = NodeList(node)
            } else {
                if (headList!!.head!!.times == node.times) {
                    headList!!.addNodeFromHead(node)
                } else {
                    val newList = NodeList(node)
                    newList.next = headList
                    headList!!.last = newList
                    headList = newList
                }
            }
            records[key] = node
            heads[node] = headList!!
            size++
        }
    }

    operator fun get(key: Int): Int? {
        if (!records.containsKey(key)) {
            return null
        }
        val node = records[key]!!
        node.times++
        val curNodeList = heads[node]!!

        move(node, curNodeList)

        return node.value
    }
}