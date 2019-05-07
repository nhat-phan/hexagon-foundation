package net.ntworld.hexagon.foundation

interface ValidationResult {
    val isValid: Boolean

    val errors: MessageBag
}