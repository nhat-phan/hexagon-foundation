package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.*
import net.ntworld.hexagon.foundation.validation.ComparisonOperatorEnum

internal class StringLength(
    private val operator: ComparisonOperatorEnum,
    private val value: Int
) : Rule<String> {
    override val message: String
        get() {
            return when (operator) {
                ComparisonOperatorEnum.EQUAL -> fillMessage(MESSAGE_STRING_LENGTH_EQUAL, value)
                ComparisonOperatorEnum.GREATER_THAN -> fillMessage(MESSAGE_STRING_LENGTH_GREATER_THAN, value)
                ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL -> fillMessage(MESSAGE_STRING_LENGTH_GREATER_THAN_OR_EQUAL, value)
                ComparisonOperatorEnum.LESS_THAN -> fillMessage(MESSAGE_STRING_LENGTH_LESS_THAN, value)
                ComparisonOperatorEnum.LESS_THAN_OR_EQUAL -> fillMessage(MESSAGE_STRING_LENGTH_LESS_THAN_OR_EQUAL, value)
            }
        }

    override fun passes(attribute: String, value: String?): Boolean {
        val length = if (null === value) 0 else value.length

        return when (operator) {
            ComparisonOperatorEnum.EQUAL -> length == this.value
            ComparisonOperatorEnum.GREATER_THAN -> length > this.value
            ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL -> length >= this.value
            ComparisonOperatorEnum.LESS_THAN -> length < this.value
            ComparisonOperatorEnum.LESS_THAN_OR_EQUAL -> length <= this.value
        }
    }

    private fun fillMessage(message: String, value: Int): String {
        return message.replace("{length}", value.toString())
    }
}