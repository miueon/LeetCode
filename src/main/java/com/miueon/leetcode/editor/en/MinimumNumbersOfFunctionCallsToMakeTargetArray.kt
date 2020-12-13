  //
//
// Your task is to form an integer array nums from an initial array of zeros arr
// that is the same size as nums. 
//
// Return the minimum number of function calls to make nums from arr. 
//
// The answer is guaranteed to fit in a 32-bit signed integer. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5]
//Output: 5
//Explanation: Increment by 1 (second element): [0, 0] to get [0, 1] (1 operatio
//n).
//Double all the elements: [0, 1] -> [0, 2] -> [0, 4] (2 operations).
//Increment by 1 (both elements)  [0, 4] -> [1, 4] -> [1, 5] (2 operations).
//Total of operations: 1 + 2 + 2 = 5.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2]
//Output: 3
//Explanation: Increment by 1 (both elements) [0, 0] -> [0, 1] -> [1, 1] (2 oper
//ations).
//Double all the elements: [1, 1] -> [2, 2] (1 operation).
//Total of operations: 2 + 1 = 3.
// 
//
// Example 3: 
//
// 
//Input: nums = [4,2,5]
//Output: 6
//Explanation: (initial)[0,0,0] -> [1,0,0] -> [1,0,1] -> [2,0,2] -> [2,1,2] -> [
//4,2,4] -> [4,2,5](nums).
// 
//
// Example 4: 
//
// 
//Input: nums = [3,2,2,4]
//Output: 7
// 
//
// Example 5: 
//
// 
//Input: nums = [2,4,8,16]
//Output: 8
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10^5 
// 0 <= nums[i] <= 10^9 
// 
// Related Topics Greedy 
// 👍 211 👎 14

  package com.miueon.leetcode.editor.en

  import kotlin.math.max

  //leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {
    fun minOperations(nums: IntArray): Int {
//        var odds:Int = 0
//        var maxEven:Int = 0
//
//        for (item in nums) {
//            var oddCount = 0
//            var evenCount = 0
//
//            var n = item
//            while (n > 0) {
//                if (n % 2 == 1) {
//                    oddCount++
//                    n -= 1
//                } else {
//                    evenCount ++
//                    n /= 2
//                }
//            }
//            odds += oddCount
//            maxEven = Math.max(maxEven, evenCount)
//        }
//
//        return maxEven + odds
        var addCount = 0
        var doubleCount = 0
        var tmpDoubleCount:Int
        for (item in nums) {
            if (item != 0) {
                addCount++
            }
            tmpDoubleCount = 0
            var i = item
            while (i > 1) {
                addCount += i and 1
                tmpDoubleCount ++
                i = i shr 1
            }
            doubleCount = Math.max(tmpDoubleCount, doubleCount)
        }
        return doubleCount + addCount
    }
}

  // Where is the "greedy" hides?
  // as you can see, the double op is the most efficiency way to achieve big number
  // but it can't achieve the odd number, so we need the add op. and each add op counts for final answer
  // so the last thing left over is how much double op needs since double op affect all value
  // the answer is depends on the number contains most even number.
//leetcode submit region end(Prohibit modification and deletion)

  
 