package com.kkc.entity.data

import com.google.gson.annotations.SerializedName

data class SummonerTierInfo(
    @SerializedName("name")
    val tierType: String,

    @SerializedName("tier")
    val tier: String,

    @SerializedName("tierDivision")
    val tierDivision: String,

    @SerializedName("string")
    val tierString: String,

    @SerializedName("shortString")
    val tierShortString: String,

    @SerializedName("division")
    val division: String,

    @SerializedName("imageUrl")
    val tierImage: String?,

    @SerializedName("lp")
    val tierLp: Int,

    @SerializedName("tierRankPoint")
    val tierRankPoint: Int
)
