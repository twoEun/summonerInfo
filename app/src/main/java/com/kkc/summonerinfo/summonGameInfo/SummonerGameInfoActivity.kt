package com.kkc.summonerinfo.summonGameInfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kkc.summonerinfo.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SummonerGameInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summoner_game_info)
    }
}
