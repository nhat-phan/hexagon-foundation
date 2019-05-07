package net.ntworld.hexagon.foundation

interface ArgumentValidator<in B: ArgumentBuilder> {
    fun validate(builder: B): ValidationResult
}