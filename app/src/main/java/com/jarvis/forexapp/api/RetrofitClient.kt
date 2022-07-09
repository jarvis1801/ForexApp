package com.jarvis.forexapp.api

import com.jarvis.forexapp.App
import com.jarvis.forexapp.R
import com.jarvis.forexapp.api.service.ForexService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {

    private const val TIME_OUT = 10L

    private val forexApiUrl = App.instance.resources.getString(R.string.FOREX_BASE_URL)

    val forexApi: ForexService by lazy { getRetrofitClient() }

    private inline fun <reified T> getRetrofitClient() = Retrofit.Builder()
        .baseUrl(forexApiUrl)
        .addConverterFactory(NullOnEmptyConverterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .client(getOkhttpClient())
        .build()
        .create(T::class.java)


    private fun getOkhttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder().apply {
            addInterceptor(loggingInterceptor)
            connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            readTimeout(TIME_OUT, TimeUnit.SECONDS)
            writeTimeout(TIME_OUT, TimeUnit.SECONDS)
        }.build()
    }
}