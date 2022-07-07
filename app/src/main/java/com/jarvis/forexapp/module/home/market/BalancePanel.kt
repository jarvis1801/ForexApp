package com.jarvis.forexapp.module.home.market

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.jarvis.forexapp.databinding.PanelBalanceBinding

class BalancePanel @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    CardView(context, attrs, defStyleAttr) {

    private val binding: PanelBalanceBinding by lazy {
        PanelBalanceBinding.inflate(LayoutInflater.from(context), this, true)
    }

    init {
        init()
    }

    private fun init() {
        binding
    }

    fun updateData() {
        // todo update value
        binding.tvEquityValue

        binding.tvBalanceValue

        binding.tvMarginValue

        binding.tvUsedValue
    }
}