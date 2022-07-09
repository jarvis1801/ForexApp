package com.jarvis.forexapp.module.home.market

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jarvis.forexapp.base.BaseViewModel
import com.jarvis.forexapp.model.forex.Rate
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.util.*

class ForexMarketViewModel(
    private val forexMarketRepository: ForexMarketRepository
) : BaseViewModel() {

    private var currencyPair: List<String>? = null

    private val initCurrencyRate = arrayListOf<Rate>()

    private val _currencyRate = MutableLiveData<List<Rate>>()
    val currencyRate = _currencyRate as LiveData<List<Rate>>

    private var currencyRateTimerTask: TimerTask? = null
    private var currencyRateTimer: Timer? = null

    fun getCurrencyPair() = viewModelScope.launch(IO) {
        if (currencyPair.isNullOrEmpty()) {
            forexMarketRepository.getCurrencyPair().genericHandleNetworkRequest()?.supportedPairs?.let { supportedPairs ->
                currencyPair = supportedPairs.filter { it.startsWith("USD") }.take(15)
                setupCurrencyRateTimer()
            }
        } else {
            setupCurrencyRateTimer()
        }
    }

    private fun setupCurrencyRateTimer() {
        currencyRateTimer = Timer().apply {
            currencyRateTimerTask = object: TimerTask() {
                override fun run() {
                    getCurrencyRate()
                }
            }
            schedule(currencyRateTimerTask, 0, 1000L)
        }
    }

    fun stopCurrencyRateTimer() {
        currencyRateTimer?.let {
            it.cancel()
            it.purge()
        }
    }

    fun getCurrencyRate() = viewModelScope.launch(IO) {
        if (currencyPair?.isNotEmpty() == true) {
            forexMarketRepository.getCurrencyRate(currencyPair!!).genericHandleNetworkRequest()?.let { response ->
                val rateList = response.rates?.map {
                    val currentRate = it.value
                    val currentRateName = it.key

                    val initRateData = initCurrencyRate.find { it.pairName == currentRateName }
                    val initRate = initRateData?.rate ?: currentRate.rate

                    Rate(currentRate.rate, currentRate.timestamp, currentRateName, initRate)
                }

                if (initCurrencyRate.isEmpty()) {
                    initCurrencyRate.addAll(rateList ?: arrayListOf())
                }

                _currencyRate.postValue(rateList ?: listOf())
            }
        }
    }
}