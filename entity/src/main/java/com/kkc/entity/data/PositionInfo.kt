package com.kkc.entity.data

import com.google.gson.annotations.SerializedName
import com.kkc.entity.util.calculateWinningRate

data class PositionInfo(
    @SerializedName("games")
    val playedGameCount: Int,

    @SerializedName("wins")
    val winGameCount: Int,

    @SerializedName("losses")
    val loseGameCount: Int,

    @SerializedName("position")
    val positionCode: String,

    @SerializedName("positionName")
    val positionName: String
) {
    fun getWinningRate(): Int {
        return calculateWinningRate(playedGameCount, winGameCount)
    }
}
