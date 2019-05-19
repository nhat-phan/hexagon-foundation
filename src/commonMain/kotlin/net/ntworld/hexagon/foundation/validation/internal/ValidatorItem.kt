package net.ntworld.hexagon.foundation.validation.internal

import net.ntworld.hexagon.foundation.validation.RuleCollection
import kotlin.reflect.KProperty0

internal data class ValidatorItem(
    val property: KProperty0<*>,
    val rules: RuleCollection
)