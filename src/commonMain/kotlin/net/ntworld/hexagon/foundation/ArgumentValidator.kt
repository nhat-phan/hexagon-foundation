package net.ntworld.hexagon.foundation

interface ArgumentValidator {
    fun validate(data: ArgumentBuilderData): ValidationResult
}