  //Koko loves to eat bananas. There are N piles of bananas, the i-th pile has pil
//es[i] bananas. The guards have gone and will come back in H hours. 
//
// Koko can decide her bananas-per-hour eating speed of K. Each hour, she choose
//s some pile of bananas, and eats K bananas from that pile. If the pile has less 
//than K bananas, she eats all of them instead, and won't eat any more bananas dur
//ing this hour. 
//
// Koko likes to eat slowly, but still wants to finish eating all the bananas be
//fore the guards come back. 
//
// Return the minimum integer K such that she can eat all the bananas within H h
//ours. 
//
// 
// Example 1: 
// Input: piles = [3,6,7,11], H = 8
//Output: 4
// Example 2: 
// Input: piles = [30,11,23,4,20], H = 5
//Output: 30
// Example 3: 
// Input: piles = [30,11,23,4,20], H = 6
//Output: 23
// 
// 
// Constraints: 
//
// 
// 1 <= piles.length <= 10^4 
// piles.length <= H <= 10^9 
// 1 <= piles[i] <= 10^9 
// 
// Related Topics Binary Search 
// 👍 1296 👎 81

  package com.miueon.leetcode.editor.en

import sun.jvm.hotspot.code.CompressedStream


  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      fun minEatingSpeed(piles: IntArray, H: Int): Int {
          // 套用搜索左侧边界的算法框架
          // 套用搜索左侧边界的算法框架
          var left = 1
          var right = getMax(piles) + 1
          while (left < right) {
              // 防止溢出
              val mid = left + (right - left) / 2
              if (canFinish(piles, mid, H)) {
                  right = mid
              } else {
                  left = mid + 1
              }
          }
          return left
      }

    fun getMax(piles: IntArray):Int {
        var max = 0
        for (n in piles) max = Math.max(n, max)
        return max
    }

      fun canFinish(piles: IntArray, speed: Int, H: Int): Boolean {
          var time = 0
          for (n in piles) {
              time += consumed(n, speed)
          }
          return time <= H
      }

    fun consumed(n: Int, speed: Int): Int {
        return n / speed + if (n % speed > 0) 1 else 0
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 