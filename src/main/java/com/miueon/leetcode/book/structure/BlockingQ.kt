package com.miueon.leetcode.book.structure

import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

/**
 * title: BlockingQ

 * Author: Miueon

 * Date: 2020-12-12 1:00 p.m.

 * Version 1.0
 */
class BlockingQ<T> {
    val lock = ReentrantLock()
    val condition = lock.newCondition()
    var limit: Int = 10
    constructor()
    constructor(limit: Int) {
        this.limit = limit
    }

    private val queue: Queue<T> = LinkedList<T>()
    val size:Int
        get() = queue.size

    fun enqueue(item: T) {
        lock.withLock {
            if (this.queue.size == limit) {
                condition.await()
            }
            this.queue.add(item)
            if (this.queue.size == 1) {
                condition.signalAll()
            }
        }
    }

    fun dequeue(): T {
        lock.withLock {
            while (this.queue.size == 0) {
                condition.await()
            }
            if (this.queue.size == this.limit) {
                condition.signalAll()
            }
            return this.queue.remove()
        }
    }
}
class Producer(val pipeLine:BlockingQ<Int>) : Runnable {
    override fun run() {
        for (i in 1..100) {
            try {
//                Thread.sleep(1000)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            try {
                pipeLine.enqueue(i)
                println(Thread.currentThread().name + "producer: currently pipeline have:" +
                        pipeLine.size)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}

fun consumer(pipeLine: BlockingQ<Int>) {
    for (i in 1..10) {
        try {
            Thread.sleep(500)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        try {
            val result = pipeLine.dequeue()
            println(Thread.currentThread().name + "Consumer: get: ${result}, " +
                    "currently have ${pipeLine.size} things")
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}

fun main() {
    val blockingQ = BlockingQ<Int>()
    val executor = Executors.newCachedThreadPool()
//    executor.submit(Producer(blockingQ))
//    for (i in 1..10) {
//        executor.submit{ consumer(blockingQ)}
//    }

}