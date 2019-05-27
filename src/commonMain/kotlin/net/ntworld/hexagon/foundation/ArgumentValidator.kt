package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.validation.ValidationResult

interface ArgumentValidator<in B: ArgumentBuilder> {
    fun validate(builder: B): ValidationResult
}