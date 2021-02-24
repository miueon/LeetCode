  //Implement a last in first out (LIFO) stack using only two queues. The implemen
//ted stack should support all the functions of a normal queue (push, top, pop, an
//d empty). 
//
// Implement the MyStack class: 
//
// 
// void push(int x) Pushes element x to the top of the stack. 
// int pop() Removes the element on the top of the stack and returns it. 
// int top() Returns the element on the top of the stack. 
// boolean empty() Returns true if the stack is empty, false otherwise. 
// 
//
// Notes: 
//
// 
// You must use only standard operations of a queue, which means only push to ba
//ck, peek/pop from front, size, and is empty operations are valid. 
// Depending on your language, the queue may not be supported natively. You may 
//simulate a queue using a list or deque (double-ended queue), as long as you use 
//only a queue's standard operations. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//Output
//[null, null, null, 2, 2, false]
//
//Explanation
//MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // return 2
//myStack.pop(); // return 2
//myStack.empty(); // return False
// 
//
// 
// Constraints: 
//
// 
// 1 <= x <= 9 
// At most 100 calls will be made to push, pop, top, and empty. 
// All the calls to pop and top are valid. 
// 
//
// 
//Follow-up: Can you implement the stack such that each operation is amortized O
//(1) time complexity? In other words, performing n operations will take overall O
//(n) time even if one of those operations may take longer. You can use more than 
//two queues. Related Topics Stack Design 
// 👍 959 👎 662

  package com.miueon.leetcode.editor.en

  import java.util.*

  //leetcode submit region begin(Prohibit modification and deletion)
class MyStack() {

    /** Initialize your data structure here. */
    private val q: Queue<Int> = LinkedList()
    private var topElement:Int = 0
    /** Push element x onto stack. */
    fun push(x: Int) {
        q.offer(x)
        topElement = x
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        var size = q.size
        while (size > 2) {
            q.offer(q.poll())
            size--
        }

        topElement = q.peek()
        q.offer(q.poll())
        return q.poll()
    }

    /** Get the top element. */
    fun top(): Int {
        return topElement
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return q.isEmpty()
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
//leetcode submit region end(Prohibit modification and deletion)

  
 