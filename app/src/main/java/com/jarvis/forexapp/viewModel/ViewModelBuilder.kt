package com.jarvis.forexapp.viewModel

import com.jarvis.forexapp.module.home.market.*
import com.jarvis.forexapp.module.main.MainViewModel

object ViewModelBuilder {

    fun buildMainViewModel(): MainViewModel {
        return MainViewModel()
    }

    fun buildForexMarketViewModel(): ForexMarketViewModel {

        val forexMarketRepository = ForexMarketDummyRepository(ForexMarketDummyDataSource())

        return ForexMarketViewModel(
            forexMarketRepository
        )
    }
}