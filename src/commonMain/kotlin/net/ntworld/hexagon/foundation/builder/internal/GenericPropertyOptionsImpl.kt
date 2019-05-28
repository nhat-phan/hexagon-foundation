package net.ntworld.hexagon.foundation.builder.internal

import net.ntworld.hexagon.foundation.builder.GenericPropertyOptions

internal open class GenericPropertyOptionsImpl<T: Any>(
    defaultValue: T? = null
) : GenericPropertyOptions<T> {
    override lateinit var default: T

    init {
        if (null !== defaultValue) {
            this.default = defaultValue
        }
    }

    override val hasDefaultValue: Boolean
        get() {
            return this::default.isInitialized
        }
}