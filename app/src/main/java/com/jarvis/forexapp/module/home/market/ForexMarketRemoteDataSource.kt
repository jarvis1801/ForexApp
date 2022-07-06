package com.jarvis.forexapp.module.home.market

import com.jarvis.forexapp.api.RetrofitClient
import com.jarvis.forexapp.base.BaseDataSource

class ForexMarketRemoteDataSource : BaseDataSource() {

    suspend fun getCurrencyPair() = getResult {
        RetrofitClient.forexApi.getCurrencyPair()
    }

    suspend fun getCurrencyRate(currencyList: List<String>) = getResult {
        RetrofitClient.forexApi.getCurrencyRate(currencyList.joinToString(separator = ","))
    }
}