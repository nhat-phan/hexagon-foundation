package net.ntworld.hexagon.foundation.builder

open class GenericPropertyOptions<T : Any>(
    name: String? = null,
    defaultValue: T? = null
) {
    lateinit var name: String
    lateinit var default: T

    init {
        if (null !== name) {
            this.name = name
        }

        if (null !== defaultValue) {
            this.default = defaultValue
        }
    }

    internal val propertyName: String?
        get() {
            if (this::name.isInitialized) {
                return this.name
            }
            return null
        }

    internal val propertyDefaultValue: T?
        get() {
            if (this::default.isInitialized) {
                return this.default
            }
            return null
        }
}