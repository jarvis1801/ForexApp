package com.jarvis.forexapp.model.forex

import com.google.gson.annotations.Expose
import com.jarvis.forexapp.util.ForexUtil.add1To10Percent
import com.jarvis.forexapp.util.ForexUtil.calculateChangePercent
import com.jarvis.forexapp.util.ForexUtil.reduce1To10Percent

data class CurrencyRateResponse(
    @Expose val rates: Map<String, Rate>? = null,
    val code: String? = null
)

data class Rate(
    var rate: Double? = null,
    val timestamp: Int? = null,

    @Transient var pairName: String? = null,
    @Transient val initRate: Double? = null,
    @Transient var changeRate: Double? = calculateChangePercent(rate ?: 0.0, initRate ?: rate ?: 0.0),
    @Transient var sell: Double? = null,
    @Transient var buy: Double? = null
) {

    init {
        generateSell()
        generateBuy()
    }

    private fun generateSell() {
        sell = rate?.add1To10Percent()
    }

    private fun generateBuy() {
        buy = rate?.reduce1To10Percent()
    }
}