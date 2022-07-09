package com.jarvis.forexapp.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jarvis.forexapp.model.Resource
import com.jarvis.forexapp.model.Status

abstract class BaseViewModel : ViewModel() {

    private val _errorMessage = MutableLiveData("")
    val errorMessage = _errorMessage as LiveData<String>

    fun <T> Resource<T>.genericHandleNetworkRequest(): T? {
        return if (status == Status.SUCCESS) data else {
            _errorMessage.postValue(message)
            null
        }
    }
}