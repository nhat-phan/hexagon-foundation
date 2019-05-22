package net.ntworld.hexagon.foundation.validation.internal

import net.ntworld.hexagon.foundation.validation.Rule
import net.ntworld.hexagon.foundation.validation.RuleCollection
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

internal class ValidatorBuilderImpl<T : Any> {
    // KProperty0 ----------------------------------------------------
    operator fun <R : Any> KProperty0<R>.invoke(block: RuleCollection<R>.() -> Rule<R>) {
        TODO()
    }

    infix fun <R : Any> KProperty0<R>.required(block: RuleCollection<R>.() -> Rule<R>): RuleCollection<T> {
        TODO()
    }

    infix fun <R : Any> KProperty0<R>.required(rule: Rule<R>): RuleCollection<R> {
        TODO()
    }

    infix fun <R : Any> KProperty0<R>.always(rule: Rule<Any>): RuleCollection<R> {
        TODO()
    }

    // KProperty1 ----------------------------------------------------

    operator fun <R : Any> KProperty1<T, R>.invoke(block: RuleCollection<R>.() -> Rule<R>) {
        TODO()
    }

    infix fun <R : Any> KProperty1<T, R>.required(block: RuleCollection<R>.() -> Rule<R>): RuleCollection<T> {
        TODO()
    }

    infix fun <R : Any> KProperty1<T, R>.required(rule: Rule<R>): RuleCollection<R> {
        TODO()
    }

    infix fun <R : Any> KProperty1<T, R>.always(rule: Rule<Any>): RuleCollection<R> {
        TODO()
    }

    // Builtin rules -------------------------------------------------

    val exists: Rule<Any>
        get() {
            TODO()
        }

    val required: Rule<Any>
        get() {
            TODO()
        }

    val notEmptyString: Rule<String>
        get() {
            TODO()
        }

    fun gt(value: String): RuleCollection<String> {
        TODO()
    }

    fun <V : Number> gt(value: Number): RuleCollection<V> {
        TODO()
    }

    fun <V : Number> lt(): RuleCollection<V> {
        TODO()
    }

    fun email(): RuleCollection<String> {
        TODO()
    }
}

