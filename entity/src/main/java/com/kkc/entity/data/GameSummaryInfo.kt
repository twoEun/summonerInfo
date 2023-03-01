package com.kkc.entity.data

import com.google.gson.annotations.SerializedName

data class GameSummaryInfo(
    @SerializedName("wins")
    val gameWinCount: Int,

    @SerializedName("losses")
    val gameLoseCount: Int,

    @SerializedName("kills")
    val killCount: Int,

    @SerializedName("deaths")
    val deathCount: Int,

    @SerializedName("assists")
    val assistCount: Int
)
