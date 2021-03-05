  //Given a singly linked list, return a random node's value from the linked list.
// Each node must have the same probability of being chosen. 
//
// 
// Example 1: 
//
// 
//Input
//["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
//[[[1, 2, 3]], [], [], [], [], []]
//Output
//[null, 1, 3, 2, 2, 3]
//
//Explanation
//Solution solution = new Solution([1, 2, 3]);
//solution.getRandom(); // return 1
//solution.getRandom(); // return 3
//solution.getRandom(); // return 2
//solution.getRandom(); // return 2
//solution.getRandom(); // return 3
//// getRandom() should return either 1, 2, or 3 randomly. Each element should h
//ave equal probability of returning.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the linked list will be in the range [1, 104] 
// -104 <= Node.val <= 104 
// At most 104 calls will be made to getRandom. 
// 
//
// 
// Follow up: 
//
// 
// What if the linked list is extremely large and its length is unknown to you? 
//
// Could you solve this efficiently without using extra space? 
// 
// Related Topics Reservoir Sampling 
// 👍 884 👎 233

  package com.miueon.leetcode.editor.en

  import java.util.*

  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution(head: ListNode?) {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
   val head = head

    /** Returns a random node's value. */
    fun getRandom(): Int {
        val r = Random()
        var i = 0
        var res = 0
        var p = this.head
        while (p != null) {
            if (r.nextInt(++i) == 0) {
                res = p.`val`
            }
            p = p.next
        }
        return res
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(head)
 * var param_1 = obj.getRandom()
 */
//leetcode submit region end(Prohibit modification and deletion)

  
 