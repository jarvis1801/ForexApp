package com.jarvis.forexapp.module.home.market

import com.jarvis.forexapp.App
import com.jarvis.forexapp.base.BaseDataSource
import com.jarvis.forexapp.model.Resource
import com.jarvis.forexapp.model.forex.CurrencyPairResponse
import com.jarvis.forexapp.model.forex.CurrencyRateResponse
import com.jarvis.forexapp.util.GsonUtil.stringToObject

class ForexMarketDummyDataSource : BaseDataSource() {

    companion object {
        private const val FILE_PATH = "forexDummyData/{index}.json"

        private var index = 0
    }

    fun getCurrencyPair() = Resource.success(
        CurrencyPairResponse(
            message = "dummy",
            supportedPairs = listOf("USDDummy"),
            code = "200"
        ), 200
    )

    fun getCurrencyRate(): Resource<CurrencyRateResponse> {
        val body = App.instance.getStringFromAsset(FILE_PATH.replace("{index}", index++.getModValue()))!!.stringToObject<CurrencyRateResponse>()
        return Resource.success(body, 200)
    }

    private fun Int.getModValue(): String {
        return mod(15).plus(1).toString()
    }
}