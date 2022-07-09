package com.jarvis.forexapp.model.forex

import com.google.gson.annotations.Expose

data class CurrencyRateResponse(
    @Expose val rates: Map<String, Rate>? = null,
    val code: String? = null
)

data class Rate(
    val rate: Float? = null,
    val timestamp: Int? = null
)