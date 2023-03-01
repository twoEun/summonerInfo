package com.kkc.usecase

import com.kkc.network.repository.GameInfoRepository
import com.kkc.network.repository.SummonerInfoRepository
import com.kkc.usecase.summonerInfo.SummonerInfoUseCase
import com.kkc.usecase.summonerInfo.SummonerInfoUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    fun provideSummonerInfoUseCase(summonerInfoRepository: SummonerInfoRepository, gameInfoRepository: GameInfoRepository): SummonerInfoUseCase {
        return SummonerInfoUseCaseImpl(summonerInfoRepository, gameInfoRepository)
    }
}