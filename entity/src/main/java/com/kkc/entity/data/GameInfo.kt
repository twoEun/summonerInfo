package com.kkc.entity.data

import com.google.gson.annotations.SerializedName

data class GameInfo(
    @SerializedName("mmr")
    val mmr: Int,

    @SerializedName("champion")
    val championInfo: GameChampionInfo,

    @SerializedName("spells")
    val spellInfo: List<GameSpellsInfo>,

    @SerializedName("items")
    val itemInfo: List<GameItemInfo>,

    @SerializedName("createDate")
    val createDate: Long,

    @SerializedName("gameType")
    val gameType: String,

    @SerializedName("gameLength")
    val playTime: Int,

    @SerializedName("isWin")
    val isWin: Boolean,

    @SerializedName("stats")
    val gameStateInfo: GameStateInfo,

    @SerializedName("peak")
    val peaks: List<String>
)
