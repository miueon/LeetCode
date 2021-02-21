//Median is the middle value in an ordered integer list. If the size of the list
// is even, there is no middle value. So the median is the mean of the two middle 
//value. 
//For example,
//
// [2,3,4], the median is 3 
//
// [2,3], the median is (2 + 3) / 2 = 2.5 
//
// Design a data structure that supports the following two operations: 
//
// 
// void addNum(int num) - Add a integer number from the data stream to the data 
//structure. 
// double findMedian() - Return the median of all elements so far. 
// 
//
// 
//
// Example: 
//
// 
//addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2
// 
//
// 
//
// Follow up: 
//
// 
// If all integer numbers from the stream are between 0 and 100, how would you o
//ptimize it? 
// If 99% of all integer numbers from the stream are between 0 and 100, how woul
//d you optimize it? 
// 
// Related Topics Heap Design 
// 👍 3773 👎 69

package com.miueon.leetcode.editor.en

import java.util.*

//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder() {

    /** initialize your data structure here. */
    private val large = PriorityQueue<Int>()
    private val small = PriorityQueue<Int>() { a, b -> b - a }

    fun addNum(num: Int) {
        if (small.size >= large.size) {
            small.offer(num)
            large.offer(small.poll())
        } else {
            large.offer(num)
            small.offer(large.poll())
        }
    }

    fun findMedian(): Double {
        if (small.size > large.size) {
            return small.peek().toDouble()
        } else if (large.size > small.size){
            return large.peek().toDouble()
        }

        return (large.peek() + small.peek()) / 2.0
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */
//leetcode submit region end(Prohibit modification and deletion)

  
 