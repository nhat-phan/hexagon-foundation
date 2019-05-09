package net.ntworld.hexagon.foundation.internal

import net.ntworld.hexagon.foundation.MessageBag
import net.ntworld.hexagon.foundation.ValidationResult

data class ValidationResultImpl(override val isValid: Boolean, override val errors: MessageBag) : ValidationResult