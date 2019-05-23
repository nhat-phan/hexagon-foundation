package net.ntworld.hexagon.foundation.validation.internal

import net.ntworld.hexagon.foundation.validation.Rule
import net.ntworld.hexagon.foundation.validation.RuleBuilder
import net.ntworld.hexagon.foundation.validation.Validator
import net.ntworld.hexagon.foundation.validation.ValidatorBuilder
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

internal class ValidatorBuilderImpl<T : Any>(private val validator: Validator<T>) : ValidatorBuilder<T> {
    override fun <R : Any> KProperty0<R?>.always(rule: Rule<Any>): RuleBuilder<R> {
        val builder = RuleBuilderImpl<R>(rule)
        validator.registerProperty(this, builder.ruleCollection)
        return builder
    }

    override fun <R : Any> KProperty1<T, R?>.always(rule: Rule<Any>): RuleBuilder<R> {
        val builder = RuleBuilderImpl<R>(rule)
        validator.registerProperty(this, builder.ruleCollection)
        return builder
    }
}


