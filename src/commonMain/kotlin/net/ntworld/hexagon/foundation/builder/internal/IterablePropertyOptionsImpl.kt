package net.ntworld.hexagon.foundation.builder.internal

import net.ntworld.hexagon.foundation.builder.IterablePropertyOptions

internal class IterablePropertyOptionsImpl<E, T : Any>(
    defaultValue: T? = null,
    map: ((E) -> E)? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((T) -> T)? = null
) : GenericPropertyOptionsImpl<T>(defaultValue), IterablePropertyOptions<E, T> {
    override lateinit var filter: (E) -> Boolean
    override lateinit var map: (E) -> E
    override lateinit var sanitize: (T) -> T

    init {
        if (null !== map) {
            this.map = map
        }

        if (null !== filter) {
            this.filter = filter
        }

        if (null !== sanitize) {
            this.sanitize = sanitize
        }
    }

    internal val propertyFilter: ((E) -> Boolean)?
        get() {
            if (this::filter.isInitialized) {
                return this.filter
            }
            return null
        }

    internal val propertyMap: ((E) -> E)?
        get() {
            if (this::map.isInitialized) {
                return this.map
            }
            return null
        }

    internal val propertySanitizer: ((T) -> T)?
        get() {
            if (this::sanitize.isInitialized) {
                return this.sanitize
            }
            return null
        }
}