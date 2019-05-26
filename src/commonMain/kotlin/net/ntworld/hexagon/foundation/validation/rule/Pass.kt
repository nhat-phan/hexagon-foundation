package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.MESSAGE_PASS
import net.ntworld.hexagon.foundation.validation.Rule

internal class Pass<T : Any>(private val fn: (T?) -> Boolean) : Rule<T> {
    override val message: String = MESSAGE_PASS

    override fun passes(attribute: String, value: T?): Boolean {
        return fn(value)
    }
}