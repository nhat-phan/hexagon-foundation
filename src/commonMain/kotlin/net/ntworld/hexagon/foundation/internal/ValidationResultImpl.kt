package net.ntworld.hexagon.foundation.internal

import net.ntworld.kotlin.validator.MessageBag
import net.ntworld.kotlin.validator.ValidationResult

internal class ValidationResultImpl(override val errors: MessageBag, override var isValid: Boolean) : ValidationResult