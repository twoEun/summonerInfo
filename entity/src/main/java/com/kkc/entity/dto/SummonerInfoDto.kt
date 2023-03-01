package com.kkc.entity.dto

import com.kkc.entity.data.SummonerLeagueInfo

data class SummonerInfoDto(
    val summonerName: String,
    val summonerLevel: Int,
    val summonerProfileImage: String?,
    val summonerLeagueList: List<SummonerLeagueInfoDto> = emptyList()
)
