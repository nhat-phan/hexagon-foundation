package net.ntworld.hexagon.foundation.builder

class IterablePropertyOptions<E : Any, T : Iterable<E>>(
    name: String? = null,
    defaultValue: T? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((T) -> T)? = null
) : GenericPropertyOptions<T>(name, defaultValue) {
    lateinit var filter: (E) -> Boolean
    lateinit var sanitize: (T) -> T

    init {
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

    internal val propertySanitizer: ((T) -> T)?
        get() {
            if (this::sanitize.isInitialized) {
                return this.sanitize
            }
            return null
        }
}