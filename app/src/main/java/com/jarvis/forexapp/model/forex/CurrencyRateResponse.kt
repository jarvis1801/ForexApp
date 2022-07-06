package com.jarvis.forexapp.model.forex

data class CurrencyRateResponse(
    val rates: Rate? = null,
    val code: String? = null
)

data class Rate(
    val USDALL: RateValue? = null,
    val USDJPY: RateValue? = null,
    val USDHKD: RateValue? = null,
    val USDGBP: RateValue? = null,
    val USDEUR: RateValue? = null,
)

data class RateValue(
    val rate: Float? = null,
    val timestamp: Int? = null
)