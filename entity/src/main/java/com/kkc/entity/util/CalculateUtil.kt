package com.kkc.entity.util

fun calculateWinningRate(totalCount: Int, winCount: Int): Int {
    val winRate = winCount.toFloat() / totalCount.toFloat()
    return (winRate * 100f).toInt()
}
