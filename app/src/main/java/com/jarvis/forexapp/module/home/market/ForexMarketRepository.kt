package com.jarvis.forexapp.module.home.market

import com.jarvis.forexapp.base.BaseRepository

class ForexMarketRepository(
    private val remoteDataSource: ForexMarketRemoteDataSource,
) : BaseRepository() {

    suspend fun getCurrencyPair() = performNetworkRequest { remoteDataSource.getCurrencyPair() }

    suspend fun getCurrencyRate(currencyList: List<String>) = performNetworkRequest { remoteDataSource.getCurrencyRate(currencyList) }

}