package com.kkc.entity.data

import com.google.gson.annotations.SerializedName

data class GameStateInfo(
    @SerializedName("general")
    val gameGeneralInfo: GameGeneralInfo
)
