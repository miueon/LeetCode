//Given a binary search tree,
//write a function kthSmallest to find the kth small
//est element in it. 
//
// 
//
// Example 1: 
//
// 
//Input: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//Output: 1 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//Output: 3
// 
//
// Follow up: 
//What if the BST is modified (insert/delete operations) often and you need to f
//ind the kth smallest frequently? How would you optimize the kthSmallest routine?
// 
//
// 
// Constraints: 
//
// 
// The number of elements of the BST is between 1 to 10^4. 
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements. 
// 
// Related Topics Binary Search Tree 
// 👍 3257 👎 76

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
    val mid:MutableList<TreeNode> = ArrayList()
    var k:Int = 1
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        this.k = k
        traverse(root)
        return mid.get(k-1).`val`
    }

    fun traverse(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        traverse(root.left)
        mid.add(root)
        if (mid.size == k) {
            return null
        }
        traverse(root.right)
        return root
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  
 