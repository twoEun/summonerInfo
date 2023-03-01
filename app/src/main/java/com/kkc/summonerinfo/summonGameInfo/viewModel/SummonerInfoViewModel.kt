package com.kkc.summonerinfo.summonGameInfo.viewModel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kkc.entity.dto.GameInfoDto
import com.kkc.entity.dto.RecentAnalyticsDto
import com.kkc.entity.dto.SummonerInfoDto
import com.kkc.usecase.summonerInfo.SummonerInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class SummonerInfoViewModel @Inject constructor(
    private val summonerGameUseCase: SummonerInfoUseCase
) : ViewModel() {
    private var lastCreate = 0L

    private val _progressVisible = MutableLiveData(false)
    val progressVisible: LiveData<Boolean>
        get() = _progressVisible

    private val _summonerInfo = MutableLiveData<SummonerInfoDto>()
    val summonerInfo: LiveData<SummonerInfoDto>
        get() = _summonerInfo

    private val _recentAnalyticsInfo = MutableLiveData<RecentAnalyticsDto>()
    val recentAnalyticsInfo: LiveData<RecentAnalyticsDto>
        get() = _recentAnalyticsInfo

    private val _gameInfo = MutableLiveData<List<GameInfoDto>?>()
    val gameInfo: LiveData<List<GameInfoDto>?>
        get() = _gameInfo

    fun requestRefresh() {
        getSummonerInfo()
        getInitialGameInfo()
    }

    @SuppressLint("CheckResult")
    private fun getSummonerInfo(){
        summonerGameUseCase.getSummonerInfo()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                _summonerInfo.postValue(result)
            }, { err ->
                err.printStackTrace()
            })
    }

    @SuppressLint("CheckResult")
    private fun getInitialGameInfo() {
        lastCreate = 0L
        summonerGameUseCase.getGameInfoInit()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                _recentAnalyticsInfo.postValue(result.recentAnalyticsDto)
                _gameInfo.postValue(result.gameInfo)
                lastCreate = result.gameInfo?.last()?.createOrigin ?: 0L
                _progressVisible.postValue(false)
            }, { err ->
                err.printStackTrace()
                _progressVisible.postValue(false)
            })
    }

    @SuppressLint("CheckResult")
    private fun getGameInfoLoadMore() {
        _progressVisible.postValue(true)
        summonerGameUseCase.getGameInfo(lastCreate)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                if (!result.isNullOrEmpty()) {
                    lastCreate = result.last().createOrigin
                    val gameList = gameInfo.value?.toMutableList() ?: mutableListOf()
                    gameList.addAll(result)
                    _gameInfo.postValue(gameList)
                    _progressVisible.postValue(false)
                }
            }, { err ->
                err.printStackTrace()
                _progressVisible.postValue(false)
            })
    }

    fun requestLoadMore() {
        getGameInfoLoadMore()
    }
}
