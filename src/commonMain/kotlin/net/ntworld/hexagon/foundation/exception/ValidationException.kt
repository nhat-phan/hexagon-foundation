package net.ntworld.hexagon.foundation.exception

import net.ntworld.hexagon.foundation.MessageBag

class ValidationException(errors: MessageBag) : Exception() {
    val errors: MessageBag = errors
}