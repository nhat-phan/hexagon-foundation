package net.ntworld.hexagon.foundation.validation.rule

import net.ntworld.hexagon.foundation.validation.MESSAGE_EACH
import net.ntworld.hexagon.foundation.validation.Rule

internal class Each<E : Any, T : Collection<E?>>(private val rule: Rule<E>) : Rule<T> {
    override val message: String = MESSAGE_EACH

    override fun passes(attribute: String, value: T?): Boolean {
        if (null !== value) {
            return value.fold(true) { acc, item ->
                return acc && rule.passes(attribute, item)
            }
        }
        return true
    }

}