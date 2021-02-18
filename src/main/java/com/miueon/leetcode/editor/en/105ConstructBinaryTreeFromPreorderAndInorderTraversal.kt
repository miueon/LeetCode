//Given preorder and inorder traversal of a tree,
//construct the binary tree.
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics Array Tree Depth-first Search 
// 👍 4362 👎 112

package com.miueon.leetcode.editor.en

import java.util.*
import kotlin.collections.HashSet

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
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return build(preorder, inorder, 0, preorder.size - 1, 0,
                inorder.size - 1)
    }

    fun build(preorder: IntArray, inorder: IntArray,
              plo: Int, phi: Int, ilo: Int, ihi: Int): TreeNode? {
        if (ilo > ihi) {
            return null
        }
        val root = TreeNode(preorder[plo])
        var iroot = ilo
        for (i in ilo..ihi) {
            if (inorder[iroot] == preorder[plo]) {
                break
            }
            iroot = i
        }
        val leftSize = iroot - ilo
        val prroot = plo+leftSize +1
        root.left = build(preorder, inorder, plo+1, prroot-1, ilo, iroot-1)
        root.right =build(preorder, inorder, prroot, phi, iroot+1, ihi)
        return root

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 