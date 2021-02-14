  //Serialization is the process of converting a data structure or object into a s
//equence of bits so that it can be stored in a file or memory buffer, or transmit
//ted across a network connection link to be reconstructed later in the same or an
//other computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no r
//estriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this st
//ring can be deserialized to the original tree structure. 
//
// Clarification: The input/output format is the same as how LeetCode serializes
// a binary tree. You do not necessarily need to follow this format, so please be 
//creative and come up with different approaches yourself. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,null,4,5]
//Output: [1,2,3,null,null,4,5]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// Example 4: 
//
// 
//Input: root = [1,2]
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 104]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Design 
// 👍 3728 👎 178

  package com.miueon.leetcode.editor.en

  import java.util.*
  import kotlin.collections.ArrayList

  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec() {
    val SEP = ","
    val NULL = "#"
    val res = StringBuilder()

    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if (root == null) return ""
        val sb = StringBuilder()
        // 初始化队列，将 root 加入队列
        // 初始化队列，将 root 加入队列
        val q: Queue<TreeNode?> = LinkedList()
        q.offer(root)

        while (!q.isEmpty()) {
            val cur = q.poll()

            /* 层级遍历代码位置 */if (cur == null) {
                sb.append(NULL).append(SEP)
                continue
            }
            sb.append(cur.`val`).append(SEP)
            /** */
            q.offer(cur.left)
            q.offer(cur.right)
        }

        return sb.toString()
    }


    // Decodes your encoded data to tree.

    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) return null
        val nodes: List<String> = data.split(SEP)
        // 第一个元素就是 root 的值
        // 第一个元素就是 root 的值
        val root = TreeNode(nodes[0].toInt())

        // 队列 q 记录父节点，将 root 加入队列

        // 队列 q 记录父节点，将 root 加入队列
        val q: Queue<TreeNode?> = LinkedList()
        q.offer(root)
        var i = 1
        while (i < nodes.size) {
            // 队列中存的都是父节点
            val parent = q.poll()
            // 父节点对应的左侧子节点的值
            val left = nodes[i++]
            if (left != NULL) {
                parent!!.left = TreeNode(left.toInt())
                q.offer(parent.left)
            } else {
                parent!!.left = null
            }
            // 父节点对应的右侧子节点的值
            val right = nodes[i++]
            if (right != NULL) {
                parent.right = TreeNode(right.toInt())
                q.offer(parent.right)
            } else {
                parent.right = null
            }
            if (q.isEmpty()) {
                break
            }
        }

        return root
    }


    fun decode(nodes: java.util.ArrayList<String>): TreeNode? {
        if (nodes.isEmpty()) {
            return null
        }

        val queue: Queue<TreeNode?> = LinkedList()
        var node: TreeNode? = TreeNode(nodes[0].toInt())
        val root = node
        queue.offer(node)
        var i: Int = 1
        while (i < nodes.size) {
            node = queue.poll()
            val left = nodes[i++]
            if (left != NULL) {
                node!!.left = TreeNode(left.toInt())
                queue.offer(node.left)
            }
            val right = nodes[i++]
            if (right != NULL) {
                node!!.right = TreeNode(right.toInt())
                queue.offer(node.right)
            }
        }
        return root
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var ser = Codec()
 * var deser = Codec()
 * var data = ser.serialize(longUrl)
 * var ans = deser.deserialize(data)
 */
//leetcode submit region end(Prohibit modification and deletion)

  
 