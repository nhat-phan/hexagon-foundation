package net.ntworld.hexagon.foundation.validation.internal

import net.ntworld.hexagon.foundation.validation.Rule
import net.ntworld.hexagon.foundation.validation.RuleBuilder
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

    override fun <R : Any> KProperty0<R>.always(rule: Rule<Any>): RuleBuilder<R> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <R : Any> KProperty1<T, R>.always(rule: Rule<Any>): RuleBuilder<R> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}