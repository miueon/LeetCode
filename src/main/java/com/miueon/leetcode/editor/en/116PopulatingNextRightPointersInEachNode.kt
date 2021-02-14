  //You are given a perfect binary tree where all leaves are on the same level, an
//d every parent has two children. The binary tree has the following definition: 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
// 
//
// Populate each next pointer to point to its next right node. If there is no ne
//xt right node, the next pointer should be set to NULL. 
//
// Initially, all next pointers are set to NULL. 
//
// 
//
// Follow up: 
//
// 
// You may only use constant extra space. 
// Recursive approach is fine, you may assume implicit stack space does not coun
//t as extra space for this problem. 
// 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,2,3,4,5,6,7]
//Output: [1,#,2,3,#,4,5,6,7,#]
//Explanation: Given the above perfect binary tree (Figure A), your function sho
//uld populate each next pointer to point to its next right node, just like in Fig
//ure B. The serialized output is in level order as connected by the next pointers
//, with '#' signifying the end of each level.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the given tree is less than 4096. 
// -1000 <= node.val <= 1000 
// Related Topics Tree Depth-first Search Breadth-first Search 
// 👍 2909 👎 157

  package com.miueon.leetcode.editor.en

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {

    fun connect(root: Node?): Node? {
        if (root == null) {
            return root
        }
        connectTwoNode(root.left, root.right)
        return root
    }

    fun connectTwoNode(node1: Node?, node2: Node?) {
        if (node1 == null || node2 == null) {
            return
        }
        node1.next = node2
        connectTwoNode(node1.left, node1.right )
        connectTwoNode(node2.left, node2.right)
        connectTwoNode(node1.right, node2.left)
    }

}

//leetcode submit region end(Prohibit modification and deletion)

  
 