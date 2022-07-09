package com.jarvis.forexapp.module.home.market

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.jarvis.forexapp.base.BaseFragment
import com.jarvis.forexapp.databinding.FragmentForexMarketBinding
import com.jarvis.forexapp.viewModel.ViewModelFactory
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ForexMarketFragment : BaseFragment<FragmentForexMarketBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentForexMarketBinding
        get() = FragmentForexMarketBinding::inflate

    private val viewModel: ForexMarketViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory(this, arguments))[ForexMarketViewModel::class.java]
    }

    override fun subscribeViewModel() {
        super.subscribeViewModel()

        viewModel.observerErrorMessage()

        viewModel.currencyRate.observe(viewLifecycleOwner) { currencyRate ->
            currencyRate?.let {
                lifecycleScope.launch(IO) {
                    mViewBinding.ratePanel.updateList(currencyRate)
                }
                mViewBinding.balancePanel.updateData(currencyRate)
            }
        }
    }

    override fun initView() { }

    override fun initListener() { }

    override fun initStartEvent() { }

    override fun onResume() {
        super.onResume()
        viewModel.getCurrencyPair()
    }

    override fun onPause() {
        super.onPause()
        viewModel.stopCurrencyRateTimer()
    }
}