package com.kkc.entity.dto

data class TotalGameInfo(
    val recentAnalyticsDto: RecentAnalyticsDto,
    val gameInfo: List<GameInfoDto>?
)
