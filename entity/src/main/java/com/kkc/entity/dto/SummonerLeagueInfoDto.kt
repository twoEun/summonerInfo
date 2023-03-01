package com.kkc.entity.dto

import com.kkc.entity.data.SummonerLeagueInfo
import com.kkc.entity.util.calculateWinningRate

data class SummonerLeagueInfoDto(
    val winCount: Int,
    val loseCount: Int,
    val winRate: String,
    val tierType: String,
    val tierName: String,
    val tierImage: String?,
    val tierLp: Int
) {
    companion object {
        fun fromLeagueInfo(leagueInfo: SummonerLeagueInfo): SummonerLeagueInfoDto {
            return SummonerLeagueInfoDto(
                winCount = leagueInfo.summonerLeaguesWinCount,
                loseCount = leagueInfo.summonerLeaguesLoseCount,
                winRate = "${calculateWinningRate((leagueInfo.summonerLeaguesWinCount + leagueInfo.summonerLeaguesLoseCount), leagueInfo.summonerLeaguesWinCount)}%",
                tierType = leagueInfo.summonerTierInfo.tierType,
                tierName = leagueInfo.summonerTierInfo.tier,
                tierImage = leagueInfo.summonerTierInfo.tierImage,
                tierLp = leagueInfo.summonerTierInfo.tierLp
            )
        }
    }
}
