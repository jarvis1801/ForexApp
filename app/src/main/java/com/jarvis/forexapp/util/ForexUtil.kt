package com.jarvis.forexapp.util

import android.content.Context
import androidx.core.content.res.ResourcesCompat
import com.jarvis.forexapp.R
import com.jarvis.forexapp.model.forex.Rate
import com.jarvis.forexapp.util.ForexUtil.toMoneyFormat
import java.text.DecimalFormat
import java.util.concurrent.ThreadLocalRandom

object ForexUtil {

    fun Float.add1To10Percent(): Float {
        val percent = ThreadLocalRandom.current().nextInt(1, 10).toFloat() / 100.toFloat()
        return this * (1.toFloat() + percent)
    }

    fun Float.reduce1To10Percent(): Float {
        val percent = ThreadLocalRandom.current().nextInt(1, 10).toFloat() / 100.toFloat()
        return this * (1.toFloat() - percent)
    }

    fun Float.formatTo2Decimal(): String {
        val format = DecimalFormat("0.0#")
        return format.format(this)
    }

    fun calculateChangePercent(newValue: Float, oldValue: Float): Float {
        return newValue.minus(oldValue).div(oldValue).times(100f)
    }

    fun Float.toMoneyFormat(): String {
        val value = String.format("%.2f", this)
        return "$$value"
    }

    fun List<Rate>.calculateEquity(): Float {
        return sumOf {
            (10000 * (1f + (it.changeRate ?: 1f))).toDouble()
        }.toFloat()
    }

    fun getRateChangeColorRes(value: Float?): Int {
        return if (value == null) {
            R.color.white
        } else if (value >= 0) {
            R.color.positive_change
        } else {
            R.color.negative_change
        }
    }

    fun Float.toPercentFormat(): String {
        val value = this.formatTo2Decimal()
        return "$value%"
    }
}