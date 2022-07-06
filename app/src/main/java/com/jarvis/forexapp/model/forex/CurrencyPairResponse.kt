package com.jarvis.forexapp.model.forex

data class CurrencyPairResponse(
    val message: String? = null,
    val supportedPairs: List<String>? = null,
    val code: String? = null
)