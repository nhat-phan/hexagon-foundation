package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.Rule

internal class NotEmptyString : Rule<String> {
    override val message: String = ":attribute is required and not empty."

    override fun passes(attribute: String, value: String?): Boolean {
        return !value.isNullOrBlank()
    }
}