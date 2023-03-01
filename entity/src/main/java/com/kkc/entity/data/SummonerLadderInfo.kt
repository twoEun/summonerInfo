package com.kkc.entity.data

import com.google.gson.annotations.SerializedName

data class SummonerLadderInfo(
    @SerializedName("rank")
    val rank: Int,

    @SerializedName("rankPercentOfTop")
    val rankPercentOfTop: Float
)
