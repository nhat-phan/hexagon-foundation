package net.ntworld.hexagon.foundation.builder.internal

import net.ntworld.hexagon.foundation.builder.StringPropertyOptions

internal class StringPropertyOptionsImpl internal constructor(
    defaultValue: String? = null,
    trim: Boolean = false,
    uppercase: Boolean = false,
    lowercase: Boolean = false,
    sanitize: ((String) -> String)? = null
) : GenericPropertyOptionsImpl<String>(defaultValue), StringPropertyOptions {
    override var trim: Boolean = trim
    override var uppercase: Boolean = uppercase
    override var lowercase: Boolean = lowercase
    override lateinit var sanitize: (String) -> String

    init {
        if (null !== sanitize) {
            this.sanitize = sanitize
        }
    }

    internal val propertySanitizer: ((String) -> String)?
        get() {
            if (this::sanitize.isInitialized) {
                return this.sanitize
            }
            return null
        }
}