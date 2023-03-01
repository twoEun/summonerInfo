package com.kkc.summonerinfo.summonGameInfo.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kkc.entity.dto.GameInfoDto
import com.kkc.summonerinfo.R
import com.kkc.summonerinfo.databinding.ItemGameInfoBinding
import com.kkc.summonerinfo.util.CustomDecoration
import com.kkc.summonerinfo.util.GridDecoration
import com.kkc.summonerinfo.util.convertDpToPx

class GameInfoAdapter : ListAdapter<GameInfoDto, GameInfoViewHolder>(itemDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameInfoViewHolder {
        val binding = DataBindingUtil.inflate<ItemGameInfoBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_game_info,
            parent,
            false
        )
        setSpellListDecoration(parent.context, binding.gameSpellList)
        setItemListDecoration(parent.context, binding.gameItemList)
        return GameInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameInfoViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    private fun setSpellListDecoration(context: Context, spellList: RecyclerView) {
        spellList.apply {

                addItemDecoration(
                    GridDecoration(
                        topPadding = convertDpToPx(context, 2f),
                        leftPadding = convertDpToPx(context, 2f),
                        spanCount = 2,
                        Color.TRANSPARENT
                    )
                )

        }
    }

    private fun setItemListDecoration(context: Context, itemList: RecyclerView) {
        itemList.apply {

                addItemDecoration(
                    CustomDecoration(
                        height = 0,
                        padding = convertDpToPx(context, 2f),
                        Color.TRANSPARENT,
                        false
                    )
                )

        }
    }
}

private val itemDiff = object : DiffUtil.ItemCallback<GameInfoDto>() {
    override fun areItemsTheSame(oldItem: GameInfoDto, newItem: GameInfoDto): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GameInfoDto, newItem: GameInfoDto): Boolean {
        return oldItem.mmr == newItem.mmr
    }
}

class GameInfoViewHolder(private val binding: ItemGameInfoBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: GameInfoDto) {
        binding.gameInfo = item
    }
}
