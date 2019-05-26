package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.*
import net.ntworld.hexagon.foundation.validation.ComparisonOperatorEnum

class ArraySize<T : Any>(
    private val operator: ComparisonOperatorEnum,
    private val value: Int
) : Rule<T> {
    override val message: String
        get() {
            return when (operator) {
                ComparisonOperatorEnum.EQUAL -> fillMessage(MESSAGE_ARRAY_SIZE_EQUAL, value)
                ComparisonOperatorEnum.GREATER_THAN -> fillMessage(MESSAGE_ARRAY_SIZE_GREATER_THAN, value)
                ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL -> fillMessage(MESSAGE_ARRAY_SIZE_GREATER_THAN_OR_EQUAL, value)
                ComparisonOperatorEnum.LESS_THAN -> fillMessage(MESSAGE_ARRAY_SIZE_LESS_THAN, value)
                ComparisonOperatorEnum.LESS_THAN_OR_EQUAL -> fillMessage(MESSAGE_ARRAY_SIZE_LESS_THAN_OR_EQUAL, value)
            }
        }

    override fun passes(attribute: String, value: T?): Boolean {
        return when (value) {
            null -> runPasses(0)
            is String -> runPasses(value.length)
            is Collection<*> -> runPasses(value.size)
            is Map<*, *> -> runPasses(value.size)
            is Array<*> -> runPasses(value.size)
            is BooleanArray -> runPasses(value.size)
            is ByteArray -> runPasses(value.size)
            is ShortArray -> runPasses(value.size)
            is IntArray -> runPasses(value.size)
            is LongArray -> runPasses(value.size)
            is FloatArray -> runPasses(value.size)
            is DoubleArray -> runPasses(value.size)
            is CharArray -> runPasses(value.size)
            else -> true
        }
    }

    private fun runPasses(size: Int): Boolean {
        return when (operator) {
            ComparisonOperatorEnum.EQUAL -> size == this.value
            ComparisonOperatorEnum.GREATER_THAN -> size > this.value
            ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL -> size >= this.value
            ComparisonOperatorEnum.LESS_THAN -> size < this.value
            ComparisonOperatorEnum.LESS_THAN_OR_EQUAL -> size <= this.value
        }
    }

    private fun fillMessage(message: String, value: Int): String {
        return message.replace("{size}", value.toString())
    }

    companion object {
        inline fun <reified T : Any> eq(value: Int): Rule<T> {
            return ArraySize(ComparisonOperatorEnum.EQUAL, value)
        }

        inline fun <reified T : Any> gt(value: Int): Rule<T> {
            return ArraySize(ComparisonOperatorEnum.GREATER_THAN, value)
        }

        inline fun <reified T : Any> gte(value: Int): Rule<T> {
            return ArraySize(ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, value)
        }

        inline fun <reified T : Any> lt(value: Int): Rule<T> {
            return ArraySize(ComparisonOperatorEnum.LESS_THAN, value)
        }

        inline fun <reified T : Any> lte(value: Int): Rule<T> {
            return ArraySize(ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, value)
        }
    }
}