package net.ntworld.hexagon.foundation.builder

class ArrayPropertyOptions<T>(
    defaultValue: Array<T>? = null,
    map: ((T) -> T)? = null,
    filter: ((T) -> Boolean)? = null,
    sanitize: ((Array<T>) -> Array<T>)? = null
) {
    lateinit var default: Array<T>
    lateinit var filter: (T) -> Boolean
    lateinit var map: (T) -> T
    lateinit var sanitize: (Array<T>) -> Array<T>

    init {
        if (null !== defaultValue) {
            this.default = defaultValue
        }

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

    val hasDefaultValue: Boolean
        get() {
            return this::default.isInitialized
        }

    val propertyFilter: ((T) -> Boolean)?
        get() {
            if (this::filter.isInitialized) {
                return this.filter
            }
            return null
        }

    val propertyMap: ((T) -> T)?
        get() {
            if (this::map.isInitialized) {
                return this.map
            }
            return null
        }

    val propertySanitizer: ((Array<T>) -> Array<T>)?
        get() {
            if (this::sanitize.isInitialized) {
                return this.sanitize
            }
            return null
        }
}