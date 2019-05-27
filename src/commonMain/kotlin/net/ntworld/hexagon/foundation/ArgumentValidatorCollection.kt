package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.internal.MessageBagImpl
import net.ntworld.hexagon.foundation.internal.ValidationResultImpl
import net.ntworld.hexagon.foundation.validation.ValidationResult

class ArgumentValidatorCollection<B : ArgumentBuilder>(base: ArgumentValidator<B>) : ArgumentValidator<B> {
    private val validators: MutableList<ArgumentValidator<B>> = mutableListOf(base)

    override fun validate(builder: B): ValidationResult {
        val errors = MessageBagImpl()
        val isValid = validators
            .map { it.validate(builder) }
            .fold(true) { acc, result ->
                if (result.isValid) {
                    return@fold acc
                }

                errors += result.errors
                return@fold false
            }

        return ValidationResultImpl(isValid, errors)
    }

    fun add(validator: ArgumentValidator<B>) {
        validators.add(validator)
    }

    operator fun plus(validator: ArgumentValidator<B>): ArgumentValidator<B> {
        add(validator)

        return this
    }
}