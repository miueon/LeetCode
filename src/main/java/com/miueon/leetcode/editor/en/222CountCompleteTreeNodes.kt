  //Given the root of a complete binary tree, return the number of the nodes in th
//e tree. 
//
// According to Wikipedia, every level, except possibly the last, is completely 
//filled in a complete binary tree, and all nodes in the last level are as far lef
//t as possible. It can have between 1 and 2h nodes inclusive at the last level h.
// 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,5,6]
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5 * 104]. 
// 0 <= Node.val <= 5 * 104 
// The tree is guaranteed to be complete. 
// 
//
// 
//Follow up: Traversing the tree to count the number of nodes in the tree is an 
//easy solution but with O(n) complexity. Could you find a faster algorithm? Relat
//ed Topics Binary Search Tree 
// 👍 2698 👎 247

  package com.miueon.leetcode.editor.en

  import kotlin.math.pow

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
    fun countNodes(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var l = root
        var r = root
        var lh:Int = 0
        var rh:Int = 0
        while (l != null) {
            l = l.left
            lh++
        }
        while (r != null) {
            r = r.right
            rh++
        }
        if (lh == rh) {
            return Math.pow(2.0, lh.toDouble()).toInt() -1
        }
        return countNodes(root.left) + countNodes(root.right) + 1
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 