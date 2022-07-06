package com.jarvis.forexapp.api

import com.jarvis.forexapp.api.service.ForexService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    val forexApi: ForexService by lazy { getRetrofitClient() }

    private inline fun <reified T> getRetrofitClient() = Retrofit.Builder()
        .baseUrl("")
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
        }.build()
    }
}