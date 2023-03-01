package com.kkc.entity.dto

import com.kkc.entity.response.GameInfoResponse
import com.kkc.entity.util.calculateWinningRate
import com.kkc.entity.util.notCompleteImageUrlCompletetion

data class RecentAnalyticsDto(
    val recentTotalGameCount: Int,
    val recentWins: Int,
    val recentLoses: Int,
    val recentWinningRate: String,
    val recentKillAvg: Float,
    val recentAssistAvg: Float,
    val recentDeathAvg: Float,
    val kda: Float,
    val mostWinningRateFirst: MostWinningRateChampionInfoDto,
    val mostWinningRateSecond: MostWinningRateChampionInfoDto? = null,
    val positionRate: String
) {
    companion object {
        fun fromGameInfo(gameInfo: GameInfoResponse): RecentAnalyticsDto {
            val recentGameCount = gameInfo.gameSummaryInfo.gameWinCount + gameInfo.gameSummaryInfo.gameLoseCount
            val champions = gameInfo.championList.sortedByDescending { champion -> champion.getWinningRate() }
            val positions = gameInfo.positionList.sortedByDescending { position -> position.getWinningRate() }
            return RecentAnalyticsDto(
                recentTotalGameCount = recentGameCount,
                recentWins = gameInfo.gameSummaryInfo.gameWinCount,
                recentLoses = gameInfo.gameSummaryInfo.gameLoseCount,
                recentWinningRate = "${calculateWinningRate(recentGameCount, gameInfo.gameSummaryInfo.gameWinCount)}%",
                recentKillAvg = gameInfo.gameSummaryInfo.killCount.toFloat() / recentGameCount.toFloat(),
                recentAssistAvg = gameInfo.gameSummaryInfo.assistCount.toFloat() / recentGameCount.toFloat(),
                recentDeathAvg = gameInfo.gameSummaryInfo.deathCount.toFloat() / recentGameCount.toFloat(),
                kda = (gameInfo.gameSummaryInfo.killCount.toFloat() + gameInfo.gameSummaryInfo.assistCount.toFloat()) /
                    gameInfo.gameSummaryInfo.deathCount.toFloat(),
                mostWinningRateFirst = MostWinningRateChampionInfoDto(
                    championImage = notCompleteImageUrlCompletetion(champions.first().championImage),
                    "${champions.first().getWinningRate()}%",
                    isVisible = !champions.first().championImage.isNullOrBlank()
                ),
                mostWinningRateSecond = if (champions.size > 1) {
                    MostWinningRateChampionInfoDto(
                        notCompleteImageUrlCompletetion(champions[1].championImage),
                        "${champions[1].getWinningRate()}%",
                        isVisible = !champions[1].championImage.isNullOrBlank()
                    )
                } else {
                    null
                },
                positionRate = "${positions.first().getWinningRate()}%"
            )
        }
    }
}
