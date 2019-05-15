package net.ntworld.hexagon.foundation.builder

class IterablePropertyOptions<E : Any, T: Any>(
    defaultValue: T? = null,
    filter: ((E) -> Boolean)? = null,
    map: ((E) -> E)? = null,
    sanitize: ((T) -> T)? = null
) : GenericPropertyOptions<T>(defaultValue) {
    lateinit var filter: (E) -> Boolean
    lateinit var map: (E) -> E
    lateinit var sanitize: (T) -> T

    init {
        if (null !== filter) {
            this.filter = filter
        }

        if (null !== map) {
            this.map = map
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