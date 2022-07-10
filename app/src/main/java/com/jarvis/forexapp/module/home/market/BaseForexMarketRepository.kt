package com.jarvis.forexapp.module.home.market

import com.jarvis.forexapp.base.BaseRepository
import com.jarvis.forexapp.model.Resource
import com.jarvis.forexapp.model.forex.CurrencyPairResponse
import com.jarvis.forexapp.model.forex.CurrencyRateResponse

abstract class BaseForexMarketRepository : BaseRepository() {

    abstract suspend fun getCurrencyPair(): Resource<CurrencyPairResponse>

    abstract suspend fun getCurrencyRate(currencyList: List<String>): Resource<CurrencyRateResponse>

}