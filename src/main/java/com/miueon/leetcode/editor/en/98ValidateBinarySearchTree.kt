  //Given the root of a binary tree, determine if it is a valid binary search tree
// (BST). 
//
// A valid BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics Tree Depth-first Search Recursion 
// 👍 4970 👎 602

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
    fun isValidBST(root: TreeNode?): Boolean {
        return isValidByRange(root, null, null)
    }
    fun isValidByRange(root: TreeNode?, min: TreeNode?, max: TreeNode?): Boolean {
        // in recursion, get info by return is complicated. but add info by argument is easy
        // and, things are also relative, just like a force always have a counter force
        // in this case, we want the root bigger than the min node of left tree, and
        // smaller than the max node of right tree. so, it is equals to the left tree smaller
        // than the root and so do the right tree.
        if (root == null) {
            return true
        }
        if (min != null && root.`val`!! <= min.`val`!!) return false
        if (max != null && root.`val`!! >= max.`val`!!) return false
        return isValidByRange(root.left, min, root)
                && isValidByRange(root.right, root, max)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 