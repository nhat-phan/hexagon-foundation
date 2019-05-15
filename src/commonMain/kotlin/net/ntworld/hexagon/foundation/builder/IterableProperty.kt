package net.ntworld.hexagon.foundation.builder

import kotlin.reflect.KProperty

class IterableProperty<E : Any, T : Any>(
    private val options: IterablePropertyOptions<E, T>,
    private val filterFn: (T, (E) -> Boolean) -> T,
    private val mapFn: (T, (E) -> E) -> T
) : GenericProperty<T>(options) {
    override fun getValue(builder: Builder, property: KProperty<*>): T {
        var result = super.getValue(builder, property)
        val filter = options.propertyFilter
        if (null !== filter) {
            result = filterFn(result, filter)
        }

        val map = options.propertyMap
        if (null !== map) {
            result = mapFn(result, map)
        }

        val sanitizer = options.propertySanitizer
        if (null !== sanitizer) {
            return sanitizer(result)
        }
        return result
    }
}