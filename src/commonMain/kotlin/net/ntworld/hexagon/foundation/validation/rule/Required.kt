package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.MESSAGE_REQUIRED
import net.ntworld.hexagon.foundation.validation.Rule

internal class Required : Rule<Any> {
    override val message: String = MESSAGE_REQUIRED

    override fun passes(attribute: String, value: Any?): Boolean {
        when (value) {
            null -> return false
            is String -> return value.isNotEmpty()
            is Collection<*> -> return value.isNotEmpty()
            is Map<*, *> -> return value.isNotEmpty()
            is Array<*> -> return value.isNotEmpty()
            is BooleanArray -> return value.isNotEmpty()
            is ByteArray -> return value.isNotEmpty()
            is ShortArray -> return value.isNotEmpty()
            is IntArray -> return value.isNotEmpty()
            is LongArray -> return value.isNotEmpty()
            is FloatArray -> return value.isNotEmpty()
            is DoubleArray -> return value.isNotEmpty()
            is CharArray -> return value.isNotEmpty()
        }
        return true
    }
}