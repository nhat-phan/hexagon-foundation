package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.Rule
import net.ntworld.hexagon.foundation.validation.warning

internal class NotEmpty: Rule {
    override val message: String = ":attribute must be not empty."

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
            else -> warning("Validation \"$RULE_NAME\" rule does not support type " + value::class.toString())
        }
        return true
    }

    companion object {
        const val RULE_NAME = "notEmpty"
    }
}