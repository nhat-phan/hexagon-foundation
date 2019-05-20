package net.ntworld.hexagon.foundation.builder.internal

import net.ntworld.hexagon.foundation.builder.Builder
import kotlin.reflect.KProperty

internal class IterableProperty<E : Any, T : Any>(
    private val options: IterablePropertyOptionsImpl<E, T>,
    private val filterFn: (T, (E) -> Boolean) -> T,
    private val mapFn: (T, (E) -> E) -> T
) : GenericProperty<T>(options) {
    override fun getValue(builder: Builder, property: KProperty<*>): T {
        var result = super.getValue(builder, property)
        val map = options.propertyMap
        if (null !== map) {
            result = mapFn(result, map)
        }

        val filter = options.propertyFilter
        if (null !== filter) {
            result = filterFn(result, filter)
        }

        val sanitizer = options.propertySanitizer
        if (null !== sanitizer) {
            return sanitizer(result)
        }
        return result
    }
}