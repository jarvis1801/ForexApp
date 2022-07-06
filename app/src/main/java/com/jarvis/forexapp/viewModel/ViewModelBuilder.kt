package com.jarvis.forexapp.viewModel

import com.jarvis.forexapp.module.main.MainViewModel

object ViewModelBuilder {

    fun buildMainViewModel(): MainViewModel {
        val viewModel = MainViewModel()
        return viewModel
    }
}