package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.*
import net.ntworld.hexagon.foundation.validation.internal.ComparisonOperatorEnum

internal class NumberComparison<T>(
    private val operator: ComparisonOperatorEnum,
    private val value: T
) : Rule<T> where T : Number, T : Comparable<T> {
    override val message: String
        get() {
            return when (operator) {
                ComparisonOperatorEnum.EQUAL -> fillMessage(MESSAGE_NUMBER_EQUAL, value)
                ComparisonOperatorEnum.GREATER_THAN -> fillMessage(MESSAGE_NUMBER_GREATER_THAN, value)
                ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL -> fillMessage(MESSAGE_NUMBER_GREATER_THAN_OR_EQUAL, value)
                ComparisonOperatorEnum.LESS_THAN -> fillMessage(MESSAGE_NUMBER_LESS_THAN, value)
                ComparisonOperatorEnum.LESS_THAN_OR_EQUAL -> fillMessage(MESSAGE_NUMBER_LESS_THAN_OR_EQUAL, value)
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

    private fun fillMessage(message: String, value: T): String {
        return message.replace("{value}", value.toString())
    }
}