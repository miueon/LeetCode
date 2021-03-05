  //You have a lock in front of you with 4 circular wheels. Each wheel has 10 slot
//s: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freel
//y and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each
// move consists of turning one wheel one slot. 
//
// The lock initially starts at '0000', a string representing the state of the 4
// wheels. 
//
// You are given a list of deadends dead ends, meaning if the lock displays any 
//of these codes, the wheels of the lock will stop turning and you will be unable 
//to open it. 
//
// Given a target representing the value of the wheels that will unlock the lock
//, return the minimum total number of turns required to open the lock, or -1 if i
//t is impossible. 
//
// 
// Example 1: 
//
// 
//Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//Output: 6
//Explanation:
//A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "12
//01" -> "1202" -> "0202".
//Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would
// be invalid,
//because the wheels of the lock become stuck after the display becomes the dead
// end "0102".
// 
//
// Example 2: 
//
// 
//Input: deadends = ["8888"], target = "0009"
//Output: 1
//Explanation:
//We can turn the last wheel in reverse to move from "0000" -> "0009".
// 
//
// Example 3: 
//
// 
//Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], t
//arget = "8888"
//Output: -1
//Explanation:
//We can't reach the target without getting stuck.
// 
//
// Example 4: 
//
// 
//Input: deadends = ["0000"], target = "8888"
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target will not be in the list deadends. 
// target and deadends[i] consist of digits only. 
// 
// Related Topics Breadth-first Search 
// 👍 1465 👎 55

  package com.miueon.leetcode.editor.en

  import java.util.*
  import kotlin.collections.HashSet

  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun openLock(deadends: Array<String>, target: String): Int {
        val deads = HashSet<String>()
        deadends.forEach { deads.add(it) }
        val visited = HashSet<String>()
        val q:Queue<String> = LinkedList()
        var step = 0
        q.offer("0000")
        visited.add("0000")
        fun plusOne(s: String, j: Int): String {
            val ch = s.toCharArray()
            if (ch[j] == '9') {
                ch[j] = '0'
            } else {
                ch[j] = (ch[j].toInt() + 1).toChar()
            }
            return String(ch)
        }
        fun minusOne(s: String, j: Int): String {
            val ch = s.toCharArray()
            when (ch[j]) {
                '0'-> ch[j] = '9'
                else -> ch[j] = (ch[j].toInt() -1).toChar()
            }
            return String(ch)
        }
        while (q.isNotEmpty()) {
            val sz = q.size
            for (i in 0 until sz) {
                val cur = q.poll()

                if (deads.contains(cur)) {
                    continue
                }
                if (cur.equals(target)) {
                    return step
                }
                for (j in 0 until 4) {
                    val up = plusOne(cur, j)
                    if (!visited.contains(up)) {
                        q.offer(up)
                        visited.add(up)
                    }
                    val down = minusOne(cur, j)
                    if (!visited.contains(down)) {
                        q.offer(down)
                        visited.add(down)
                    }
                }
            }
            step++
        }
        return -1
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 