  //Given a non negative integer number num. For every numbers i in the range 0 ≤ 
//i ≤ num calculate the number of 1's in their binary representation and return th
//em as an array. 
//
// Example 1: 
//
// 
//Input: 2
//Output: [0,1,1] 
//
// Example 2: 
//
// 
//Input: 5
//Output: [0,1,1,2,1,2]
// 
//
// Follow up: 
//
// 
// It is very easy to come up with a solution with run time O(n*sizeof(integer))
//. But can you do it in linear time O(n) /possibly in a single pass? 
// Space complexity should be O(n). 
// Can you do it like a boss? Do it without using any builtin function like __bu
//iltin_popcount in c++ or in any other language. 
// Related Topics Dynamic Programming Bit Manipulation 
// 👍 2960 👎 174

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class CountingBitsSolution {
    fun countBits(num: Int): IntArray {
        // 这个dp点在于 不是 dp[i] by dp[i-1], 这提醒了, dp不总是1..N序列递推!
        val countBitArray = IntArray(num+1)
        // keyPoint: 每一个数字的二进制表示和其上一个最接近的 2的幂次数的关系
        // 1. 该数字就是2 的幂次, -> 1
        // 2. 一般数字 k,[ 2^i  k  2^(i-1) ], 即 k = 1_(i-1) (k- 2^(i-1))->2
        countBitArray[0] = 0
        var kPresent = 1
        var kNext = 1
        for (i in 1..num) {
            when (i) {
                kNext->{
                    countBitArray[i] = 1
                    kPresent = kNext
                    kNext *=2
                }
                else -> {
                    countBitArray[i] = 1 + countBitArray[i-kPresent]
                }
            }
        }
        return countBitArray
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 