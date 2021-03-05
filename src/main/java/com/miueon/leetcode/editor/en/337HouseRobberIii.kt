//The thief has found himself a new place for his thievery again. There is only
//one entrance to this area, called the "root." Besides the root, each house has o
//ne and only one parent house. After a tour, the smart thief realized that "all h
//ouses in this place forms a binary tree". It will automatically contact the poli
//ce if two directly-linked houses were broken into on the same night. 
//
// Determine the maximum amount of money the thief can rob tonight without alert
//ing the police. 
//
// Example 1: 
//
// 
//Input: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//Output: 7 
//Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7. 
//
// Example 2: 
//
// 
//Input: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//Output: 9
//Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
// Related Topics Dynamic Programming Tree Depth-first Search 
// 👍 3786 👎 65

package com.miueon.leetcode.editor.en


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun rob(root: TreeNode?): Int {
        val memo = HashMap<TreeNode, Int>()

        fun sub_rob(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }
            if (memo.containsKey(root)) {
                return memo[root!!]!!
            }
            val do_it = root.`val` +
                    ((if (root.left == null) 0 else sub_rob(root.left.left) + sub_rob(root.left.right))
                            + if (root.right == null) 0 else sub_rob(root.right.left) + sub_rob(root.right.right))
            val no_do = sub_rob(root.left) + sub_rob(root.right)
            val res = maxOf(do_it, no_do)
            memo[root] = res
            return res
        }
        return sub_rob(root)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 