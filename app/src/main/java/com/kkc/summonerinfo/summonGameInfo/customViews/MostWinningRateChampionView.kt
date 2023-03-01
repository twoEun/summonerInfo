package com.kkc.summonerinfo.summonGameInfo.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import com.kkc.entity.dto.MostWinningRateChampionInfoDto
import com.kkc.summonerinfo.R
import com.kkc.summonerinfo.databinding.ItemMostWinningRateChampBinding

class MostWinningRateChampionView : FrameLayout {
    constructor(context: Context) : super(context) {
        init()
    }
    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
        init()
    }

    private lateinit var binding: ItemMostWinningRateChampBinding

    private fun init() {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.item_most_winning_rate_champ,
            this,
            false
        )
        addView(binding.root)
    }

    fun setMostWinningRateInfo(winningRateChampionInfo: MostWinningRateChampionInfoDto) {
        winningRateChampionInfo.winningRateTextColor =  if (winningRateChampionInfo.winningRate == "100%") {
            R.color.darkish_pink
        } else {
            R.color.dark_grey
        }

        binding.mostWinningInfo = winningRateChampionInfo
    }
}
