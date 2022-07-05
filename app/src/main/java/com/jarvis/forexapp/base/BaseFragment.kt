package com.jarvis.forexapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewbinding.ViewBinding
import com.jarvis.forexapp.module.main.MainViewModel
import com.jarvis.forexapp.util.ViewExtension.hideStatusBar
import com.jarvis.forexapp.util.ViewExtension.showStatusBar

abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    protected lateinit var mViewBinding: VB
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    private val mMainActivityViewModel: MainViewModel by activityViewModels()

    open var isFullScreen = false

    open fun subscribeViewModel() {
//        mMainActivityViewModel?.requestLoading?.observe(viewLifecycleOwner) {
//            if (it == true) {
//                showLoading()
//            }
//        }
//
//        mMainActivityViewModel?.reduceLoading?.observe(viewLifecycleOwner) {
//            if (it == true) {
//                hideLoading()
//            }
//        }
    }

    open fun getArgs(): Bundle { return Bundle() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (isFullScreen) hideStatusBar()

        subscribeViewModel()
        mViewBinding = bindingInflater.invoke(inflater, container, false)
        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initListener()
        initStartEvent()
    }

    abstract fun initView()
    abstract fun initListener()
    abstract fun initStartEvent()

//    private fun showLoading() {
//        val mainActivity = requireActivity() as MainActivity
//        mainActivity.showLoading()
//    }
//
//    private fun hideLoading() {
//        val mainActivity = requireActivity() as MainActivity
//        mainActivity.hideLoading()
//    }

    override fun onDestroy() {
        if (isFullScreen) showStatusBar()
        super.onDestroy()
    }
}