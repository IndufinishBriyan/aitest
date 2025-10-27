package com.example.aitest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aitest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val initialPadding = binding.root.run {
            ViewPadding(paddingLeft, paddingTop, paddingRight, paddingBottom)
        }
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, windowInsets ->
            val systemBars = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                initialPadding.left + systemBars.left,
                initialPadding.top + systemBars.top,
                initialPadding.right + systemBars.right,
                initialPadding.bottom + systemBars.bottom
            )
            windowInsets
        }

        val summaryTiles = listOf(
            SummaryTile(
                title = getString(R.string.summary_tile_total),
                value = getString(R.string.summary_tile_placeholder),
                description = getString(R.string.summary_tile_hint)
            ),
            SummaryTile(
                title = getString(R.string.summary_tile_average),
                value = getString(R.string.summary_tile_placeholder),
                description = getString(R.string.summary_tile_hint)
            ),
            SummaryTile(
                title = getString(R.string.summary_tile_min),
                value = getString(R.string.summary_tile_placeholder),
                description = getString(R.string.summary_tile_hint)
            ),
            SummaryTile(
                title = getString(R.string.summary_tile_max),
                value = getString(R.string.summary_tile_placeholder),
                description = getString(R.string.summary_tile_hint)
            ),
            SummaryTile(
                title = getString(R.string.summary_tile_drying),
                value = getString(R.string.summary_tile_placeholder),
                description = getString(R.string.summary_tile_oven_hint)
            ),
            SummaryTile(
                title = getString(R.string.summary_tile_curing),
                value = getString(R.string.summary_tile_placeholder),
                description = getString(R.string.summary_tile_oven_hint)
            )
        )

        binding.summaryRecycler.apply {
            layoutManager = GridLayoutManager(
                this@MainActivity,
                resources.getInteger(R.integer.summary_span_count)
            )
            adapter = SummaryTileAdapter(summaryTiles)
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
        }

        val playfulMetrics = listOf(
            PlayfulMetric(
                title = getString(R.string.metric_visitors_title),
                primaryValue = getString(R.string.summary_tile_placeholder),
                descriptor = getString(R.string.metric_visitors_description),
                trendLabel = getString(R.string.metric_support_trend),
                isTrendPositive = true
            ),
            PlayfulMetric(
                title = getString(R.string.metric_sales_title),
                primaryValue = getString(R.string.summary_tile_placeholder),
                descriptor = getString(R.string.metric_sales_description),
                trendLabel = getString(R.string.metric_support_trend),
                isTrendPositive = true
            ),
            PlayfulMetric(
                title = getString(R.string.metric_retention_title),
                primaryValue = getString(R.string.summary_tile_placeholder),
                descriptor = getString(R.string.metric_retention_description),
                trendLabel = getString(R.string.metric_attention_trend),
                isTrendPositive = false
            ),
            PlayfulMetric(
                title = getString(R.string.metric_support_title),
                primaryValue = getString(R.string.summary_tile_placeholder),
                descriptor = getString(R.string.metric_support_description),
                trendLabel = getString(R.string.metric_support_trend),
                isTrendPositive = true
            ),
            PlayfulMetric(
                title = getString(R.string.metric_social_title),
                primaryValue = getString(R.string.summary_tile_placeholder),
                descriptor = getString(R.string.metric_social_description),
                trendLabel = getString(R.string.metric_support_trend),
                isTrendPositive = true
            )
        )

        binding.metricRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PlayfulMetricAdapter(playfulMetrics)
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
        }
    }
}

private data class ViewPadding(
    val left: Int,
    val top: Int,
    val right: Int,
    val bottom: Int
)
