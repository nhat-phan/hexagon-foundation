package net.ntworld.hexagon.foundation.builder

import kotlin.reflect.KProperty

class IterableProperty<E : Any, T : Iterable<E>>(
    private val options: IterablePropertyOptions<E, T>,
    private val filterFn: (T, (E) -> Boolean) -> T
) : GenericProperty<T>(options) {
    override fun getValue(builder: Builder, property: KProperty<*>): T {
        var result = super.getValue(builder, property)
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