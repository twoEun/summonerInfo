package com.kkc.network

import com.kkc.network.service.GameInfoService
import com.kkc.network.service.SummonerInfoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {
    @Provides
    fun provideSummonerInfoService(retrofit: Retrofit): SummonerInfoService {
        return retrofit.create(SummonerInfoService::class.java)
    }

    @Provides
    fun provideGameInfoService(retrofit: Retrofit): GameInfoService {
        return retrofit.create(GameInfoService::class.java)
    }
}
