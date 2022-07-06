package com.jarvis.forexapp.api.service

import com.jarvis.forexapp.model.forex.CurrencyPairResponse
import com.jarvis.forexapp.model.forex.CurrencyRateResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ForexService {

    @GET("api/live")
    suspend fun getCurrencyPair() : Response<CurrencyPairResponse>

    @GET("api/live")
    suspend fun getCurrencyRate(@Query("pairs") pairs: String) : Response<CurrencyRateResponse>
}