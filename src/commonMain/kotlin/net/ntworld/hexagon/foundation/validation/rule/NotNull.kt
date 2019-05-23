package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.Rule

internal class NotNull : Rule<Any> {
    override val message: String = ":attribute must be exist."

    override fun passes(attribute: String, value: Any?): Boolean {
        return null !== value
    }
}