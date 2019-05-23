package net.ntworld.hexagon.foundation.validation.internal

import net.ntworld.hexagon.foundation.validation.rule.NotEmptyString
import net.ntworld.hexagon.foundation.validation.rule.NotNull
import net.ntworld.hexagon.foundation.validation.rule.Required

internal object RuleFactory {
    val notNull = NotNull()

    val required = Required()

    val notEmptyString = NotEmptyString()
}