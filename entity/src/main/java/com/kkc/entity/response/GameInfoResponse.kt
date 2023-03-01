package com.kkc.entity.response

import com.google.gson.annotations.SerializedName
import com.kkc.entity.data.GameInfo
import com.kkc.entity.data.GameSummaryInfo
import com.kkc.entity.data.LolChampionInfo
import com.kkc.entity.data.PositionInfo

data class GameInfoResponse(
    @SerializedName("games")
    val gameInfo: List<GameInfo>?,

    @SerializedName("champions")
    val championList: List<LolChampionInfo>,

    @SerializedName("positions")
    val positionList: List<PositionInfo>,

    @SerializedName("summary")
    val gameSummaryInfo: GameSummaryInfo
)
