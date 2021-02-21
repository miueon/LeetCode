//Design and implement a data structure for a Least Frequently Used (LFU) cache.
// 
//
// Implement the LFUCache class: 
//
// 
// LFUCache(int capacity) Initializes the object with the capacity of the data s
//tructure. 
// int get(int key) Gets the value of the key if the key exists in the cache. Ot
//herwise, returns -1. 
// void put(int key, int value) Update the value of the key if present, or inser
//ts the key if not already present. When the cache reaches its capacity, it shoul
//d invalidate and remove the least frequently used key before inserting a new ite
//m. For this problem, when there is a tie (i.e., two or more keys with the same f
//requency), the least recently used key would be invalidated. 
// 
//
// To determine the least frequently used key, a use counter is maintained for e
//ach key in the cache. The key with the smallest use counter is the least frequen
//tly used key. 
//
// When a key is first inserted into the cache, its use counter is set to 1 (due
// to the put operation). The use counter for a key in the cache is incremented ei
//ther a get or put operation is called on it. 
//
// 
// Example 1: 
//
// 
//Input
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "g
//et"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//Explanation
//// cnt(x) = the use counter for key x
//// cache=[] will show the last used order for tiebreakers (leftmost element is
//  most recent)
//LFUCache lfu = new LFUCache(2);
//lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lfu.get(1);      // return 1
//                 // cache=[1,2], cnt(2)=1, cnt(1)=2
//lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalid
//ate 2.
//                 // cache=[3,1], cnt(3)=1, cnt(1)=2
//lfu.get(2);      // return -1 (not found)
//lfu.get(3);      // return 3
//                 // cache=[3,1], cnt(3)=2, cnt(1)=2
//lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1
//.
//                 // cache=[4,3], cnt(4)=1, cnt(3)=2
//lfu.get(1);      // return -1 (not found)
//lfu.get(3);      // return 3
//                 // cache=[3,4], cnt(4)=1, cnt(3)=3
//lfu.get(4);      // return 4
//                 // cache=[3,4], cnt(4)=2, cnt(3)=3
// 
//
// 
// Constraints: 
//
// 
// 0 <= capacity, key, value <= 104 
// At most 105 calls will be made to get and put. 
// 
//
// 
//Follow up: Could you do both operations in O(1) time complexity? Related Topic
//s Design 
// 👍 1814 👎 148

package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)
class LFUCache(capacity: Int) {
    private val keyToVal = HashMap<Int, Int>()
    private val keyToFreq = HashMap<Int, Int>()
    private val freqToKeys = HashMap<Int, LinkedHashSet<Int>>()
    private var minFreq: Int = 1
    private var cap = capacity

    fun get(key: Int): Int {
        if (!keyToFreq.containsKey(key)) {
            return -1
        }

        increaseFreq(key)
        return keyToVal[key]!!
    }

    fun put(key: Int, value: Int) {
        if (this.cap <= 0) {
            return
        }
        if (keyToFreq.containsKey(key)) {
            keyToVal[key] = value
            increaseFreq(key)
            return
        }

        if (this.cap <= keyToVal.size) {
            removeMinFreq()
        }

        keyToVal[key] = value
        keyToFreq[key] = 1
        freqToKeys.putIfAbsent(1, LinkedHashSet())
        freqToKeys[1]!!.add(key)
        this.minFreq = 1
    }

    private fun removeMinFreq() {
        val minKeys = freqToKeys[minFreq]
        val deletedKey = minKeys!!.iterator().next()
        minKeys.remove(deletedKey)
        if (minKeys.isEmpty()) {
            freqToKeys.remove(this.minFreq)
        }
        keyToVal.remove(deletedKey)
        keyToFreq.remove(deletedKey)
    }

    private fun increaseFreq(key: Int) {
        val freq = keyToFreq[key]!!
        keyToFreq[key] = freq + 1
        freqToKeys[freq]!!.remove(key)
        freqToKeys.putIfAbsent(freq+1, LinkedHashSet())
        freqToKeys[freq+1]!!.add(key)
        if (freqToKeys[freq]!!.isEmpty()) {
            freqToKeys.remove(freq)
            if (freq == this.minFreq) {
                this.minFreq++
            }
        }
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * var obj = LFUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
//leetcode submit region end(Prohibit modification and deletion)

  
 