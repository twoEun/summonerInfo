package com.kkc.entity.data

import com.google.gson.annotations.SerializedName
import com.kkc.entity.util.calculateWinningRate

data class LolChampionInfo(
    @SerializedName("id")
    val idx: Int,

    @SerializedName("key")
    val championKey: String,

    @SerializedName("name")
    val championName: String,

    @SerializedName("imageUrl")
    val championImage: String?,

    @SerializedName("games")
    val games: Int,

    @SerializedName("kills")
    val killCount: Int,

    @SerializedName("deaths")
    val deathCount: Int,

    @SerializedName("assists")
    val assistCount: Int,

    @SerializedName("wins")
    val winCount: Int,

    @SerializedName("losses")
    val loseCount: Int
) {
    fun getWinningRate(): Int {
        return calculateWinningRate(winCount + loseCount, winCount)
    }
}
