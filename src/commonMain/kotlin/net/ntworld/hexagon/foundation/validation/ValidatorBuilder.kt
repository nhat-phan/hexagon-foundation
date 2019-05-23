package net.ntworld.hexagon.foundation.validation

import net.ntworld.hexagon.foundation.validation.rule.NotEmptyString
import net.ntworld.hexagon.foundation.validation.rule.Optional
import net.ntworld.hexagon.foundation.validation.rule.Required
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

@ValidatorDsl
interface ValidatorBuilder<T : Any> {
    // KProperty0 ----------------------------------------------------
    infix fun <R : Any> KProperty0<R?>.always(rule: Rule<Any>): RuleBuilder<R>

    operator fun <R : Any> KProperty0<R?>.invoke(block: RuleBuilder<R>.() -> Unit) {
        this.always(Optional()).apply(block)
    }

    infix fun <R : Any> KProperty0<R?>.required(block: RuleBuilder<R>.() -> Unit): RuleBuilder<R> {
        return this.always(Required()).apply(block)
    }

    infix fun <R : Any> KProperty0<R?>.required(rule: Rule<R>): RuleBuilder<R> {
        return this.always(Required()).and(rule)
    }

    // KProperty1 ----------------------------------------------------
    @ValidatorDsl
    infix fun <R : Any> KProperty1<T, R?>.always(rule: Rule<Any>): RuleBuilder<R>

    @ValidatorDsl
    operator fun <R : Any> KProperty1<T, R?>.invoke(block: RuleBuilder<R>.() -> Unit) {
        this.always(Optional()).apply(block)
    }

    @ValidatorDsl
    infix fun <R : Any> KProperty1<T, R?>.required(block: RuleBuilder<R>.() -> Unit): RuleBuilder<R> {
        return this.always(Required()).apply(block)
    }

    @ValidatorDsl
    infix fun <R : Any> KProperty1<T, R?>.required(rule: Rule<R>): RuleBuilder<R> {
        return this.always(Required()).and(rule)
    }

    // Builtin rules -------------------------------------------------

    @SystemRuleDsl
    val exists: Rule<Any>
        get() {
            TODO()
        }

    @SystemRuleDsl
    val required: Rule<Any>
        get() = Required()

    @SystemRuleDsl
    val notEmptyString: Rule<String>
        get() = NotEmptyString()

    @SystemRuleDsl
    fun gt(value: String): Rule<String> {
        TODO()
    }

    @SystemRuleDsl
    fun <V : Number> gt(min: Number): Rule<V> {
        TODO()
    }

    @SystemRuleDsl
    fun <V : Number> lt(): Rule<V> {
        TODO()
    }

    @SystemRuleDsl
    fun email(): Rule<String> {
        TODO()
    }
}