package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.MESSAGE_NOT_NULL
import net.ntworld.hexagon.foundation.validation.Rule

internal class NotNull : Rule<Any> {
    override val message: String = MESSAGE_NOT_NULL

    override fun passes(attribute: String, value: Any?): Boolean {
        return null !== value
    }
}