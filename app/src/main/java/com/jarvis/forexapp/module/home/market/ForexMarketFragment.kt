package com.jarvis.forexapp.module.home.market

import android.view.LayoutInflater
import android.view.ViewGroup
import com.jarvis.forexapp.base.BaseFragment
import com.jarvis.forexapp.databinding.FragmentForexMarketBinding

class ForexMarketFragment : BaseFragment<FragmentForexMarketBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentForexMarketBinding
        get() = FragmentForexMarketBinding::inflate

    override fun initView() { }

    override fun initListener() { }

    override fun initStartEvent() { }
}