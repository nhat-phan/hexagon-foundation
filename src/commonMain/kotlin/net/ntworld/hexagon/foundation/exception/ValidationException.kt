package net.ntworld.hexagon.foundation.exception

import net.ntworld.hexagon.foundation.validation.MessageBag

class ValidationException(val errors: MessageBag) : Exception()