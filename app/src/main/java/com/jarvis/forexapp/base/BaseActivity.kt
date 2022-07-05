package com.jarvis.forexapp.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.jarvis.forexapp.ViewModelFactory

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {
    protected var mViewBinding: VB? = null
        private set

    abstract val bindingInflater: (LayoutInflater) -> VB

    var mViewModel: VM? = null

    protected abstract fun getViewModelClass(): Class<VM>

    abstract fun initView()
    abstract fun initListener()
    abstract fun initStartEvent()
    abstract fun subscribeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModelFactory = ViewModelFactory(this, intent.extras)
        mViewModel = ViewModelProvider(this, viewModelFactory)[getViewModelClass()]
        subscribeViewModel()

        mViewBinding = bindingInflater.invoke(layoutInflater)
        initView()
        initListener()
        initStartEvent()
    }
}