package com.jarvis.forexapp.viewModel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.jarvis.forexapp.module.main.MainViewModel

class ViewModelFactory(owner: SavedStateRegistryOwner, defaultArgs: Bundle? = Bundle()) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
        return with(modelClass) {

            when {
                isAssignableFrom(MainViewModel::class.java) -> ViewModelBuilder.buildMainViewModel()

                else ->
                    throw IllegalArgumentException(
                        "Unknown ViewModel class: ${modelClass.name}"
                    )
            }

        } as T
    }

}

