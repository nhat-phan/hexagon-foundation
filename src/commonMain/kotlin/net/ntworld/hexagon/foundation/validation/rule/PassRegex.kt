package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.MESSAGE_REGEX
import net.ntworld.hexagon.foundation.validation.Rule
import kotlin.text.Regex

internal class PassRegex<T : CharSequence>(private val regex: Regex) : Rule<T> {
    override val message: String = MESSAGE_REGEX

    override fun passes(attribute: String, value: T?): Boolean {
        if (value !== null) {
            return regex.matches(value)
        }
        return false
    }
}