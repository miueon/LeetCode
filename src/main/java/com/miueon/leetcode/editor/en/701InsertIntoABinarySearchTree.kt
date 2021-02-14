  //You are given the root node of a binary search tree (BST) and a value to inser
//t into the tree. Return the root node of the BST after the insertion. It is guar
//anteed that the new value does not exist in the original BST. 
//
// Notice that there may exist multiple valid ways for the insertion, as long as
// the tree remains a BST after insertion. You can return any of them. 
//
// 
// Example 1: 
//
// 
//Input: root = [4,2,7,1,3], val = 5
//Output: [4,2,7,1,3,5]
//Explanation: Another accepted tree is:
//
// 
//
// Example 2: 
//
// 
//Input: root = [40,20,60,10,30,50,70], val = 25
//Output: [40,20,60,10,30,50,70,null,null,25]
// 
//
// Example 3: 
//
// 
//Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
//Output: [4,2,7,1,3,5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree will be in the range [0, 104]. 
// -108 <= Node.val <= 108 
// All the values Node.val are unique. 
// -108 <= val <= 108 
// It's guaranteed that val does not exist in the original BST. 
// 
// Related Topics Tree 
// 👍 1308 👎 92

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
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return TreeNode(`val`)
        }
        if (root.`val`!! > `val`) {
            root.left = insertIntoBST(root.left, `val`)
        } else {
            root.right = insertIntoBST(root.right, `val`)
        }
        return root
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 