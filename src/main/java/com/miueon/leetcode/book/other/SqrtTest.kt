package com.miueon.leetcode.book.other

import java.math.BigDecimal

fun SqrtByBinarySearch(data: Double): Double {
    val eplison = 1e-15
    var left:Double = 0.0
    var right = data
    var estimate = (left + right) /2
    var estiSquare:Double
    while (Math.abs(estimate - data / estimate) > eplison * estimate) {
        estiSquare = estimate*estimate
        if (estiSquare > data) {
            right = estimate
        } else {
            left = estimate
        }
        estimate = (left + right) /2
        println(estimate)
    }
    return estimate
}



fun main() {
    //print(SqrtByBinarySearch(2.0))

}