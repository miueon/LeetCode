  //
//Given an integer array with no duplicates. A maximum tree building on this arr
//ay is defined as follow:
// 
// The root is the maximum number in the array. 
// The left subtree is the maximum tree constructed from left part subarray divi
//ded by the maximum number. 
// The right subtree is the maximum tree constructed from right part subarray di
//vided by the maximum number. 
// 
// 
//
// 
//Construct the maximum tree by the given array and output the root node of this
// tree.
// 
//
// Example 1: 
// 
//Input: [3,2,1,6,0,5]
//Output: return the tree root node representing the following tree:
//
//      6
//    /   \
//   3     5
//    \    / 
//     2  0   
//       \
//        1
// 
// 
//
// Note: 
// 
// The size of the given array will be in the range [1,1000]. 
// 
// Related Topics Tree 
// 👍 2191 👎 259

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
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        return build(nums, 0, nums.size-1)
    }

    fun build(nums: IntArray, lo: Int, hi: Int): TreeNode? {
        if (lo > hi) {
            return null
        }
        var index:Int =lo
        var max = nums[lo]
        for (i in lo..hi) {
            if (nums[i] > max) {
                index = i
                max = nums[i]
            }
        }
        val root = TreeNode(max, null, null)
        root.left = build(nums, lo, index-1)
        root.right = build(nums, index+1, hi)
        return root
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 