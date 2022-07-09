package com.jarvis.forexapp.module.home.market

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.jarvis.forexapp.R
import com.jarvis.forexapp.databinding.PanelForexRateBinding
import com.jarvis.forexapp.model.forex.Rate

class ForexRatePanel @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {
    private val binding by lazy {
        PanelForexRateBinding.inflate(LayoutInflater.from(context), this, true)
    }

    private val listAdapter: ForexMarketAdapter by lazy {
        ForexMarketAdapter(context)
    }

    init {
        init()
    }

    private fun init() {
        binding.rvCurrencyRate.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                val drawable = GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, intArrayOf(-0x80809, -0x80809)).apply {
                    val color = ResourcesCompat.getColor(context.resources, R.color.secondary_200, null)
                    setColor(color)
                    setSize(1, 1)
                }
                setDrawable(drawable)
            })
            adapter = listAdapter
        }
    }

    suspend fun updateList(currencyRate: List<Rate>) {
        listAdapter.submitList(currencyRate.toCollection(ArrayList()))
    }
}