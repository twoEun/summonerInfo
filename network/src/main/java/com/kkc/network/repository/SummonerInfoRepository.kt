package com.kkc.network.repository

import com.kkc.entity.response.SummonerInfoResponse
import com.kkc.network.service.SummonerInfoService
import io.reactivex.Single
import javax.inject.Inject

class SummonerInfoRepositoryImpl @Inject constructor(private val summonerInfoService: SummonerInfoService) : SummonerInfoRepository {
    override fun getSummonerInfo(): Single<SummonerInfoResponse> {
        return summonerInfoService.getSummonerInfo()
    }
}

interface SummonerInfoRepository {
    fun getSummonerInfo(): Single<SummonerInfoResponse>
}
