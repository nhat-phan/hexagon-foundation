package net.ntworld.hexagon.foundation.old_validation.rule

import net.ntworld.hexagon.foundation.old_validation.Rule

class GreaterThanOrEqual(private val min: Int) : Rule {
    override val message: String = ":attribute must be greater than or equal :value."

    override fun passes(attribute: String, value: Any?): Boolean {
        when (value) {
            null -> return false
            is String -> return value.length >= min
            is Collection<*> -> return value.size >= min
            is Array<*> -> return value.size >= min
            is Byte -> return value >= min
            is Short -> return value >= min
            is Int -> return value >= min
            is Long -> return value >= min
            is Float -> return value >= 0
            is Double -> return value >= 0
        }
        return true
    }

}