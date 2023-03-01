package com.kkc.summonerinfo.summonGameInfo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kkc.summonerinfo.databinding.ItemSpellBinding

class SpellAdapter: ListAdapter<String?, SpellViewHolder>(itemDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpellViewHolder {
        val binding = ItemSpellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpellViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpellViewHolder, position: Int) {
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

class SpellViewHolder(private val binding: ItemSpellBinding): RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: String?) {
        item?.let {
            binding.spellImage = it
        }
    }
}