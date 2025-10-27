package com.example.aitest

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.aitest.databinding.ItemMetricCardBinding

class PlayfulMetricAdapter(
    private val metrics: List<PlayfulMetric>
) : RecyclerView.Adapter<PlayfulMetricAdapter.MetricViewHolder>() {

    private val accentColors = listOf(
        R.color.metric_accent_one,
        R.color.metric_accent_two,
        R.color.metric_accent_three,
        R.color.metric_accent_four,
        R.color.metric_accent_five
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MetricViewHolder {
        val binding = ItemMetricCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MetricViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MetricViewHolder, position: Int) {
        val metric = metrics[position]
        val context = holder.binding.root.context
        val accentColorRes = accentColors[position % accentColors.size]
        val accentColor = ContextCompat.getColor(context, accentColorRes)

        holder.binding.apply {
            metricCard.setCardBackgroundColor(
                ContextCompat.getColor(context, R.color.surface_primary)
            )
            metricCard.strokeColor = accentColor
            metricTitle.text = metric.title
            metricValue.text = metric.primaryValue
            metricValue.setTextColor(accentColor)
            metricDescription.text = metric.descriptor
            trendChip.text = metric.trendLabel
            if (metric.isTrendPositive) {
                val color = ContextCompat.getColor(context, R.color.trend_positive_text)
                trendChip.setChipIconResource(R.drawable.ic_trending_up)
                trendChip.setChipBackgroundColorResource(R.color.trend_positive_background)
                trendChip.setTextColor(color)
                trendChip.chipIconTint = ColorStateList.valueOf(color)
                trendChip.chipStrokeColor = ColorStateList.valueOf(color)
                trendChip.chipStrokeWidth = context.resources.displayMetrics.density
            } else {
                val color = ContextCompat.getColor(context, R.color.trend_negative_text)
                trendChip.setChipIconResource(R.drawable.ic_trending_down)
                trendChip.setChipBackgroundColorResource(R.color.trend_negative_background)
                trendChip.setTextColor(color)
                trendChip.chipIconTint = ColorStateList.valueOf(color)
                trendChip.chipStrokeColor = ColorStateList.valueOf(color)
                trendChip.chipStrokeWidth = context.resources.displayMetrics.density
            }
        }
    }

    override fun getItemCount(): Int = metrics.size

    class MetricViewHolder(val binding: ItemMetricCardBinding) : RecyclerView.ViewHolder(binding.root)
}
