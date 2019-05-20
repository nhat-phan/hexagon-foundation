package net.ntworld.hexagon.foundation.builder

interface GenericPropertyOptions<T : Any> {
    var default: T

    val hasDefaultValue: Boolean
}