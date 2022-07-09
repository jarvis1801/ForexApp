package com.jarvis.forexapp.module.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jarvis.forexapp.module.home.market.ForexMarketFragment
import com.jarvis.forexapp.module.home.portfolio.PortfolioFragment

class HomeSectionAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {
    private var fragmentList: ArrayList<Fragment> = arrayListOf(
        ForexMarketFragment(),
        PortfolioFragment(),
        PortfolioFragment(),
        PortfolioFragment()
    )

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}