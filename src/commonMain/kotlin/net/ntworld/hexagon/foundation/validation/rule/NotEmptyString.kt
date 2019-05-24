package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.MESSAGE_NOT_EMPTY_STRING
import net.ntworld.hexagon.foundation.validation.Rule

internal class NotEmptyString : Rule<String> {
    override val message: String = MESSAGE_NOT_EMPTY_STRING

    override fun passes(attribute: String, value: String?): Boolean {
        return !value.isNullOrBlank()
    }
}