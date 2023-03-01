package com.kkc.entity.data

import com.google.gson.annotations.SerializedName

data class SummonerLeagueInfo(
    @SerializedName("hasResults")
    val hasLeagueResult: Boolean,

    @SerializedName("wins")
    val summonerLeaguesWinCount: Int,

    @SerializedName("losses")
    val summonerLeaguesLoseCount: Int,

    @SerializedName("tierRank")
    val summonerTierInfo: SummonerTierInfo
)
