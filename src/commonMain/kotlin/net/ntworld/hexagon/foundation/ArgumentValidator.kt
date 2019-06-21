package net.ntworld.hexagon.foundation

import net.ntworld.kotlin.validator.ValidationResult

interface ArgumentValidator<in B: ArgumentBuilder> {
    fun validate(builder: B): ValidationResult
}