package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.ComparisonOperatorEnum
import kotlin.test.Test
import kotlin.test.assertEquals

class NumberComparisonTest {
    internal data class TestData<T>(
        val operator: ComparisonOperatorEnum,
        val params: T,
        val input: T?,
        val valid: Boolean
    ) where T : Number, T : Comparable<T>

    private val byteDataset = listOf<TestData<Byte>>(
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.toByte(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.toByte(), input = 1.toByte(), valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.toByte(), input = (-1).toByte(), valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.toByte(), input = 0.toByte(), valid = true),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.toByte(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.toByte(), input = 101.toByte(), valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.toByte(), input = (-101).toByte(), valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.toByte(), input = 100.toByte(), valid = true),

        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.toByte(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.toByte(), input = 1.toByte(), valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.toByte(), input = (-1).toByte(), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.toByte(), input = 0.toByte(), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.toByte(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.toByte(), input = 101.toByte(), valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.toByte(), input = (-101).toByte(), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.toByte(), input = 100.toByte(), valid = false),

        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.toByte(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.toByte(), input = 1.toByte(), valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.toByte(), input = (-1).toByte(), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.toByte(), input = 0.toByte(), valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.toByte(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.toByte(), input = 101.toByte(), valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.toByte(), input = (-101).toByte(), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.toByte(), input = 100.toByte(), valid = true),

        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.toByte(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.toByte(), input = 1.toByte(), valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.toByte(), input = (-1).toByte(), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.toByte(), input = 0.toByte(), valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.toByte(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.toByte(), input = 101.toByte(), valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.toByte(), input = (-101).toByte(), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.toByte(), input = 100.toByte(), valid = false),

        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.toByte(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.toByte(), input = 1.toByte(), valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.toByte(), input = (-1).toByte(), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.toByte(), input = 0.toByte(), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.toByte(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.toByte(), input = 101.toByte(), valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.toByte(), input = (-101).toByte(), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.toByte(), input = 100.toByte(), valid = true)
    )

    private val shortDataset = listOf<TestData<Short>>(
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.toShort(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.toShort(), input = 1.toShort(), valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.toShort(), input = (-1).toShort(), valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.toShort(), input = 0.toShort(), valid = true),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.toShort(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.toShort(), input = 101.toShort(), valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.toShort(), input = (-101).toShort(), valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.toShort(), input = 100.toShort(), valid = true),

        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.toShort(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.toShort(), input = 1.toShort(), valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.toShort(), input = (-1).toShort(), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.toShort(), input = 0.toShort(), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.toShort(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.toShort(), input = 101.toShort(), valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.toShort(), input = (-101).toShort(), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.toShort(), input = 100.toShort(), valid = false),

        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.toShort(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.toShort(), input = 1.toShort(), valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.toShort(), input = (-1).toShort(), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.toShort(), input = 0.toShort(), valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.toShort(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.toShort(), input = 101.toShort(), valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.toShort(), input = (-101).toShort(), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.toShort(), input = 100.toShort(), valid = true),

        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.toShort(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.toShort(), input = 1.toShort(), valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.toShort(), input = (-1).toShort(), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.toShort(), input = 0.toShort(), valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.toShort(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.toShort(), input = 101.toShort(), valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.toShort(), input = (-101).toShort(), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.toShort(), input = 100.toShort(), valid = false),

        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.toShort(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.toShort(), input = 1.toShort(), valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.toShort(), input = (-1).toShort(), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.toShort(), input = 0.toShort(), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.toShort(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.toShort(), input = 101.toShort(), valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.toShort(), input = (-101).toShort(), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.toShort(), input = 100.toShort(), valid = true)
    )

    private val intDataset = listOf<TestData<Int>>(
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0, input = 1, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0, input = (-1), valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0, input = 0, valid = true),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100, input = 101, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100, input = (-101), valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100, input = 100, valid = true),

        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0, input = 1, valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0, input = (-1), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0, input = 0, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100, input = 101, valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100, input = (-101), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100, input = 100, valid = false),

        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0, input = 1, valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0, input = (-1), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0, input = 0, valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100, input = 101, valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100, input = (-101), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100, input = 100, valid = true),

        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0, input = 1, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0, input = (-1), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0, input = 0, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100, input = 101, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100, input = (-101), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100, input = 100, valid = false),

        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0, input = 1, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0, input = (-1), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0, input = 0, valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100, input = 101, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100, input = (-101), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100, input = 100, valid = true)
    )

    private val longDataset = listOf<TestData<Long>>(
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.toLong(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.toLong(), input = 1.toLong(), valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.toLong(), input = (-1).toLong(), valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.toLong(), input = 0.toLong(), valid = true),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.toLong(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.toLong(), input = 101.toLong(), valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.toLong(), input = (-101).toLong(), valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.toLong(), input = 100.toLong(), valid = true),

        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.toLong(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.toLong(), input = 1.toLong(), valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.toLong(), input = (-1).toLong(), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.toLong(), input = 0.toLong(), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.toLong(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.toLong(), input = 101.toLong(), valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.toLong(), input = (-101).toLong(), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.toLong(), input = 100.toLong(), valid = false),

        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.toLong(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.toLong(), input = 1.toLong(), valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.toLong(), input = (-1).toLong(), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.toLong(), input = 0.toLong(), valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.toLong(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.toLong(), input = 101.toLong(), valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.toLong(), input = (-101).toLong(), valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.toLong(), input = 100.toLong(), valid = true),

        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.toLong(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.toLong(), input = 1.toLong(), valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.toLong(), input = (-1).toLong(), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.toLong(), input = 0.toLong(), valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.toLong(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.toLong(), input = 101.toLong(), valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.toLong(), input = (-101).toLong(), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.toLong(), input = 100.toLong(), valid = false),

        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.toLong(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.toLong(), input = 1.toLong(), valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.toLong(), input = (-1).toLong(), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.toLong(), input = 0.toLong(), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.toLong(), input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.toLong(), input = 101.toLong(), valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.toLong(), input = (-101).toLong(), valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.toLong(), input = 100.toLong(), valid = true)
    )
    
    private val floatDataset = listOf<TestData<Float>>(
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.0f, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.0f, input = 1.0f, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.0f, input = -1.0f, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.0f, input = 0.0f, valid = true),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.0f, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.0f, input = 101.0f, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.0f, input = -101.0f, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.0f, input = 100.0f, valid = true),

        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.0f, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.0f, input = 1.0f, valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.0f, input = -1.0f, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.0f, input = 0.0f, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.0f, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.0f, input = 101.0f, valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.0f, input = -101.0f, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.0f, input = 100.0f, valid = false),

        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.0f, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.0f, input = 1.0f, valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.0f, input = -1.0f, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.0f, input = 0.0f, valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.0f, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.0f, input = 101.0f, valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.0f, input = -101.0f, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.0f, input = 100.0f, valid = true),

        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.0f, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.0f, input = 1.0f, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.0f, input = -1.0f, valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.0f, input = 0.0f, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.0f, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.0f, input = 101.0f, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.0f, input = -101.0f, valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.0f, input = 100.0f, valid = false),

        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.0f, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.0f, input = 1.0f, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.0f, input = -1.0f, valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.0f, input = 0.0f, valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.0f, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.0f, input = 101.0f, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.0f, input = -101.0f, valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.0f, input = 100.0f, valid = true)
    )

    private val doubleDataset = listOf<TestData<Double>>(
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.0, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.0, input = 1.0, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.0, input = -1.0, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0.0, input = 0.0, valid = true),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.0, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.0, input = 101.0, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.0, input = -101.0, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 100.0, input = 100.0, valid = true),

        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.0, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.0, input = 1.0, valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.0, input = -1.0, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0.0, input = 0.0, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.0, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.0, input = 101.0, valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.0, input = -101.0, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 100.0, input = 100.0, valid = false),

        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.0, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.0, input = 1.0, valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.0, input = -1.0, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0.0, input = 0.0, valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.0, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.0, input = 101.0, valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.0, input = -101.0, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 100.0, input = 100.0, valid = true),

        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.0, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.0, input = 1.0, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.0, input = -1.0, valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0.0, input = 0.0, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.0, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.0, input = 101.0, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.0, input = -101.0, valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 100.0, input = 100.0, valid = false),

        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.0, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.0, input = 1.0, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.0, input = -1.0, valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0.0, input = 0.0, valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.0, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.0, input = 101.0, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.0, input = -101.0, valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 100.0, input = 100.0, valid = true)
    )

    @Test
    fun testPasses() {
        runTest(byteDataset)
        runTest(shortDataset)
        runTest(intDataset)
        runTest(longDataset)
        runTest(floatDataset)
        runTest(doubleDataset)
    }

    private fun <T> runTest(dataset: List<TestData<T>>) where T : Number, T : Comparable<T> {
        for (item in dataset) {
            val rule = NumberComparison(item.operator, item.params)
            assertEquals(item.valid, rule.passes("test", item.input), "Failed with case '$item'")
        }
    }
}