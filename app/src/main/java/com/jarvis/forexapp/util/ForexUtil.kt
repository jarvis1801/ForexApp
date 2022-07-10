package com.jarvis.forexapp.util

import com.jarvis.forexapp.R
import java.text.DecimalFormat
import java.util.concurrent.ThreadLocalRandom

object ForexUtil {

    fun Double.add1To10Percent(): Double {
        val percent = ThreadLocalRandom.current().nextInt(1, 10).toDouble() / 100.toDouble()
        return this * (1.toDouble() + percent)
    }

    fun Double.reduce1To10Percent(): Double {
        val percent = ThreadLocalRandom.current().nextInt(1, 10).toDouble() / 100.toDouble()
        return this * (1.toDouble() - percent)
    }

    fun Double.formatTo2Decimal(): String {
        val format = DecimalFormat("0.0#")
        return format.format(this)
    }

    fun calculateChangePercent(newValue: Double, oldValue: Double): Double {
        return newValue.minus(oldValue).div(oldValue).times(100f)
    }

    fun Double.toMoneyFormat(): String {
        val value = String.format("%.2f", this)
        return "$$value"
    }

    fun List<Double>.calculateEquity(): Double {
        return sumOf { (1 + (it / 100)) * 10000 }
    }

    fun getRateChangeColorRes(value: Double?): Int {
        return if (value == null) {
            R.color.white
        } else if (value >= 0) {
            R.color.positive_change
        } else {
            R.color.negative_change
        }
    }

    fun Double.toPercentFormat(): String {
        val value = this.plus(0.0).formatTo2Decimal()
        return "$value%"
    }
}