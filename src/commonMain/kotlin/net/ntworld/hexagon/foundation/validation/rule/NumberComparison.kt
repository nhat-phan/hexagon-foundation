package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.Rule
import net.ntworld.hexagon.foundation.validation.internal.ComparisonOperatorEnum

internal class NumberComparison<T>(
    private val operator: ComparisonOperatorEnum,
    private val value: T
) : Rule<T> where T : Number, T : Comparable<T> {
    override val message: String
        get() {
            return when (operator) {
                ComparisonOperatorEnum.EQUAL -> ":attribute must be equal :value"
                ComparisonOperatorEnum.GREATER_THAN -> ":attribute must be greater than :value"
                ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL -> ":attribute must be greater than or equal :value"
                ComparisonOperatorEnum.LESS_THAN -> ":attribute must be less than :value"
                ComparisonOperatorEnum.LESS_THAN_OR_EQUAL -> ":attribute must be less than or equal :value"
            }
        }

    override fun passes(attribute: String, value: T?): Boolean {
        if (null !== value) {
            return when (operator) {
                ComparisonOperatorEnum.EQUAL -> value == this.value
                ComparisonOperatorEnum.GREATER_THAN -> value > this.value
                ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL -> value >= this.value
                ComparisonOperatorEnum.LESS_THAN -> value < this.value
                ComparisonOperatorEnum.LESS_THAN_OR_EQUAL -> value <= this.value
            }
        }
        return false
    }
}