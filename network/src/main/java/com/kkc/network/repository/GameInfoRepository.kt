package com.kkc.network.repository

import com.kkc.entity.response.GameInfoResponse
import com.kkc.network.service.GameInfoService
import io.reactivex.Single
import javax.inject.Inject

class GameInfoRepositoryImpl @Inject constructor(private val gameInfoService: GameInfoService) : GameInfoRepository {
    override fun getGameInfo(lastCreateDate: Long?): Single<GameInfoResponse> {
        return gameInfoService.getGameInfo(lastCreateDate)
    }

    override fun getGameInfoInit(): Single<GameInfoResponse> {
        return gameInfoService.getGameInfoInit()
    }
}

interface GameInfoRepository {
    fun getGameInfo(lastCreateDate: Long?): Single<GameInfoResponse>
    fun getGameInfoInit(): Single<GameInfoResponse>
}
