package net.ntworld.hexagon.foundation.validation

import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

class ValidatorBuilder<T>(private val validator: Validator<T>) {
    // KProperty0 ---------------------------------------------------
    private fun registerProperty(property: KProperty0<*>, builder: RuleBuilder): RuleBuilder {
        val rules = builder.getRuleCollection()
        if (null !== rules) {
            validator.registerProperty(property, rules)
        }
        return builder
    }

    operator fun KProperty0<*>.invoke(block: RuleBuilder.() -> Unit) {
        registerProperty(this, RuleBuilder().apply(block))
    }

    infix fun KProperty0<*>.always(rule: Rule): RuleBuilder {
        val builder = RuleBuilder()
        builder.rule = rule

        return registerProperty(this, builder)
    }

    infix fun KProperty0<*>.must(rule: Rule) = always(rule)
    infix fun KProperty0<*>.mustBe(rule: Rule) = always(rule)

    // KProperty1 ---------------------------------------------------

    private fun registerProperty(property: KProperty1<T, *>, builder: RuleBuilder): RuleBuilder {
        val rules = builder.getRuleCollection()
        if (null !== rules) {
            validator.registerProperty(property, rules)
        }
        return builder
    }

    operator fun KProperty1<T, *>.invoke(block: RuleBuilder.() -> Unit) {
        registerProperty(this, RuleBuilder().apply(block))
    }

    infix fun KProperty1<T, *>.always(rule: Rule): RuleBuilder {
        val builder = RuleBuilder()
        builder.rule = rule

        return registerProperty(this, builder)
    }

    infix fun KProperty1<T, *>.must(rule: Rule) = always(rule)
    infix fun KProperty1<T, *>.mustBe(rule: Rule) = always(rule)

}
