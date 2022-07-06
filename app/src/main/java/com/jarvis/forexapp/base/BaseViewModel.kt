package com.jarvis.forexapp.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val _apiRequestStarted = MutableLiveData(false)
    val apiRequestStarted = _apiRequestStarted as LiveData<Boolean>

    private val _apiRequestFinished = MutableLiveData(false)
    val apiRequestFinished = _apiRequestFinished as LiveData<Boolean>

    fun onApiRequestStarted() {
        _apiRequestStarted.postValue(true)
        _apiRequestStarted.postValue(false)
    }

    fun onApiRequestFinished() {
        _apiRequestFinished.postValue(true)
        _apiRequestFinished.postValue(false)
    }
}