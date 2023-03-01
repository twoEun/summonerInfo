package com.kkc.entity.data

import com.google.gson.annotations.SerializedName

data class GameChampionInfo(
    @SerializedName("imageUrl")
    val championImage: String,

    @SerializedName("level")
    val championLevel: Int
)
