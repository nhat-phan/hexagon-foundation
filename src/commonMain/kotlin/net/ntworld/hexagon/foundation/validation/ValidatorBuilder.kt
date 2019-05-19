package net.ntworld.hexagon.foundation.validation

import kotlin.reflect.KProperty0

class ValidatorBuilder(private val validator: Validator) {
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

    infix fun KProperty0<*>.must(rule: Rule): RuleBuilder {
        return always(rule)
    }

    infix fun KProperty0<*>.mustBe(rule: Rule): RuleBuilder {
        return always(rule)
    }
}
