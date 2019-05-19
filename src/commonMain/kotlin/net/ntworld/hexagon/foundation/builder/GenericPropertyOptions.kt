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

    val hasDefaultValue: Boolean
        get() {
            return this::default.isInitialized
        }
}