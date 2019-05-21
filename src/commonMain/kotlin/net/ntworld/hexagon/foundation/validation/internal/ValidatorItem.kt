package net.ntworld.hexagon.foundation.validation.internal

import net.ntworld.hexagon.foundation.validation.RuleCollection
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

internal data class ValidatorItem<T>(
    val property0: KProperty0<*>?,
    val property1: KProperty1<T, *>?,
    val rules: RuleCollection
)