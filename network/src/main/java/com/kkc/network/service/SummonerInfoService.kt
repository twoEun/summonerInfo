package com.kkc.network.service

import com.kkc.entity.response.SummonerInfoResponse
import io.reactivex.Single
import retrofit2.http.GET

interface SummonerInfoService {
    @GET("")
    fun getSummonerInfo(): Single<SummonerInfoResponse>
}
