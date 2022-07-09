package com.jarvis.forexapp.module.home.market

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.jarvis.forexapp.base.BaseRecyclerViewAdapter
import com.jarvis.forexapp.base.BaseViewHolder
import com.jarvis.forexapp.databinding.ItemCurrencyRateBinding
import com.jarvis.forexapp.model.forex.Rate
import com.jarvis.forexapp.util.ForexUtil.formatTo2Decimal
import com.jarvis.forexapp.util.ForexUtil.getRateChangeColorRes
import com.jarvis.forexapp.util.ForexUtil.toPercentFormat

class ForexMarketAdapter(context: Context) : BaseRecyclerViewAdapter<ForexMarketAdapter.ViewHolder>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemCurrencyRateBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position], position)
    }

    inner class ViewHolder(private val binding: ItemCurrencyRateBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: Any, position: Int) {
            val currentItem = item as Rate

            currentItem.apply {
                binding.tvRateName.text = pairName

                binding.tvChangePercentage.apply {
                    val color = ResourcesCompat.getColor(resources, getRateChangeColorRes(changeRate), null)
                    setTextColor(color)
                    text = changeRate?.toPercentFormat()
                }

                binding.tvSell.text = sell?.formatTo2Decimal()

                binding.tvBuy.text = buy?.formatTo2Decimal()
            }

        }


    }


}