package com.jarvis.forexapp.viewModel

import com.jarvis.forexapp.module.home.market.ForexMarketRemoteDataSource
import com.jarvis.forexapp.module.home.market.ForexMarketRepository
import com.jarvis.forexapp.module.home.market.ForexMarketViewModel
import com.jarvis.forexapp.module.main.MainViewModel

object ViewModelBuilder {

    fun buildMainViewModel(): MainViewModel {
        return MainViewModel()
    }

    fun buildForexMarketViewModel(): ForexMarketViewModel {

        val forexMarketRepository = ForexMarketRepository(ForexMarketRemoteDataSource())

        return ForexMarketViewModel(
            forexMarketRepository
        )
    }
}