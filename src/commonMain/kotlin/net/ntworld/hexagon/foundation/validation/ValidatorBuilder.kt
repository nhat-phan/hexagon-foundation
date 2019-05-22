package net.ntworld.hexagon.foundation.validation

import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

interface ValidatorBuilder<T : Any> {
    // KProperty0 ----------------------------------------------------
    operator fun <R : Any> KProperty0<R>.invoke(block: RuleCollection<R>.() -> Rule<R>)

    infix fun <R : Any> KProperty0<R>.required(block: RuleCollection<R>.() -> Rule<R>): RuleCollection<T>

    infix fun <R : Any> KProperty0<R>.required(rule: Rule<R>): RuleCollection<R>

    infix fun <R : Any> KProperty0<R>.always(rule: Rule<Any>): RuleCollection<R>

    // KProperty1 ----------------------------------------------------

    operator fun <R : Any> KProperty1<T, R>.invoke(block: RuleCollection<R>.() -> Rule<R>)

    infix fun <R : Any> KProperty1<T, R>.required(block: RuleCollection<R>.() -> Rule<R>): RuleCollection<T>

    infix fun <R : Any> KProperty1<T, R>.required(rule: Rule<R>): RuleCollection<R>

    infix fun <R : Any> KProperty1<T, R>.always(rule: Rule<Any>): RuleCollection<R>

    // Builtin rules -------------------------------------------------

    val exists: Rule<Any>
    val required: Rule<Any>
    val notEmptyString: Rule<String>
    fun gt(value: String): RuleCollection<String>
    fun <V : Number> gt(value: Number): RuleCollection<V>
    fun <V : Number> lt(): RuleCollection<V>
    fun email(): RuleCollection<String>
}