  //Given a binary tree, find its minimum depth. 
//
// The minimum depth is the number of nodes along the shortest path from the roo
//t node down to the nearest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: root = [2,null,3,null,4,null,5,null,6]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 105]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Depth-first Search Breadth-first Search 
// 👍 2196 👎 796

  package com.miueon.leetcode.editor.en

  import java.util.*

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
    fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
         val q:Queue<TreeNode?> = LinkedList()
        q.offer(root)
        var depth = 1

        while (q.isNotEmpty()) {
            val sz = q.size

            for (i in 0 until sz) {
                val cur = q.poll()
                if (cur!!.left == null && cur!!.right == null) {
                    return depth
                }
                if (cur!!.left != null) {
                    q.offer(cur.left)
                }
                if (cur!!.right != null) {
                    q.offer(cur.right)
                }
            }
            depth++
        }
        return depth
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 