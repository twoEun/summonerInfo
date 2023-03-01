package com.kkc.network.service

import com.kkc.entity.response.GameInfoResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GameInfoService {
    @GET("")
    fun getGameInfo(@Query("") createDate: Long?): Single<GameInfoResponse>

    @GET("")
    fun getGameInfoInit(): Single<GameInfoResponse>
}
