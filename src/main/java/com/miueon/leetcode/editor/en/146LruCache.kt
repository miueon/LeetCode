  //Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise ret
//urn -1. 
// void put(int key, int value) Update the value of the key if the key exists. O
//therwise, add the key-value pair to the cache. If the number of keys exceeds the
// capacity from this operation, evict the least recently used key. 
// 
//
// Follow up: 
//Could you do get and put in O(1) time complexity? 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// At most 3 * 104 calls will be made to get and put. 
// 
// Related Topics Design 
// 👍 7803 👎 320

  package com.miueon.leetcode.editor.en

  //leetcode submit region begin(Prohibit modification and deletion)
  class LRUCache(capacity: Int) {
      //    val cache:LinkedHashMap<Int, Int> = LinkedHashMap()
//    val cap = capacity
//    fun get(key: Int): Int {
//        if (!cache.containsKey(key)) {
//            return -1
//        }
//        makeRecently(key)
//        return cache[key]!!
//    }
//
//    fun put(key: Int, value: Int) {
//        if (cache.containsKey(key)) {
//            cache[key] = value
//            makeRecently(key)
//            return
//        }
//
//        if (cache.size >= this.cap) {
//            // the head of list is the least used key
//            val oldestKey = cache.keys.iterator().next()
//            cache.remove(oldestKey)
//        }
//
//        cache[key] = value
//    }
//
//    private fun makeRecently(key: Int): Unit {
//        val v = cache[key]
//        cache.remove(key)
//        cache[key] = v!!
//    }
      private val map: HashMap<Int, Node> = HashMap()
      private val cache = DoubleList()
      private val cap: Int = capacity

      fun get(key: Int): Int {
          if (!map.containsKey(key)) {
              return -1
          }
          makeRecently(key)
          return map[key]!!.v
      }

      fun put(k: Int, v: Int) {
          if (map.containsKey(k)) {
              deleteKey(k)
              addRecently(k, v)
              return
          }

          if (cap == cache.size()) {
              removeLeastRecently()
          }

          addRecently(k, v)
      }

      private fun makeRecently(key: Int) {
          val x = map[key]
          cache.remove(x!!)
          cache.addLast(x)
      }

      private fun addRecently(key: Int, v: Int) {
          val x = Node(key, v)
          cache.addLast(x)
          map[key] = x
      }

      private fun deleteKey(key: Int) {
          val x = map[key]
          cache.remove(x!!)
          map.remove(key)
      }

      private fun removeLeastRecently() {
          val deleteNode = cache.removeFirst()
          val deletedKey = deleteNode!!.key
          map.remove(deletedKey)
      }

      internal class Node(val key: Int, val v: Int
      ) {
          var next: Node? = null
          var prev: Node? = null
      }

      internal class DoubleList {
          private val head: Node = Node(0, 0)
          private val tail: Node = Node(0, 0)
          private var size: Int

          init {
              head.next = tail
              tail.prev = head
              size = 0
          }

          fun addLast(x: Node) {
              x.prev = tail.prev
              x.next = tail
              tail.prev!!.next = x
              tail.prev = x
              size++
          }

          fun remove(x: Node) {
              x.prev!!.next = x.next
              x.next!!.prev = x.prev
              size--
          }

          fun removeFirst(): Node? {
              if (head.next == tail) {
                  return null
              }
              val first = head.next
              remove(first!!)
              return first
          }

          fun size(): Int {
              return size
          }
      }

  }

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
//leetcode submit region end(Prohibit modification and deletion)

  
 