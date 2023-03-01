package com.kkc.entity.response

import com.google.gson.annotations.SerializedName
import com.kkc.entity.data.SummonerInfo

data class SummonerInfoResponse(
    @SerializedName("summoner")
    val summonerInfo: SummonerInfo
)
