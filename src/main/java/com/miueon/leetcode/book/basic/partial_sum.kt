package com.miueon.leetcode.book.basic


object partial {
    val list_a = listOf<Int>(1, 2, 3 , 4 ,5)
    val array2d_a = Array(100){IntArray(100)}
    val array2d_b = Array(100){IntArray(100)}
    fun solution() {
        val list_b: MutableList<Int> = ArrayList(list_a)
        list_a.forEachIndexed { index, a ->
            run {
                when (index) {
                    0 -> return@run
                    else -> list_b[index] = list_b[index - 1] + a
                }
            }
        }
        println(list_b)
    }

    fun max_square() {

    }
}

fun main() {
    partial.solution()
}


