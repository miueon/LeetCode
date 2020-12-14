//Given the root of a binary tree, return all duplicate subtrees.
//
// For each kind of duplicate subtrees, you only need to return the root node of
// any one of them. 
//
// Two trees are duplicate if they have the same structure with the same node values.
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,null,2,4,null,null,4]
//Output: [[2,4],[4]]
// 
//
// Example 2: 
//
// 
//Input: root = [2,1,1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = [2,2,2,3,null,3,null]
//Output: [[2,3],[3]]
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the tree will be in the range [1, 10^4] 
// -200 <= Node.val <= 200 
// 
// Related Topics Tree 
// 👍 1651 👎 223

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
    val structure: MutableMap<String, Int> = HashMap()
    val result: MutableList<TreeNode> = ArrayList()

    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        traverse(root)
        return result.toList()
    }

    fun traverse(root: TreeNode?): String {
        if (root == null) {
            return "#"
        }

        val left = traverse(root.left)
        val right = traverse(root.right)

        val res = "$left,$right,${root.`val`}"
        val count = structure.getOrDefault(res, 0)
        if (count == 1) {
            result.add(root)
        }
        structure[res] = count + 1
        return res
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  
 