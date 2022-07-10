package com.jarvis.forexapp

import com.jarvis.forexapp.util.ForexUtil.add1To10Percent
import com.jarvis.forexapp.util.ForexUtil.calculateChangePercent
import com.jarvis.forexapp.util.ForexUtil.calculateEquity
import com.jarvis.forexapp.util.ForexUtil.formatTo2Decimal
import com.jarvis.forexapp.util.ForexUtil.getRateChangeColorRes
import com.jarvis.forexapp.util.ForexUtil.reduce1To10Percent
import com.jarvis.forexapp.util.ForexUtil.toMoneyFormat
import com.jarvis.forexapp.util.ForexUtil.toPercentFormat
import org.junit.Assert
import org.junit.Test

class ForexUnitTest {
    @Test
    fun add1To10Percent_isCorrect() {
        val value = 1.toDouble().add1To10Percent()
        Assert.assertTrue(value > 1f && value <= 1.1f)
    }

    @Test
    fun reduce1To10Percent_isCorrect() {
        val value = 1.toDouble().reduce1To10Percent()
        Assert.assertTrue(value > 0.9f && value <= 1f)
    }

    @Test
    fun formatTo2Decimal_isCorrect() {
        val value = 1.toDouble().formatTo2Decimal()
        Assert.assertTrue(value == "1.0")
        Assert.assertTrue(value != "1.00")
    }

    @Test
    fun calculateChangePercent_isCorrect() {
        val value = calculateChangePercent(50.0, 20.0)
        Assert.assertTrue(value == 150.0)

        val value2 = calculateChangePercent(20.0, 50.0)
        Assert.assertTrue(value2 == -60.0)
    }

    @Test
    fun toMoneyFormat_isCorrect() {
        val value = 10000.toDouble().toMoneyFormat()
        Assert.assertTrue(value == "$10000.00")

        val value2 = 0.toDouble().toMoneyFormat()
        Assert.assertTrue(value2 == "$0.00")
    }

    @Test
    fun calculateEquity_isCorrect() {
        val dummyData = listOf(
            0.0,                // 10000
            12.0,               // 11200
            30.0,               // 13000
            -16.0               // 8400
        )

        val value = dummyData.calculateEquity()
        println(value)
        Assert.assertTrue(value == 42600.0)
    }

    @Test
    fun getRateChangeColorRes_isCorrect() {
        val value = getRateChangeColorRes(0.toDouble())
        val value2 = getRateChangeColorRes(1.toDouble())

        val exceptResult = R.color.positive_change
        Assert.assertTrue(value == exceptResult && value2 == exceptResult)

        val value3 = getRateChangeColorRes((-1).toDouble())

        val exceptResult2 = R.color.negative_change
        Assert.assertTrue(value3 == exceptResult2)
    }

    @Test
    fun toPercentFormat_isCorrect() {
        val value = 0.12.toPercentFormat()
        Assert.assertTrue(value == "0.12%")

        val value2 = 0.10.toPercentFormat()
        Assert.assertTrue(value2 == "0.1%")

        val value3 = 0.11.toPercentFormat()
        Assert.assertTrue(value3 == "0.11%")

        val value4 = (-0.0).toPercentFormat()
        println(value4)
        Assert.assertTrue(value4 == "0.0%")

        val value5 = (-0.01).toPercentFormat()
        Assert.assertTrue(value5 == "-0.01%")

        val value6 = (-0.10).toPercentFormat()
        Assert.assertTrue(value6 == "-0.1%")

        val value7 = (-0.11).toPercentFormat()
        Assert.assertTrue(value7 == "-0.11%")
    }
}