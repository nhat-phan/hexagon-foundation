package net.ntworld.hexagon.foundation.validation

import net.ntworld.hexagon.foundation.validation.internal.RuleFactory
import net.ntworld.hexagon.foundation.validation.rule.*
import net.ntworld.hexagon.foundation.validation.rule.NumberComparison
import net.ntworld.hexagon.foundation.validation.rule.Optional
import net.ntworld.hexagon.foundation.validation.rule.Required
import net.ntworld.hexagon.foundation.validation.rule.StringLength
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

@ValidatorDsl
interface ValidatorBuilder<T : Any> {
    // Builder feature ----------------------------------------------------
    @ValidatorDsl
    infix fun extend(validator: Validator<in T>): ValidatorBuilder<T>

    @ValidatorDsl
    infix fun use(validator: Validator<T>): ValidatorBuilder<T> = extend(validator)

    @ValidatorDsl
    infix fun run(validator: Validator<T>): ValidatorBuilder<T> = extend(validator)

    // stopAtFirstError() -> not implemented yet.

    // KProperty0 ----------------------------------------------------
    @ValidatorDsl
    infix fun <R : Any> KProperty0<R?>.always(rule: Rule<Any>): RuleBuilder<R>

    @ValidatorDsl
    operator fun <R : Any> KProperty0<R?>.invoke(block: RuleBuilder<R>.() -> Unit) {
        this.always(Optional()).apply(block)
    }

    @ValidatorDsl
    infix fun <R : Any> KProperty0<R?>.required(block: RuleBuilder<R>.() -> Unit): RuleBuilder<R> {
        return this.always(Required()).apply(block)
    }

    @ValidatorDsl
    infix fun <R : Any> KProperty0<R?>.required(rule: Rule<R>): RuleBuilder<R> {
        return this.always(Required()).and(rule)
    }

    @ValidatorDsl
    infix fun <E : Any, R : Collection<E>> KProperty0<R?>.each(rule: Rule<E>): RuleBuilder<R> {
        return this.always(Optional()).and(Each(rule))
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

    @ValidatorDsl
    infix fun <E : Any, R : Collection<E>> KProperty1<T, R?>.each(rule: Rule<E>): RuleBuilder<R> {
        return this.always(Optional()).and(Each(rule))
    }

    // Builtin rules -------------------------------------------------

    @SystemRuleDsl
    val exists: Rule<Any>
        get() = RuleFactory.notNull

    @SystemRuleDsl
    val required: Rule<Any>
        get() = RuleFactory.required

    @SystemRuleDsl
    val notNull: Rule<Any>
        get() = RuleFactory.notNull

    @SystemRuleDsl
    val notEmptyString: Rule<String>
        get() = RuleFactory.notEmptyString

    @SystemRuleDsl
    infix fun <V : Any> pass(fn: (V?) -> Boolean): Rule<V> = Pass(fn)

    @SystemRuleDsl
    infix fun <V : Any> passes(fn: (V?) -> Boolean): Rule<V> = pass(fn)

    @SystemRuleDsl
    fun <V> eq(value: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(ComparisonOperatorEnum.EQUAL, value)

    @SystemRuleDsl
    fun <V> equal(value: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(ComparisonOperatorEnum.EQUAL, value)

    @SystemRuleDsl
    fun <V> gt(min: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(ComparisonOperatorEnum.GREATER_THAN, min)

    @SystemRuleDsl
    fun <V> greaterThan(min: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(ComparisonOperatorEnum.GREATER_THAN, min)

    @SystemRuleDsl
    fun <V> gte(min: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, min)

    @SystemRuleDsl
    fun <V> greaterThanOrEqual(min: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, min)

    @SystemRuleDsl
    fun <V> lt(max: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(ComparisonOperatorEnum.LESS_THAN, max)

    @SystemRuleDsl
    fun <V> lessThan(max: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(ComparisonOperatorEnum.LESS_THAN, max)

    @SystemRuleDsl
    fun <V> lte(max: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, max)

    @SystemRuleDsl
    fun <V> lessThanOrEqual(max: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, max)

    @SystemRuleDsl
    fun minLength(value: Int): Rule<String> = StringLength(ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL, value)

    @SystemRuleDsl
    fun maxLength(value: Int): Rule<String> = StringLength(ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, value)

    @SystemRuleDsl
    fun exactLength(value: Int): Rule<String> = StringLength(ComparisonOperatorEnum.LESS_THAN_OR_EQUAL, value)

    @SystemRuleDsl
    fun <V : CharSequence> passRegex(pattern: String): Rule<V> = PassRegex(kotlin.text.Regex(pattern))

    @SystemRuleDsl
    fun <V : CharSequence> passRegex(pattern: String, option: RegexOption): Rule<V> = PassRegex(Regex(pattern, option))

    @SystemRuleDsl
    fun <V : CharSequence> passRegex(pattern: String, option: Set<RegexOption>): Rule<V> =
        PassRegex(Regex(pattern, option))

    @SystemRuleDsl
    fun <V : CharSequence> matches(pattern: String): Rule<V> = passRegex(pattern)

    @SystemRuleDsl
    fun <V : CharSequence> matches(pattern: String, option: RegexOption): Rule<V> = passRegex(pattern, option)

    @SystemRuleDsl
    fun <V : CharSequence> matches(pattern: String, option: Set<RegexOption>): Rule<V> = passRegex(pattern, option)

    @SystemRuleDsl
    infix fun <E : Any, V : Collection<E>> each(rule: Rule<E>): Rule<V> = Each(rule)

}

