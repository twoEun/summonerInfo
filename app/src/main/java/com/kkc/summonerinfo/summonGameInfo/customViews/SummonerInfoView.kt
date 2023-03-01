package com.kkc.summonerinfo.summonGameInfo.customViews

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.kkc.entity.dto.SummonerInfoDto
import com.kkc.summonerinfo.R
import com.kkc.summonerinfo.databinding.ViewSummonerInfoBinding
import com.kkc.summonerinfo.summonGameInfo.interfaces.ClickEventDelivery
import com.kkc.summonerinfo.util.CustomDecoration
import com.kkc.summonerinfo.util.convertDpToPx

class SummonerInfoView : FrameLayout {
    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
        init()
    }

    private lateinit var binding: ViewSummonerInfoBinding
    private var clickEventDelivery: ClickEventDelivery? = null

    private fun init() {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.view_summoner_info,
            this@SummonerInfoView,
            false
        )
        binding.lifecycleOwner = findViewTreeLifecycleOwner()
        binding.summonerLeagueInfo.addItemDecoration(
            CustomDecoration(0, convertDpToPx(context, 8f), Color.TRANSPARENT, false)
        )
        binding.infoRefresh.setOnClickListener {
            clickEventDelivery?.deliveryRefreshRequestEvent()
        }
        addView(binding.root)
    }

    fun setSummonerInfo(summonerInfoDto: SummonerInfoDto) {
        binding.summonerInfo = summonerInfoDto
    }

    fun setRefreshRequestListener(clickEventDelivery: ClickEventDelivery?) {
        this.clickEventDelivery = clickEventDelivery
    }
}
