package net.ntworld.hexagon.foundation.builder

class StringPropertyOptions internal constructor(
    defaultValue: String? = null,
    trim: Boolean = false,
    uppercase: Boolean = false,
    lowercase: Boolean = false,
    sanitize: ((String) -> String)? = null
) : GenericPropertyOptions<String>(defaultValue) {
    var trim: Boolean = trim
    var uppercase: Boolean = uppercase
    var lowercase: Boolean = lowercase
    lateinit var sanitize: (String) -> String

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