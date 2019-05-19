package net.ntworld.hexagon.foundation.validation

import net.ntworld.hexagon.foundation.ValidationResult
import net.ntworld.hexagon.foundation.builder.Builder
import net.ntworld.hexagon.foundation.exception.ValidationException
import net.ntworld.hexagon.foundation.validation.rule.GreaterThan
import net.ntworld.hexagon.foundation.validation.rule.GreaterThanOrEqual
import net.ntworld.hexagon.foundation.validation.rule.NotEmpty
import net.ntworld.hexagon.foundation.validation.rule.Required

operator fun Rule.plus(rule: Rule): Rule {
    if (rule is RuleCollection) {
        rule.add(this)
        return rule
    }

    val collection = RuleCollection(this, null)
    collection.add(rule)
    return collection
}

fun Builder.validate(block: ValidatorBuilder.() -> Unit): ValidationResult {
    return Validator(block).validate(this.builderStorage)
}

fun Builder.assert(block: ValidatorBuilder.() -> Unit): Builder {
    val result = Validator(block).validate(this.builderStorage)
    if (!result.isValid) {
        throw ValidationException(result.errors)
    }
    return this
}

val ValidatorBuilder.required: Rule
    get() = Required()
val ValidatorBuilder.notEmpty: Rule
    get() = NotEmpty()

val ValidatorBuilder.gt: (value: Int) -> Rule
    get() = fun(value: Int): Rule { return GreaterThan(value) }

val ValidatorBuilder.greaterThan: (value: Int) -> Rule
    get() = fun(value: Int): Rule { return GreaterThan(value) }

val ValidatorBuilder.gte: (value: Int) -> Rule
    get() = fun(value: Int): Rule { return GreaterThanOrEqual(value) }

val ValidatorBuilder.greaterThanOrEqual: (value: Int) -> Rule
    get() = fun(value: Int): Rule { return GreaterThanOrEqual(value) }