package net.ntworld.hexagon.foundation.builder

open class GenericPropertyOptions<T : Any>(
    defaultValue: T? = null
) {
    lateinit var default: T

    init {
        if (null !== defaultValue) {
            this.default = defaultValue
        }
    }

    val propertyDefaultValue: T?
        get() {
            if (this::default.isInitialized) {
                return this.default
            }
            return null
        }
}