//In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1
//. 
//
// When a student enters the room, they must sit in the seat that maximizes the 
//distance to the closest person. If there are multiple such seats, they sit in th
//e seat with the lowest number. (Also, if no one is in the room, then the student
// sits at seat number 0.) 
//
// Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat() re
//turning an int representing what seat the student sat in, and ExamRoom.leave(int
// p) representing that the student in seat number p now leaves the room. It is gu
//aranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p. 
//
// 
//
// Example 1: 
//
// 
//Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[]
//,[],[4],[]]
//Output: [null,0,9,4,2,null,5]
//Explanation:
//ExamRoom(10) -> null
//seat() -> 0, no one is in the room, then the student sits at seat number 0.
//seat() -> 9, the student sits at the last seat number 9.
//seat() -> 4, the student sits at the last seat number 4.
//seat() -> 2, the student sits at the last seat number 2.
//leave(4) -> null
//seat() -> 5, the student sits at the last seat number 5.
// 
//
// 
//
// Note: 
//
// 
// 1 <= N <= 10^9 
// ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times across
// all test cases. 
// Calls to ExamRoom.leave(p) are guaranteed to have a student currently sitting
// in seat number p. 
// 
// Related Topics Ordered Map 
// 👍 701 👎 290

package com.miueon.leetcode.editor.en

import java.util.*
import kotlin.collections.HashMap

//leetcode submit region begin(Prohibit modification and deletion)
class ExamRoom(N: Int) {
    private val startMap: HashMap<Int, IntArray> = HashMap()
    private val endMap: HashMap<Int, IntArray> = HashMap()
    private val pq: TreeSet<IntArray>
    private val N = N

    init {
        pq = TreeSet { a, b ->
            val distA = distance(a)
            val distB = distance(b)
            if (distA == distB) {
                return@TreeSet b[0] - a[0]
            }
            return@TreeSet distA - distB
        }
        addInterval(intArrayOf(-1, N))
    }

    private fun removeInterval(intv: IntArray) {
        pq.remove(intv)
        startMap.remove(intv[0])
        endMap.remove(intv[1])
    }

    private fun addInterval(intv: IntArray) {
        pq.add(intv)
        startMap[intv[0]] = intv
        endMap[intv[1]] = intv
    }

    private fun distance(intv: IntArray): Int {
        val x = intv[0]
        val y = intv[1]
        if (x == -1) {
            return y
        }
        if (y == N) {
            return N - 1 - x
        }
        return (y - x) / 2
    }

    fun seat(): Int {
        val longest = pq.last()
        val x = longest[0]
        val y = longest[1]
        val seat = when {
            x == -1 -> 0
            y == N -> N - 1
            else -> (y - x) / 2 + x
        }
        val left = intArrayOf(x, seat)
        val right = intArrayOf(seat, y)
        removeInterval(longest)
        addInterval(left)
        addInterval(right)
        return seat
    }

    fun leave(p: Int) {
        val right = startMap[p]!!
        val left = endMap[p]!!
        val merged = intArrayOf(left[0], right[1])
        removeInterval(left)
        removeInterval(right)
        addInterval(merged)
    }

}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * var obj = ExamRoom(N)
 * var param_1 = obj.seat()
 * obj.leave(p)
 */
//leetcode submit region end(Prohibit modification and deletion)

  
 