  //You are given an integer array nums with no duplicates. A maximum binary tree 
//can be built recursively from nums using the following algorithm: 
//
// 
// Create a root node whose value is the maximum value in nums. 
// Recursively build the left subtree on the subarray prefix to the left of the 
//maximum value. 
// Recursively build the right subtree on the subarray suffix to the right of th
//e maximum value. 
// 
//
// Return the maximum binary tree built from nums. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,2,1,6,0,5]
//Output: [6,3,5,null,2,0,null,null,1]
//Explanation: The recursive calls are as follow:
//- The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right su
//ffix is [0,5].
//    - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is
// [2,1].
//        - Empty array, so no child.
//        - The largest value in [2,1] is 2. Left prefix is [] and right suffix 
//is [1].
//            - Empty array, so no child.
//            - Only one element, so child is a node with value 1.
//    - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is 
//[].
//        - Only one element, so child is a node with value 0.
//        - Empty array, so no child.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1]
//Output: [3,null,2,null,1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// All integers in nums are unique. 
// 
// Related Topics Tree 
// 👍 2242 👎 264

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
        } else if (lo == hi) {
            return TreeNode(nums[lo])
        }
        var ix = lo
        for (i in lo..hi) {
            if (nums[ix] < nums[i]) {
                ix = i
            }
        }
        val newRoot = TreeNode(nums[ix])
        newRoot.left = build(nums, lo, ix-1)
        newRoot.right = build(nums, ix+1, hi)
        return newRoot
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 