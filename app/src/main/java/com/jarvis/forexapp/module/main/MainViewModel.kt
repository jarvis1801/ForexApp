package com.jarvis.forexapp.module.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jarvis.forexapp.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    private val _apiRequestNotFinishCount = MutableLiveData(0)
    val apiRequestNotFinishCount = _apiRequestNotFinishCount as LiveData<Int>

    fun addApiRequestCount() {
        var apiRequestNotFinishCount = _apiRequestNotFinishCount.value ?: 0
        _apiRequestNotFinishCount.postValue(++apiRequestNotFinishCount)
    }

    fun reduceApiRequestCount() {
        var apiRequestNotFinishCount = _apiRequestNotFinishCount.value ?: 0
        if (apiRequestNotFinishCount > 0) {
            _apiRequestNotFinishCount.postValue(--apiRequestNotFinishCount)
        }
    }
}