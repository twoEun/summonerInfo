package com.kkc.summonerinfo.summonGameInfo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kkc.summonerinfo.R
import com.kkc.summonerinfo.databinding.ItemGameItemBinding

class GameItemAdapter : ListAdapter<String?, GameItemViewHolder>(itemDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameItemViewHolder {
        val binding = DataBindingUtil.inflate<ItemGameItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_game_item,
            parent,
            false
        )
        return GameItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameItemViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}

private val itemDiff = object : DiffUtil.ItemCallback<String?>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}

class GameItemViewHolder(private val binding: ItemGameItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: String?) {
        item?.let {
            binding.itemImage = it
        }
    }
}
