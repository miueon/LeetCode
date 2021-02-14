//Invert a binary tree.
//
// Example: 
//
// Input: 
//
// 
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// Output: 
//
// 
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// Trivia: 
//This problem was inspired by this original tweet by Max Howell: 
//
// Google: 90% of our engineers use the software you wrote (Homebrew), but you c
//an’t invert a binary tree on a whiteboard so f*** off. 
// Related Topics Tree 
// 👍 4507 👎 69
package com.miueon.leetcode.editor.en

import java.util.*

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

//leetcode submit region begin(Prohibit modification and deletion)
internal class Solution {
    fun invertTree(root: TreeNode): TreeNode {
        val tmp = root.left
        root.left = root.right

    }
//    fun invertTree(root: TreeNode?): TreeNode? {
//        if (root == null) {
//            return root
//        }
//        invertTree(root.left)
//        val tmp = root.left
//        root.left = root.right
//        root.right = tmp
//        invertTree(root.left)
//        return root
//    }

}
//leetcode submit region end(Prohibit modification and deletion)

  
 