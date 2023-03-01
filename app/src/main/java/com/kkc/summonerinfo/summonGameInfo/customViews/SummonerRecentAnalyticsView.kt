package com.kkc.summonerinfo.summonGameInfo.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import com.kkc.entity.dto.RecentAnalyticsDto
import com.kkc.summonerinfo.R
import com.kkc.summonerinfo.databinding.ViewRecentAnalyticsBinding

class SummonerRecentAnalyticsView : FrameLayout {
    constructor(context: Context) : super(context) {
        init()
    }
    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
        init()
    }

    private lateinit var binding: ViewRecentAnalyticsBinding

    private fun init() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_recent_analytics, this, false)
        addView(binding.root)
    }

    fun setRecentlyAnalyticsInfo(recentAnalyticsInfo: RecentAnalyticsDto) {
        binding.recentInfo = recentAnalyticsInfo
    }
}
