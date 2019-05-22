package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.Rule

internal class Optional : Rule<Any> {
    override val message: String = ""

    override fun passes(attribute: String, value: Any?): Boolean {
        return true
    }
}