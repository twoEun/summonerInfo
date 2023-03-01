package com.kkc.entity.data

import com.google.gson.annotations.SerializedName

data class GameGeneralInfo(
    @SerializedName("kill")
    val killCount: Int,

    @SerializedName("death")
    val deathCount: Int,

    @SerializedName("assist")
    val assistCount: Int,

    @SerializedName("kdaString")
    val kdaString: String,

    @SerializedName("cs")
    val cs: Int,

    @SerializedName("csPerMin")
    val csPerMin: Float,

    @SerializedName("contributionForKillRate")
    val contributionForKillRate: String,

    @SerializedName("goldEarned")
    val goldEarned: Int,

    @SerializedName("totalDamageDealtToChampions")
    val totalDamageDealToChampion: Int,

    @SerializedName("largestMultiKillString")
    val largestMultiKillString: String?,

    @SerializedName("opScoreBadge")
    val opScoreBadge: String?,
)
