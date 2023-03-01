package com.kkc.entity.dto

data class MostWinningRateChampionInfoDto(
    val championImage: String?,
    val winningRate: String,
    var winningRateTextColor: Int? = null,
    var isVisible: Boolean = true
)
