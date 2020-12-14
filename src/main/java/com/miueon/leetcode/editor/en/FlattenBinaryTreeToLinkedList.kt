  //Given a binary tree, flatten it to a linked list in-place. 
//
// For example, given the following tree: 
//
// 
//    1
//   / \
//  2   5
// / \   \
//3   4   6
// 
//
// The flattened tree should look like: 
//
// 
//1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// 
// Related Topics Tree Depth-first Search 
// 👍 3581 👎 377

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
    fun flatten(root: TreeNode?): Unit {
        if (root == null) {
            return
        }
        flatten(root.left)
        flatten(root.right)

        var left = root.left
        var right = root.right
        root.left = null
        root.right = left

        var ptr = root
        while (ptr?.right != null) {
            ptr = ptr.right
        }
        ptr?.right = right
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 