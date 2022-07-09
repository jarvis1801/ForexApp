package com.jarvis.forexapp.util

import com.jarvis.forexapp.model.forex.Rate
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
        val format = DecimalFormat("#.##")
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
}