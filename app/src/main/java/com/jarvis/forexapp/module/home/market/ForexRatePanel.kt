package com.jarvis.forexapp.module.home.market

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.jarvis.forexapp.databinding.PanelForexRateBinding

class ForexRatePanel @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {
    private val binding by lazy {
        PanelForexRateBinding.inflate(LayoutInflater.from(context), this, true)
    }

    init {
        init()
    }

    private fun init() {
        binding
    }
}