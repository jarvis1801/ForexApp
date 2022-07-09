package com.jarvis.forexapp.module.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.jarvis.forexapp.R
import com.jarvis.forexapp.base.BaseFragment
import com.jarvis.forexapp.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    val viewModel: HomeViewModel by viewModels()

    override fun subscribeViewModel() {
        super.subscribeViewModel()

        viewModel.currentSectionPage.observe(viewLifecycleOwner) { page ->
            mViewBinding.bottomNavigation.menu.getItem(page).isChecked = true
            mViewBinding.viewpager.currentItem = page
        }
    }

    override fun initView() {
        setupBottomBar()
        setupViewPager()
    }

    private fun setupBottomBar() {
        mViewBinding.bottomNavigation.apply {
            setOnItemSelectedListener {
                val menuItemIndex = when (it.itemId) {
                    R.id.navigation_bar_market -> 0
                    R.id.navigation_bar_portfolio -> 1
                    else -> null
                }
                menuItemIndex?.let {
                    viewModel.setCurrentSectionPage(menuItemIndex)
                }
                true
            }
        }
    }

    private fun setupViewPager() {
        val adapter = HomeSectionAdapter(childFragmentManager, lifecycle)
        mViewBinding.viewpager.apply {
            setAdapter(adapter)
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    viewModel.setCurrentSectionPage(position)
                }
            })
            requestDisallowInterceptTouchEvent(false)
        }
    }

    override fun initListener() {

    }

    override fun initStartEvent() {

    }
}