package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.internal.ValidationResultImpl
import net.ntworld.kotlin.validator.ValidationResult

class ArgumentValidatorCollection<B : ArgumentBuilder>(base: ArgumentValidator<B>) : ArgumentValidator<B> {
    private val validators: MutableList<ArgumentValidator<B>> = mutableListOf(base)

    override fun validate(builder: B): ValidationResult {
        if (validators.isEmpty()) {
            throw UnsupportedOperationException("Empty validator collection can't be validate.")
        }

        val results = validators.map { it.validate(builder) }
        val iterator = results.iterator()

        val first = iterator.next()
        val accumulator = ValidationResultImpl(first.errors, first.isValid)

        while (iterator.hasNext()) {
            val next = iterator.next()
            accumulator.isValid = accumulator.isValid && next.isValid
            accumulator.errors += next.errors
        }
        return accumulator
    }

    fun add(validator: ArgumentValidator<B>) {
        validators.add(validator)
    }

    operator fun plus(validator: ArgumentValidator<B>): ArgumentValidator<B> {
        add(validator)

        return this
    }
}