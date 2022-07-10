package com.jarvis.forexapp.module.home.market

import com.jarvis.forexapp.model.Resource
import com.jarvis.forexapp.model.forex.CurrencyRateResponse

class ForexMarketDummyRepository(
    private val remoteDataSource: ForexMarketDummyDataSource,
) : BaseForexMarketRepository() {

    override suspend fun getCurrencyPair() = remoteDataSource.getCurrencyPair()

    override suspend fun getCurrencyRate(currencyList: List<String>): Resource<CurrencyRateResponse> = remoteDataSource.getCurrencyRate()

}