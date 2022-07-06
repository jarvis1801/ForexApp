package com.jarvis.forexapp.base

import com.jarvis.forexapp.model.Resource
import com.jarvis.forexapp.model.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseRepository {

    protected suspend fun <A> performNetworkRequest(
        networkCall: suspend () -> Resource<A>
    ): Resource<A> = withContext(Dispatchers.IO) {

        val response : Resource<A> = networkCall.invoke()
        val statusCode = response.statusCode
        when (response.status) {
            Status.SUCCESS -> {
                val data = response.data!!
                return@withContext Resource.success(data, statusCode)
            }
            Status.ERROR -> {
                val error = response.message
                return@withContext Resource.error(error ?: "", statusCode)
            }
        }
    }
}