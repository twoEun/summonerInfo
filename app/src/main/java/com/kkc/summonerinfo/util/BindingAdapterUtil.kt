package com.kkc.summonerinfo.util

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kkc.entity.dto.*
import com.kkc.summonerinfo.R
import com.kkc.summonerinfo.summonGameInfo.adapters.GameInfoAdapter
import com.kkc.summonerinfo.summonGameInfo.adapters.GameItemAdapter
import com.kkc.summonerinfo.summonGameInfo.adapters.SpellAdapter
import com.kkc.summonerinfo.summonGameInfo.adapters.SummonerLeagueInfoAdapter
import com.kkc.summonerinfo.summonGameInfo.customViews.*

@BindingAdapter("summonerInfo")
fun setSummonerInfo(summonerInfoView: SummonerInfoView, summonerInfo: SummonerInfoDto? = null) {
    summonerInfo?.let {
        summonerInfoView.setSummonerInfo(it)
    }
}

@BindingAdapter("leagueList")
fun setLeagueList(leagueListView: RecyclerView, leagueList: List<SummonerLeagueInfoDto>?) {
    leagueList?.let {
        val listAdapter = SummonerLeagueInfoAdapter()
        leagueListView.adapter = listAdapter
        listAdapter.submitList(it)
    }
}

@BindingAdapter("mostWinningRateInfo")
fun setMostWinningRateInfo(mostWinningRateChampionView: MostWinningRateChampionView, mostWinningRateInfo: MostWinningRateChampionInfoDto?) {
    mostWinningRateInfo?.let {
        mostWinningRateChampionView.setMostWinningRateInfo(it)
    }
}

@BindingAdapter("recentlyAnalytics")
fun setRecentlyAnalyticsInfo(recentlyAnalyticsView: SummonerRecentAnalyticsView, recentlyAnalyticsInfo: RecentAnalyticsDto?) {
    recentlyAnalyticsInfo?.let {
        recentlyAnalyticsView.visibility = View.VISIBLE
        recentlyAnalyticsView.setRecentlyAnalyticsInfo(it)
    }
}

@BindingAdapter("spellsInfo")
fun setGameSpellsInfo(recyclerView: RecyclerView, spellInfo: Array<String?>?) {
    spellInfo?.let {
        val spellAdapter = SpellAdapter()
        recyclerView.adapter = spellAdapter
        spellAdapter.submitList(it.toList())
    }
}

@BindingAdapter("itemsInfo")
fun setGameItemInfo(recyclerView: RecyclerView, itemInfo: Array<String?>?) {
    itemInfo?.let {
        val gameItemAdapter = GameItemAdapter()
        recyclerView.adapter = gameItemAdapter
        gameItemAdapter.submitList(it.toList())
    }
}

@BindingAdapter("gameInfo")
fun setGameInfo(recyclerView: RecyclerView, gameInfo: List<GameInfoDto>?) {
    gameInfo?.let {
        val gameInfoAdapter = recyclerView.adapter as? GameInfoAdapter ?: GameInfoAdapter()
        if (recyclerView.adapter == null)
            recyclerView.adapter = gameInfoAdapter

        gameInfoAdapter.submitList(it)
    }
}

@BindingAdapter("gameBadgeBackground")
fun setGameBadgeBackground(view: View, gameBadge: String? = null) {
    val backgroundRes = when (gameBadge) {
        "MVP" -> R.drawable.background_orange_yellow_white_stroke_radius_8
        "ACE" -> R.drawable.background_periwinkle_white_stroke_radius_8
        else -> null
    }

    backgroundRes?.let {
        view.setBackgroundResource(it)
    }
}
