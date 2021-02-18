  //Given an array equations of strings that represent relationships between varia
//bles, each string equations[i] has length 4 and takes one of two different forms
//: "a==b" or "a!=b". Here, a and b are lowercase letters (not necessarily differe
//nt) that represent one-letter variable names. 
//
// Return true if and only if it is possible to assign integers to variable name
//s so as to satisfy all the given equations. 
//
// 
//
// 
// 
//
// 
// Example 1: 
//
// 
//Input: ["a==b","b!=a"]
//Output: false
//Explanation: If we assign say, a = 1 and b = 1, then the first equation is sat
//isfied, but not the second.  There is no way to assign the variables to satisfy 
//both equations.
// 
//
// 
// Example 2: 
//
// 
//Input: ["b==a","a==b"]
//Output: true
//Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
// 
//
// 
// Example 3: 
//
// 
//Input: ["a==b","b==c","a==c"]
//Output: true
// 
//
// 
// Example 4: 
//
// 
//Input: ["a==b","b!=c","c==a"]
//Output: false
// 
//
// 
// Example 5: 
//
// 
//Input: ["c==c","b==d","x!=z"]
//Output: true
// 
//
// 
//
// Note: 
//
// 
// 1 <= equations.length <= 500 
// equations[i].length == 4 
// equations[i][0] and equations[i][3] are lowercase letters 
// equations[i][1] is either '=' or '!' 
// equations[i][2] is '=' 
// 
// 
// 
// 
// 
// 
// Related Topics Union Find Graph 
// 👍 734 👎 6

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun equationsPossible(equations: Array<String>): Boolean {
        // 26 个英文字母
        // 26 个英文字母
        val uf = UF(26)
        // 先让相等的字母形成连通分量
        // 先让相等的字母形成连通分量
        for (eq in equations) {
            if (eq[1] == '=') {
                val x = eq[0]
                val y = eq[3]
                uf.union(x - 'a', y - 'a')
            }
        }
        // 检查不等关系是否打破相等关系的连通性
        // 检查不等关系是否打破相等关系的连通性
        for (eq in equations) {
            if (eq[1] == '!') {
                val x = eq[0]
                val y = eq[3]
                // 如果相等关系成立，就是逻辑冲突
                if (uf.connected(x - 'a', y - 'a')) return false
            }
        }
        return true
    }
    internal class UF(  // 记录连通分量个数
            private var count: Int) {
        // 存储若干棵树
        private val parent: IntArray = IntArray(count)

        // 记录树的“重量”
        private val size: IntArray = IntArray(count)

        /* 将 p 和 q 连通 */
        fun union(p: Int, q: Int) {
            val rootP = find(p)
            val rootQ = find(q)
            if (rootP == rootQ) return

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP
                size[rootP] += size[rootQ]
            } else {
                parent[rootP] = rootQ
                size[rootQ] += size[rootP]
            }
            count--
        }

        /* 判断 p 和 q 是否互相连通 */
        fun connected(p: Int, q: Int): Boolean {
            val rootP = find(p)
            val rootQ = find(q)
            // 处于同一棵树上的节点，相互连通
            return rootP == rootQ
        }

        /* 返回节点 x 的根节点 */
        private fun find(x: Int): Int {
            var x = x
            while (parent[x] != x) {
                // 进行路径压缩
                parent[x] = parent[parent[x]]
                x = parent[x]
            }
            return x
        }

        fun count(): Int {
            return count
        }

        init {
            for (i in 0 until count) {
                parent[i] = i
                size[i] = 1
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 