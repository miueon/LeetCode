  //Given a blacklist B containing unique integers from [0, N), write a function t
//o return a uniform random integer from [0, N) which is NOT in B. 
//
// Optimize it such that it minimizes the call to system’s Math.random(). 
//
// Note: 
//
// 
// 1 <= N <= 1000000000 
// 0 <= B.length < min(100000, N) 
// [0, N) does NOT include N. See interval notation. 
// 
//
// Example 1: 
//
// 
//Input: 
//["Solution","pick","pick","pick"]
//[[1,[]],[],[],[]]
//Output: [null,0,0,0]
// 
//
// Example 2: 
//
// 
//Input: 
//["Solution","pick","pick","pick"]
//[[2,[]],[],[],[]]
//Output: [null,1,1,1]
// 
//
// Example 3: 
//
// 
//Input: 
//["Solution","pick","pick","pick"]
//[[3,[1]],[],[],[]]
//Output: [null,0,0,2]
// 
//
// Example 4: 
//
// 
//Input: 
//["Solution","pick","pick","pick"]
//[[4,[2]],[],[],[]]
//Output: [null,1,3,1]
// 
//
// Explanation of Input Syntax: 
//
// The input is two lists: the subroutines called and their arguments. Solution'
//s constructor has two arguments, N and the blacklist B. pick has no arguments. A
//rguments are always wrapped with a list, even if there aren't any. 
// Related Topics Hash Table Binary Search Sort Random 
// 👍 402 👎 73

  package com.miueon.leetcode.editor.en

  import kotlin.random.Random

  //leetcode submit region begin(Prohibit modification and deletion)
class Solution(N: Int, blacklist: IntArray) {
    val sz:Int
    val mapping = HashMap<Int, Int>()
    fun pick(): Int {
        val index =(Math.random() * sz).toInt() % sz
        if (mapping.containsKey(index)) {
            return mapping[index]!!
        }
        return index
    }
    init {
        sz = N - blacklist.size
        for (b in blacklist) {
            mapping[b] = 123
        }

        var last = N -1
        for (b in blacklist) {
            if (b >= sz) {
                continue
            }
            while (mapping.containsKey(last)) {
                last--
            }

            mapping[b] = last
            last--
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(N, blacklist)
 * var param_1 = obj.pick()
 */
//leetcode submit region end(Prohibit modification and deletion)

  
 