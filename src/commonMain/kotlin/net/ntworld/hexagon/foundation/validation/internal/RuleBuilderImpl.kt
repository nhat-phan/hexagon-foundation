package net.ntworld.hexagon.foundation.validation.internal

import net.ntworld.hexagon.foundation.validation.Rule
import net.ntworld.hexagon.foundation.validation.RuleBuilder
import net.ntworld.hexagon.foundation.validation.Validator
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

class RuleBuilderImpl<T : Any>(started: Rule<Any>) : RuleBuilder<T> {
    internal val ruleCollection = RuleCollectionImpl<T>(started)

    override var rule: Rule<T>
        get() = ruleCollection
        set(value) {
            ruleCollection.addRule(value)
        }

    override var message: String
        get() = ruleCollection.message
        set(value) {
            ruleCollection.customMessage = value
        }

    override fun and(rule: Rule<T>): RuleBuilder<T> {
        ruleCollection.addRule(rule)

        return this
    }

    override fun customMessage(message: String) {
        this.message = message
    }

    override fun <R : Any> KProperty0<R?>.always(rule: Rule<Any>): RuleBuilder<R> {
        val validator = Validator<T> {}
        val builder = RuleBuilderImpl<R>(rule)
        validator.registerProperty(this, builder.ruleCollection)
        this@RuleBuilderImpl.ruleCollection.addRule(validator)

        return builder
    }

    override fun <R : Any> KProperty1<T, R?>.always(rule: Rule<Any>): RuleBuilder<R> {
        val validator = Validator<T> {}
        val builder = RuleBuilderImpl<R>(rule)
        validator.registerProperty(this, builder.ruleCollection)
        this@RuleBuilderImpl.ruleCollection.addRule(validator)

        return builder
    }
}