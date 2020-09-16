//Given an n-ary tree, return the level order traversal of its nodes' values.
//
// Nary-Tree input serialization is represented in their level order traversal, 
//each group of children is separated by the null value (See examples). 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,null,3,2,4,null,5,6]
//Output: [[1],[3,2,4],[5,6]]
// 
//
// Example 2: 
//
// 
//
// 
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null
//,12,null,13,null,null,14]
//Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
// Constraints: 
//
// 
// The height of the n-ary tree is less than or equal to 1000 
// The total number of nodes is between [0, 10^4] 
// 
// Related Topics Tree Breadth-first Search 
// 👍 654 👎 47

package com.miueon.leetcode.editor.en

import java.util.*
import kotlin.collections.ArrayList

//Definition for a Node.
class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}
//leetcode submit region begin(Prohibit modification and deletion)


class NaryTreeSolution {
    /*本身不难, 一个queue加层序遍历即可
    keyPoint 在于 虽然题目中给出的root是一个array, 实际上已经是一棵tree

 * */
    fun levelOrder(root: Node?): List<List<Int>> {
        val ans = ArrayList<ArrayList<Int>>()
        val queue: Queue<Node> = LinkedList<Node>() as Queue<Node>
        root ?: return ans
        queue.add(root)
        var curNode: Node? = null
        var size = 0
        while (queue.isNotEmpty()) {
            size = queue.size // 1. 将queue中的节点都append到new List
            val tmp: MutableList<Int> = ArrayList<Int>()
            for (i in 0 until size) {
                curNode = queue.remove()
                tmp.add(curNode.`val`)
                if (curNode.children.size != 0) {
                    // 2. 按序对每个child node 都将其
                    // children append到queue中
                    for (j in 0 until curNode.children.size) {
                        queue.add(curNode.children[j])
                    }
                }
            }
            ans.add(tmp as ArrayList<Int>)
        }
        return ans
    }
//    fun dfs(node: Node?, result: MutableList<MutableList<Int>>, level: Int) {
//        node ?: return
//        if (level == result.size) {
//            result.add(ArrayList<Int>())
//        }
//        result[level].add(node.val)
//        node.children.forEach{dfs(it, result, level+1)}
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 