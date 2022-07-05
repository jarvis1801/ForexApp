package com.jarvis.forexapp.module.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.jarvis.forexapp.R
import com.jarvis.forexapp.base.BaseActivity
import com.jarvis.forexapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun subscribeViewModel() {

    }

    override fun initView() {

    }

    override fun initListener() {

    }

    override fun initStartEvent() {

    }

//    fun showLoading() {
//        mViewBinding.loadingFrame.showLoading()
//    }
//
//    fun hideLoading() {
//        mViewBinding.loadingFrame.hideLoading()
//    }
}