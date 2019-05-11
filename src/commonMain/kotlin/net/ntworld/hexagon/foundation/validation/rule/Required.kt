package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.Rule

internal class Required : Rule {
    override val message: String = ":attribute is required."

    override fun passes(attribute: String, value: Any?): Boolean {
        when (value) {
            null -> return false
            is String -> return value.isNotEmpty()
            is Collection<*> -> return value.isNotEmpty()
            is Array<*> -> return value.isNotEmpty()
        }
        return true
    }
}