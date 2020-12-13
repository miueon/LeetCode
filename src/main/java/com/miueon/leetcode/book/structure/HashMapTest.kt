package com.miueon.leetcode.book.structure

/**
 * title: HashMapTest

 * Author: Miueon

 * Date: 2020-12-12 4:16 p.m.

 * Version 1.0
 */
class HashMapTest<T, R> {
    class Node<T,R>(val key:T?, val value:R?, var next:Node<T,R>?){
        operator fun set(key: T, value: R) {
            val newNode= Node(key, value, this.next)
            this.next = newNode
        }

        operator fun get(key: T): R? {
            return if (this.key!=null && key == this.key) {
                value!!
            } else {
                when (this.next) {
                    null -> null
                    else -> {
                        this.next!![key]
                    }
                }
            }
        }

        fun contains(key: T):Boolean = this[key] != null

        fun remove(key: T): R? {
            var prev:Node<T,R>?  = this
            var cur:Node<T,R>? = this
            var result:R? = null
            while (cur != null) {
                if (cur.key == key) {
                    result = cur.value
                    prev!!.next = cur.next
                    break
                }
                prev = cur
                cur  = cur.next

            }
            return result
        }
    }
    val capacity = 17
    lateinit var array:Array<Node<T,R>>
    constructor(){
        array = Array(capacity){Node<T,R>(null,null, null)}
    }

    private fun index(key:T) =  key.hashCode() % capacity

    operator fun set(key: T, value: R) {
        val index = index(key)
        array[index][key] = value
    }

    operator fun get(key: T): R? {
        val index = index(key)
        return array[index][key]
    }

    fun contains(key: T): Boolean {
        val index = index(key)
        return array[index].contains(key)
    }

    fun remove(key: T): R? {
        val index = index(key)
        return array[index].remove(key)
    }
}

fun main() {
    val failed = "you failed."
    val test = HashMapTest<Int, String>()


    for (i in 1..100) {
        test[i] = "fuck china $i times"
    }
    for (i in 1..100) {
        if (!test.contains(i)) {
            println(failed)
        } else if (test[i] != "fuck china $i times") {
            println(failed)
        }

    }
    for (i in 1..100) {
        if (test.contains(i)) {
            println(failed)
        }
    }
}
