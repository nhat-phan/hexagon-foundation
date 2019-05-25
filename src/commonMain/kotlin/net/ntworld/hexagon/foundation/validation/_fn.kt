package net.ntworld.hexagon.foundation.validation

import net.ntworld.hexagon.foundation.ValidationResult
import net.ntworld.hexagon.foundation.exception.ValidationException
import net.ntworld.hexagon.foundation.validation.internal.RuleCollectionImpl
import net.ntworld.hexagon.foundation.validation.rule.Optional

infix fun <T : Any> Rule<T>.and(rule: Rule<T>): Rule<T> {
    if (this is RuleCollectionImpl<T>) {
        return this.addRule(rule)
    }

    if (rule is RuleCollectionImpl<T>) {
        return rule.addRule(this)
    }

    return RuleCollectionImpl<T>(Optional()).addRule(this).addRule(rule)
}

operator fun <T : Any> Rule<T>.plus(rule: Rule<T>): Rule<T> {
    return this.and(rule)
}

fun <T : Validatable> T.validatedBy(validator: Validator<T>): ValidationResult {
    return validator.validate(this)
}

fun <T : Validatable> T.validate(block: ValidatorBuilder<in T>.() -> Unit): ValidationResult {
    return Validator(block).validate(this)
}

fun <T : Validatable> T.assert(validator: Validator<T>): T {
    val result = validator.validate(this)
    if (!result.isValid) {
        throw ValidationException(result.errors)
    }
    return this
}

fun <T : Validatable> T.assert(block: ValidatorBuilder<T>.() -> Unit): T {
    val result = Validator(block).validate(this)
    if (!result.isValid) {
        throw ValidationException(result.errors)
    }
    return this
}