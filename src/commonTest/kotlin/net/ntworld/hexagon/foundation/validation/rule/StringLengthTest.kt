package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.ComparisonOperatorEnum
import kotlin.test.Test
import kotlin.test.assertEquals

class StringLengthTest {
    internal data class TestData(
        val operator: ComparisonOperatorEnum,
        val params: Int,
        val input: String?,
        val valid: Boolean
    )

    private val dataset = listOf(
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0, input = null, valid = true),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0, input = "", valid = true),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0, input = " ", valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0, input = " a ", valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 0, input = "abcdef", valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 3, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 3, input = "", valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 3, input = " ", valid = false),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 3, input = " a ", valid = true),
        TestData(operator = ComparisonOperatorEnum.EQUAL, params = 3, input = "abcdef", valid = false),

        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0, input = "", valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0, input = " ", valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0, input = " a ", valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 0, input = "abcdef", valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 3, input = null, valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 3, input = "", valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 3, input = " ", valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 3, input = " a ", valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN, params = 3, input = "abcdef", valid = false),

        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0, input = null, valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0, input = "", valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0, input = " ", valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0, input = " a ", valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 0, input = "abcdef", valid = false),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 3, input = null, valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 3, input = "", valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 3, input = " ", valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 3, input = " a ", valid = true),
        TestData(operator = ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, params = 3, input = "abcdef", valid = false),

        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0, input = "", valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0, input = " ", valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0, input = " a ", valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 0, input = "abcdef", valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 3, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 3, input = "", valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 3, input = " ", valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 3, input = " a ", valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN, params = 3, input = "abcdef", valid = true),

        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0, input = null, valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0, input = "", valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0, input = " ", valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0, input = " a ", valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 0, input = "abcdef", valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 3, input = null, valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 3, input = "", valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 3, input = " ", valid = false),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 3, input = " a ", valid = true),
        TestData(operator = ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, params = 3, input = "abcdef", valid = true)
    )

    @Test
    fun testPasses() {
        for (item in dataset) {
            val rule = StringLength(item.operator, item.params)
            assertEquals(item.valid, rule.passes("test", item.input), "Failed with case '$item'")
        }
    }
}