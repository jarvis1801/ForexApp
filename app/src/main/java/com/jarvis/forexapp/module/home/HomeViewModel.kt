package com.jarvis.forexapp.module.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jarvis.forexapp.base.BaseViewModel

class HomeViewModel : BaseViewModel() {
    private val _currentSectionPage = MutableLiveData<Int>()
    val currentSectionPage = _currentSectionPage as LiveData<Int>

    fun setCurrentSectionPage(position: Int) {
        _currentSectionPage.postValue(position)
    }
}