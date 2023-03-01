package com.kkc.entity.data

import com.google.gson.annotations.SerializedName

data class SummonerInfo(
    @SerializedName("name")
    val summonerName: String,

    @SerializedName("level")
    val summonerLevel: Int,

    @SerializedName("profileImageUrl")
    val summonerProfileImage: String?,

    @SerializedName("profileBorderImageUrl")
    val summonerProfileBoarderImage: String?,

    @SerializedName("leagues")
    val summonerLeaguesInfo: List<SummonerLeagueInfo>,

    @SerializedName("ladderRank")
    val ladderRankInfo: SummonerLadderInfo,

    @SerializedName("profileBackgroundImageUrl")
    val profileBackgroundImage: String?
)
