package com.example.aitest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        val playfulMetrics = listOf(
            PlayfulMetric(
                title = getString(R.string.metric_visitors_title),
                primaryValue = "12.4K",
                descriptor = getString(R.string.metric_visitors_description),
                trendLabel = "+18%",
                isTrendPositive = true
            ),
            PlayfulMetric(
                title = getString(R.string.metric_sales_title),
                primaryValue = "€8.9K",
                descriptor = getString(R.string.metric_sales_description),
                trendLabel = "+6%",
                isTrendPositive = true
            ),
            PlayfulMetric(
                title = getString(R.string.metric_retention_title),
                primaryValue = "72%",
                descriptor = getString(R.string.metric_retention_description),
                trendLabel = "-3%",
                isTrendPositive = false
            ),
            PlayfulMetric(
                title = getString(R.string.metric_support_title),
                primaryValue = "94",
                descriptor = getString(R.string.metric_support_description),
                trendLabel = getString(R.string.metric_support_trend),
                isTrendPositive = true
            ),
            PlayfulMetric(
                title = getString(R.string.metric_social_title),
                primaryValue = "1.7K",
                descriptor = getString(R.string.metric_social_description),
                trendLabel = "+240",
                isTrendPositive = true
            )
        )

        binding.metricRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PlayfulMetricAdapter(playfulMetrics)
            setHasFixedSize(true)
        }

        binding.summaryCardTitle.text = getString(R.string.summary_card_title)
        binding.summaryCardValue.text = getString(R.string.summary_card_value)
        binding.summaryCardSubtitle.text = getString(R.string.summary_card_subtitle)
    }
}

private data class ViewPadding(
    val left: Int,
    val top: Int,
    val right: Int,
    val bottom: Int
)
