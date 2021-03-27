//Find the kth largest element in an unsorted array. Note that it is the kth lar
//gest element in the sorted order, not the kth distinct element. 
//
// Example 1: 
//
// 
//Input: [3,2,1,5,6,4] and k = 2
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: [3,2,3,1,2,4,5,5,6] and k = 4
//Output: 4 
//
// Note: 
//You may assume k is always valid, 1 ≤ k ≤ array's length. 
// Related Topics Divide and Conquer Heap 
// 👍 5226 👎 336

package com.miueon.leetcode.editor.en

import java.util.*

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        //        val pq = PriorityQueue<Int>()
//        for (e in nums) {
//            pq.offer(e)
//            if (pq.size > k) {
//                pq.poll()
//            }
//        }
//        return pq.poll()

        val swap: (Int, Int) -> Unit = { i, j ->
            val tmp = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp
        }
        val shuffle: (Unit) -> Unit = {
            val n = nums.size
            val rand = Random()
            for (i in 0 until n) {
                val r = i + rand.nextInt(n-i)
                swap(i, r)
            }
        }
        shuffle(Unit)
        fun partition(lo: Int, hi: Int): Int {
            if (lo == hi) {
                return lo
            }
            val pivot = nums[lo]
            var i = lo
            var j = hi + 1
            while (true) {
                while (nums[++i] < pivot) {
                    if (i == hi) {
                        break
                    }
                }
                while (nums[--j] > pivot) {
                    if (j == lo) {
                        break
                    }
                }
                if (i >= j) {
                    break
                }
                swap(i, j)
            }
            swap(lo, j)
            return j
        }

        var lo = 0
        var hi = nums.size - 1
        val k = nums.size - k
        while (lo <= hi) {
            val p = partition(lo, hi)
            if (p < k) {
                lo = p + 1
            } else if (p > k) {
                hi = p - 1
            } else {
                return nums[p]
            }
        }
        return -1
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 