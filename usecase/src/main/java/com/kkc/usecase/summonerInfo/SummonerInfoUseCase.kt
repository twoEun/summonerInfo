package com.kkc.usecase.summonerInfo

import com.kkc.entity.dto.*
import com.kkc.entity.response.GameInfoResponse
import com.kkc.entity.response.SummonerInfoResponse
import com.kkc.network.repository.GameInfoRepository
import com.kkc.network.repository.SummonerInfoRepository
import io.reactivex.Single
import javax.inject.Inject

class SummonerInfoUseCaseImpl @Inject constructor(
    private val summonerInfoRepository: SummonerInfoRepository,
    private val gameInfoRepository: GameInfoRepository
) : SummonerInfoUseCase {
    override fun getSummonerInfo(): Single<SummonerInfoDto> {
        return summonerInfoRepository.getSummonerInfo().map { summonerResponse ->
            SummonerInfoDto(
                summonerName = summonerResponse.summonerInfo.summonerName,
                summonerLevel = summonerResponse.summonerInfo.summonerLevel,
                summonerProfileImage = summonerResponse.summonerInfo.summonerProfileImage,
                summonerLeagueList = summonerResponse.summonerInfo.summonerLeaguesInfo.map { leagueInfo -> SummonerLeagueInfoDto.fromLeagueInfo(leagueInfo) }
            )
        }
    }

    override fun getGameInfo(lastCreate: Long): Single<List<GameInfoDto>> {
        return gameInfoRepository.getGameInfo(lastCreate).map { gameInfoResponse ->
            gameInfoResponse.gameInfo?.map { gameInfo ->
                GameInfoDto.fromGameResponse(gameInfo)
            }
        }
    }

    override fun getGameInfoInit(): Single<TotalGameInfo> {
        return gameInfoRepository.getGameInfoInit().map { gameInfoResult ->
            convertSummonerInfoAndGameInfoToTotalSummonerGameInfo(gameInfoResult)
        }
    }

    private fun convertSummonerInfoAndGameInfoToTotalSummonerGameInfo(gameResponse: GameInfoResponse): TotalGameInfo {
        val recentAnalytics = RecentAnalyticsDto.fromGameInfo(gameResponse)
        val game = gameResponse.gameInfo?.map { gameInfo -> GameInfoDto.fromGameResponse(gameInfo) }
        return TotalGameInfo(
            recentAnalytics,
            game
        )
    }
}

interface SummonerInfoUseCase {
    fun getSummonerInfo(): Single<SummonerInfoDto>
    fun getGameInfo(lastCreate: Long): Single<List<GameInfoDto>>
    fun getGameInfoInit(): Single<TotalGameInfo>
}
