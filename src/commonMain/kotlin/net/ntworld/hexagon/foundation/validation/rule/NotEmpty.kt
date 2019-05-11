package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.Rule

internal class NotEmpty: Rule {
    override val message: String = ":attribute must be not empty."

    override fun passes(attribute: String, value: Any?): Boolean {
        when (value) {
            null -> return false
            is String -> return value.isNotEmpty()
            is Collection<*> -> return value.isNotEmpty()
            is Array<*> -> return value.isNotEmpty()
            is Byte -> return value > 0
            is Short -> return value > 0
            is Int -> return value > 0
            is Long -> return value > 0
            is Float -> return value > 0
            is Double -> return value > 0
            is Boolean -> return value
        }
        return true
    }

}