package net.ntworld.hexagon.foundation.internal

import net.ntworld.hexagon.foundation.validation.MessageBag
import net.ntworld.hexagon.foundation.validation.ValidationResult

data class ValidationResultImpl(override val isValid: Boolean, override val errors: MessageBag) : ValidationResult