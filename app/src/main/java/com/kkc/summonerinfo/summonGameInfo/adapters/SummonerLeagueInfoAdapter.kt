package com.kkc.summonerinfo.summonGameInfo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kkc.entity.dto.SummonerLeagueInfoDto
import com.kkc.summonerinfo.R
import com.kkc.summonerinfo.databinding.ItemLeagueInfoBinding

class SummonerLeagueInfoAdapter : ListAdapter<SummonerLeagueInfoDto, SummonerLeagueViewHolder>(itemDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummonerLeagueViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemLeagueInfoBinding>(inflater, R.layout.item_league_info, parent, false)

        binding.goLeagueDetail.setOnClickListener {
            Toast.makeText(parent.context, R.string.not_support_league_detail, Toast.LENGTH_SHORT).show()
        }

        return SummonerLeagueViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SummonerLeagueViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}

private val itemDiff = object : DiffUtil.ItemCallback<SummonerLeagueInfoDto>() {
    override fun areItemsTheSame(
        oldItem: SummonerLeagueInfoDto,
        newItem: SummonerLeagueInfoDto
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: SummonerLeagueInfoDto,
        newItem: SummonerLeagueInfoDto
    ): Boolean {
        return oldItem == newItem
    }
}

class SummonerLeagueViewHolder(private val binding: ItemLeagueInfoBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: SummonerLeagueInfoDto) {
        binding.leagueInfo = item
    }
}