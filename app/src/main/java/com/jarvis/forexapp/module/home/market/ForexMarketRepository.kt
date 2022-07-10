package com.jarvis.forexapp.module.home.market

class ForexMarketRepository(
    private val remoteDataSource: ForexMarketRemoteDataSource,
) : BaseForexMarketRepository() {

    override suspend fun getCurrencyPair() = performNetworkRequest { remoteDataSource.getCurrencyPair() }

    override suspend fun getCurrencyRate(currencyList: List<String>) = performNetworkRequest { remoteDataSource.getCurrencyRate(currencyList) }

}