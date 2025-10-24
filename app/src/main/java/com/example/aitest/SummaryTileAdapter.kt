package com.example.aitest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aitest.databinding.ItemSummaryTileBinding

class SummaryTileAdapter(
    private val tiles: List<SummaryTile>
) : RecyclerView.Adapter<SummaryTileAdapter.SummaryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummaryViewHolder {
        val binding = ItemSummaryTileBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SummaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SummaryViewHolder, position: Int) {
        val tile = tiles[position]
        holder.binding.summaryTitle.text = tile.title
        holder.binding.summaryValue.text = tile.value
        holder.binding.summarySubtitle.text = tile.description
    }

    override fun getItemCount(): Int = tiles.size

    class SummaryViewHolder(val binding: ItemSummaryTileBinding) : RecyclerView.ViewHolder(binding.root)
}
