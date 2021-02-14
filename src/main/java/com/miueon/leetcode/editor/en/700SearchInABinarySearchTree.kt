  //Given the root node of a binary search tree (BST) and a value. You need to fin
//d the node in the BST that the node's value equals the given value. Return the s
//ubtree rooted with that node. If such node doesn't exist, you should return NULL
//. 
//
// For example, 
//
// 
//Given the tree:
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//And the value to search: 2
// 
//
// You should return this subtree: 
//
// 
//      2     
//     / \   
//    1   3
// 
//
// In the example above, if we want to search the value 5, since there is no nod
//e with value 5, we should return NULL. 
//
// Note that an empty tree is represented by NULL, therefore you would see the e
//xpected output (serialized tree format) as [], not null. 
// Related Topics Tree 
// 👍 1153 👎 123

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
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root != null && root.`val`!! == `val`) {
            return root
        }
        if (root != null) {
            if (root.`val`!! < `val`) {
                return searchBST(root.right, `val`)
            } else {
                return searchBST(root.left, `val`)
            }
        }
        return root
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 