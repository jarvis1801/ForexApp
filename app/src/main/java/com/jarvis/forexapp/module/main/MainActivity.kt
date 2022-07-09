package com.jarvis.forexapp.module.main

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import androidx.appcompat.widget.SearchView
import com.jarvis.forexapp.R
import com.jarvis.forexapp.base.BaseActivity
import com.jarvis.forexapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun subscribeViewModel() {
    }

    override fun initView() {
        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(mViewBinding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        mViewBinding.toolbar.title = ""
        mViewBinding.toolbar.subtitle = ""
    }

    override fun initListener() {

    }

    override fun initStartEvent() {

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }

        return true
    }
}