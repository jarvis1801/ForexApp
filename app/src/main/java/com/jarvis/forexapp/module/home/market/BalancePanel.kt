package com.jarvis.forexapp.module.home.market

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.jarvis.forexapp.databinding.PanelBalanceBinding
import com.jarvis.forexapp.model.forex.Rate
import com.jarvis.forexapp.util.ForexUtil.calculateEquity
import com.jarvis.forexapp.util.ForexUtil.toMoneyFormat

class BalancePanel @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {

    private val binding: PanelBalanceBinding by lazy {
        PanelBalanceBinding.inflate(LayoutInflater.from(context), this, true)
    }

    init {
        init()
    }

    private fun init() {
        binding
    }

    fun updateData(rateList: List<Rate>) {
        binding.tvEquityValue.text = rateList.calculateEquity().toMoneyFormat()

        binding.tvBalanceValue.text = (rateList.size * 10000).toFloat().toMoneyFormat()

        binding.tvMarginValue.text = 12345f.toMoneyFormat()

        binding.tvUsedValue.text = 12345f.toMoneyFormat()
    }
}