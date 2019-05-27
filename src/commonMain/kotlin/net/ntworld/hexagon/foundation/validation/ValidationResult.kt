package net.ntworld.hexagon.foundation.validation

interface ValidationResult {
    val isValid: Boolean

    val errors: MessageBag
}