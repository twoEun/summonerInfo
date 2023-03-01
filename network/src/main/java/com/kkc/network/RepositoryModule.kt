package com.kkc.network

import com.kkc.network.repository.GameInfoRepository
import com.kkc.network.repository.GameInfoRepositoryImpl
import com.kkc.network.repository.SummonerInfoRepository
import com.kkc.network.repository.SummonerInfoRepositoryImpl
import com.kkc.network.service.GameInfoService
import com.kkc.network.service.SummonerInfoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideSummonerInfoRepository(summonerInfoService: SummonerInfoService): SummonerInfoRepository =
        SummonerInfoRepositoryImpl(summonerInfoService = summonerInfoService)

    @Provides
    fun provideGameInfoRepository(gameInfoService: GameInfoService): GameInfoRepository =
        GameInfoRepositoryImpl(gameInfoService = gameInfoService)
}
